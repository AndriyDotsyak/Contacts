package com.contacts.data.repository;

import com.contacts.base.BaseRepository;
import com.contacts.data.model.contacts.Contact;
import com.contacts.data.network.api.ContactsApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class ContactsRepository extends BaseRepository {

    private final ContactsApi api;

    @Inject
    public ContactsRepository(ContactsApi api) {
        this.api = api;
    }

    public Flowable<List<Contact>> getUsers() {
        return api.getUsers().map(Arrays::asList)
                .doOnError(logRequestError("getUsers"));
    }

}
