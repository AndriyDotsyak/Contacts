package com.contacts.app.screen.home.contacts;

import com.contacts.base.BasePresenter;
import com.contacts.app.screen.home.contacts.ContactsContract.*;

import javax.inject.Inject;

public class ContactsPresenter extends BasePresenter<View> implements Presenter {

    @Inject
    public ContactsPresenter(View view) {
        super(view);
    }

}
