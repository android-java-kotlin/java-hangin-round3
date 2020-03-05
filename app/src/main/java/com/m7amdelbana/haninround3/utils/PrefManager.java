package com.m7amdelbana.haninround3.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefManager {

    private static final String USER_EXIST = "userExist";

    public static void setUserState(Context context, boolean isUserLogin) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(USER_EXIST, isUserLogin);
        editor.apply();


        SharedPreferences.Editor editor1 = PreferenceManager.getDefaultSharedPreferences(context).edit();




    }

    public static boolean getUserState(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(USER_EXIST, false);
    }
}
