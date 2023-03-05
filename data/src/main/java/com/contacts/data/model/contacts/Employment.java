package com.contacts.data.model.contacts;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Employment extends RealmObject {

    @SerializedName("title")
    public String title;

    @SerializedName("key_skill")
    public String keySkill;

}
