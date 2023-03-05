package com.contacts.base.data;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.Single;
import io.realm.Realm;
import io.realm.RealmModel;
import timber.log.Timber;

public abstract class Database<T extends RealmModel> {

    protected ExecutorService executor = Executors.newSingleThreadExecutor();
    protected Realm realm = null;

    public Database() {
        executor.submit(() -> {
            realm = Realm.getDefaultInstance();
        });
    }

    protected abstract List<T> fetchAll();

    protected abstract T fetchItemById(String id);

    protected abstract void removeItemById(String id);

    protected abstract Single<Boolean> clearCurrentDatabase();

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

    public Single<Boolean> remove(String id) {
        return singleExecuteTransaction(() -> {
            removeItemById(id);
            return true;
        });
    }

    public Single<Boolean> isEmpty() {
        return singleExecuteTransaction(() -> fetchAll().isEmpty());
    }

    public Single<Boolean> deleteAll() {
        return singleExecuteTransaction(() -> {
            realm.deleteAll();
            return true;
        });
    }

    public void refresh() {
        realm = Realm.getDefaultInstance();
    }

    public <O> Single<O> singleExecuteTransaction(Operation<O> operation) {
        return Single.create(emitter -> {
            executeTransaction(realm -> {
                emitter.onSuccess(operation.execute());
            }, emitter::onError);
        });
    }

    protected void executeTransaction(Realm.Transaction transaction) {
        executeTransaction(transaction, Timber::e);
    }

    protected void executeTransaction(Realm.Transaction transaction, Error error) {
        executor.submit(() -> {
            try {
                realm.executeTransaction(transaction);
            } catch (Exception exception) {
                error.onError(exception);
            }
        });
    }

    public interface Operation<T> {
        T execute();
    }

    public interface Error {
        void onError(Exception error);
    }

}
