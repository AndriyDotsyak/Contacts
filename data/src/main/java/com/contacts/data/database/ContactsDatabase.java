package com.contacts.data.database;

import com.contacts.base.data.Database;
import com.contacts.data.model.contacts.Contact;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.realm.RealmResults;

public class ContactsDatabase extends Database<Contact> {

    private final String FIELD_UID = "uid";
    private final String FIELD_FAVORITE = "isFavorite";

    @Inject
    public ContactsDatabase() { }

    @Override
    protected List<Contact> fetchAll() {
        RealmResults<Contact> items = realm.where(Contact.class).findAll();
        return realm.copyFromRealm(items);
    }

    @Override
    protected Contact fetchItemById(String id) {
        Contact item = realm.where(Contact.class).equalTo(FIELD_UID, id).findFirst();
        if (item != null) {
            return realm.copyFromRealm(item);
        } else {
            return null;
        }
    }

    @Override
    protected void removeItemById(String id) {
        RealmResults<Contact> items = realm.where(Contact.class).equalTo(FIELD_UID, id).findAll();
        items.deleteAllFromRealm();
    }

    public Single<List<Contact>> getFavoritesContacts() {
        return singleExecuteTransaction(() -> {
            RealmResults<Contact> items = realm.where(Contact.class).equalTo(FIELD_FAVORITE, true).findAll();
            return realm.copyFromRealm(items);
        });
    }

    @Override
    protected Single<Boolean> clearCurrentDatabase() {
        return singleExecuteTransaction(() -> {
            realm.delete(Contact.class);
            return true;
        });
    }

}
