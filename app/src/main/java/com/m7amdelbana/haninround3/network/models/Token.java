package com.m7amdelbana.haninround3.network.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Token implements Serializable {

    @SerializedName("x-auth-token")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
