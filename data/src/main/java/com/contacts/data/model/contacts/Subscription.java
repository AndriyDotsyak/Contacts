package com.contacts.data.model.contacts;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Subscription extends RealmObject {

    @SerializedName("plan")
    public String plan;

    @SerializedName("status")
    public String status;

    @SerializedName("payment_method")
    public String paymentMethod;

    @SerializedName("term")
    public String term;

}
