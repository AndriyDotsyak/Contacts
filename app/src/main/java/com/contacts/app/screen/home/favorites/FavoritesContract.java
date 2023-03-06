package com.contacts.app.screen.home.favorites;

import com.contacts.base.BaseContract;
import com.contacts.data.model.contacts.Contact;

import java.util.List;

public interface FavoritesContract {

    interface View extends BaseContract.View {
        void handleContacts(List<Contact> contacts);
    }

    interface Presenter extends BaseContract.Presenter {
        void fetchContacts();
        void saveContact(Contact contact);
        void removeContact(Contact contact);
    }

}
