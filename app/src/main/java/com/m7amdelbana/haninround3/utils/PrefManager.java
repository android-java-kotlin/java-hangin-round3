package com.m7amdelbana.haninround3.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    private static final String USER_TOKEN = "userToken";

    public static void setUserAccessToken(Activity activity, String accessToken) {
        SharedPreferences.Editor editor = activity.getPreferences(Context.MODE_PRIVATE).edit();
        editor.putString(USER_TOKEN, accessToken);
        editor.apply();
    }

    public static String getUserAccessToken(Activity activity) {
        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        return preferences.getString(USER_TOKEN, "");
    }
}
