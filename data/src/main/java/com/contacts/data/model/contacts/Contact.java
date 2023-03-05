package com.contacts.data.model.contacts;

import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("id")
    public Long id;

    @SerializedName("uid")
    public String uid;

    @SerializedName("password")
    public String password;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("username")
    public String username;

    @SerializedName("email")
    public String email;

    @SerializedName("avatar")
    public String avatar;

    @SerializedName("gender")
    public String gender;

    @SerializedName("phone_number")
    public String phoneNumber;

    @SerializedName("social_insurance_number")
    public String socialInsuranceNumber;

    @SerializedName("date_of_birth")
    public String dateOfBirth;

    @SerializedName("employment")
    public Employment employment;

    @SerializedName("address")
    public Address address;

    @SerializedName("creditCard")
    public CreditCard creditCard;

    @SerializedName("subscription")
    public Subscription subscription;

    public Boolean isFavorite = false;

    public String getFullName() {
        return firstName +" " +lastName;
    }
}
