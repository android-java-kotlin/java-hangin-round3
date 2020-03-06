package com.m7amdelbana.haninround3.network.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SignForm implements Serializable {

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public SignForm(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
