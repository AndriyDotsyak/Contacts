package com.contacts.app.screen.home.favorites;

import com.contacts.base.BasePresenter;
import com.contacts.app.screen.home.favorites.FavoritesContract.*;
import com.contacts.data.database.ContactsDatabase;
import com.contacts.data.model.contacts.Contact;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FavoritesPresenter extends BasePresenter<View> implements Presenter {

    private final ContactsDatabase contactsDatabase;

    @Inject
    public FavoritesPresenter(
            View view,
            ContactsDatabase contactsDatabase
    ) {
        super(view);
        this.contactsDatabase = contactsDatabase;
    }

    @Override
    public void fetchContacts() {
        Disposable disposable = contactsDatabase.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        contacts -> view.handleContacts(contacts),
                        throwable -> view.showToast(throwable.getMessage())
                );
        compositeDisposable.add(disposable);
    }

    @Override
    public void addFavorite(Contact contact) {
        Disposable disposable = contactsDatabase.insertOrUpdate(contact)
                .subscribe(item -> fetchContacts());
        compositeDisposable.add(disposable);
    }

    @Override
    public void removeFavorite(Contact contact) {
        Disposable disposable = contactsDatabase.remove(contact.uid)
                .subscribe(item -> fetchContacts());
        compositeDisposable.add(disposable);
    }
}
