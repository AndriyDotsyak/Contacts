package com.contacts.data.model.contacts;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class CreditCard extends RealmObject {

    @SerializedName("cc_number")
    public String cardNumber;

}
