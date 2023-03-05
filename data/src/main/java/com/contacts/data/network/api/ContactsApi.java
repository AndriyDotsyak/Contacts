package com.contacts.data.network.api;

import com.contacts.data.model.contacts.Contact;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ContactsApi {

    @GET("api/v2/users")
    Flowable<Contact> getUsers();

}
