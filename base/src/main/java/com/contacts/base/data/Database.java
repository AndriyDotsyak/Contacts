package com.contacts.base.data;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.realm.Realm;
import io.realm.RealmModel;

public abstract class Database<T extends RealmModel> {

    protected ExecutorService executor = Executors.newSingleThreadExecutor();
    protected Realm realm = null;

    Database() {
        executor.submit(() -> {
            realm = Realm.getDefaultInstance();
        });
    }

    protected abstract List<T> fetchAll();

    abstract T fetchItemById(String id);

    abstract Single<Boolean> clearCurrentDatabase();

    public Single<List<T>> getAll() {
        return singleExecuteTransaction(this::fetchAll);
    }

    public Single<T> getItemById(String id) {
        return singleExecuteTransaction(() -> fetchItemById(id));
    }

    public Single<T> insert(T item) {
        return singleExecuteTransaction(() -> {
            realm.insert(item);
            return item;
        });
    }

    public Single<T> insertOrUpdate(T item) {
        return singleExecuteTransaction(() -> {
            realm.insertOrUpdate(item);
            return item;
        });
    }

    public Single<List<T>> insert(List<T> items) {
        return singleExecuteTransaction(() -> {
            realm.insert(items);
            return items;
        });
    }

    public Single<Boolean> isEmpty() {
        return singleExecuteTransaction(() -> fetchAll().isEmpty());
    }

    public Single<Void> deleteAll() {
        return singleExecuteTransaction(() -> {
            realm.deleteAll();
            return null;
        });
    }

    public void refresh() {
        realm = Realm.getDefaultInstance();
    }

    public <O> Single<O> singleExecuteTransaction(Operation<O> operation) {
        return Single.create((SingleOnSubscribe<O>) emitter -> {
            try {
                executeTransaction(realm -> {
                    emitter.onSuccess(operation.execute());
                });
            } catch (Throwable error) {
                emitter.onError(error);
            }
        });
    }

    protected void executeTransaction(Realm.Transaction transaction) {
        executor.submit(() -> {
            realm.executeTransaction(transaction);
        });
    }

    interface Operation<T> {
        T execute();
    }

}
