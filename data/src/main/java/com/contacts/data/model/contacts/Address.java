package com.contacts.data.model.contacts;

import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("city")
    public String city;

    @SerializedName("street_name")
    public String streetName;

    @SerializedName("street_address")
    public String streetAddress;

    @SerializedName("zip_code")
    public String zipCode;

    @SerializedName("state")
    public String state;

    @SerializedName("country")
    public String country;

    @SerializedName("coordinates")
    public Coordinates coordinates;

}
