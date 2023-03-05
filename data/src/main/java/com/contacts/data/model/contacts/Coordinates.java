package com.contacts.data.model.contacts;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Coordinates extends RealmObject {

    @SerializedName("lat")
    public Double lat;

    @SerializedName("lng")
    public Double lng;

}
