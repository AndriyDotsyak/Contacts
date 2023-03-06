package com.contacts.app.screen.home.contact_detail;

import com.contacts.app.screen.home.contact_detail.ContactDetailContract.*;
import com.contacts.base.BasePresenter;
import com.contacts.data.database.ContactsDatabase;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ContactDetailPresenter extends BasePresenter<View> implements Presenter {

    private final ContactsDatabase contactsDatabase;

    @Inject
    public ContactDetailPresenter(
            View view,
            ContactsDatabase contactsDatabase
    ) {
        super(view);
        this.contactsDatabase = contactsDatabase;
    }

    @Override
    public void fetchContact(String uid) {
        Disposable disposable = contactsDatabase.getItemById(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        contact -> view.handleContact(contact),
                        throwable -> view.showToast(throwable.getMessage())
                );
        compositeDisposable.add(disposable);
    }
}
