package com.contacts.app.screen.home.contacts;

import com.contacts.base.BasePresenter;
import com.contacts.app.screen.home.contacts.ContactsContract.*;
import com.contacts.data.database.ContactsDatabase;
import com.contacts.data.model.contacts.Contact;
import com.contacts.data.repository.ContactsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ContactsPresenter extends BasePresenter<View> implements Presenter {

    private final ContactsRepository contactsRepository;
    private final ContactsDatabase contactsDatabase;

    @Inject
    public ContactsPresenter(
            View view,
            ContactsRepository contactsRepository,
            ContactsDatabase contactsDatabase
    ) {
        super(view);
        this.contactsRepository = contactsRepository;
        this.contactsDatabase = contactsDatabase;
    }

    @Override
    public void fetchContacts() {
        Disposable disposable = contactsRepository.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        contacts -> {
                            saveContacts(contacts);
                            view.handleContacts(contacts);
                        },
                        throwable -> view.showToast(throwable.getMessage())
                );
        compositeDisposable.add(disposable);
    }

    @Override
    public void saveContact(Contact contact) {
        Disposable disposable = contactsDatabase.insertOrUpdate(contact).subscribe();
        compositeDisposable.add(disposable);
    }

    @Override
    public void removeContact(Contact contact) {
        Disposable disposable = contactsDatabase.remove(contact.uid).subscribe();
        compositeDisposable.add(disposable);
    }

    private void saveContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            saveContact(contact);
        }
    }
}
