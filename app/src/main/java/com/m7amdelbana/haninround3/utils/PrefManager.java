package com.m7amdelbana.haninround3.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    private static final String USER_EXIST = "userExist";

    public static void setUserState(Activity activity, boolean isUserLogin) {
        SharedPreferences.Editor editor = activity.getPreferences(Context.MODE_PRIVATE).edit();
        editor.putBoolean(USER_EXIST, isUserLogin);
        editor.apply();
    }

    public static boolean getUserState(Activity activity) {
        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        return preferences.getBoolean(USER_EXIST, false);
    }
}
