package com.contacts.app.screen.home.contacts;

import com.contacts.base.BasePresenter;
import com.contacts.app.screen.home.contacts.ContactsContract.*;
import com.contacts.data.repository.ContactsRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ContactsPresenter extends BasePresenter<View> implements Presenter {

    private final ContactsRepository contactsRepository;

    @Inject
    public ContactsPresenter(View view, ContactsRepository contactsRepository) {
        super(view);
        this.contactsRepository = contactsRepository;
    }

    @Override
    public void fetchContacts() {
        Disposable disposable = contactsRepository.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        contacts -> view.handleContacts(contacts),
                        throwable -> view.showToast(throwable.getMessage())
                );
        compositeDisposable.add(disposable);
    }
}
