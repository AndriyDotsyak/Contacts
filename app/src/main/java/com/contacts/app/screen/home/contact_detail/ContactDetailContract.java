package com.contacts.app.screen.home.contact_detail;

import com.contacts.base.BaseContract;
import com.contacts.data.model.contacts.Contact;

public interface ContactDetailContract {

    interface View extends BaseContract.View {
        void handleContact(Contact contact);
    }

    interface Presenter extends BaseContract.Presenter {
        void fetchContact(String uid);
    }

}
