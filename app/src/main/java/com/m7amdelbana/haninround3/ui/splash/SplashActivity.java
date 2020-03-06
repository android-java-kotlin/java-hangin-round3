package com.m7amdelbana.haninround3.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.m7amdelbana.haninround3.R;
import com.m7amdelbana.haninround3.ui.auth.login.SignInActivity;
import com.m7amdelbana.haninround3.ui.main.MainActivity;
import com.m7amdelbana.haninround3.utils.PrefManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        // Get
//        SharedPreferences sharedPreferences =
//                PreferenceManager.getDefaultSharedPreferences(this);
//        String access = sharedPreferences.getString("KEY", "");
//
//        // Put
//        SharedPreferences.Editor editor =
//                PreferenceManager.getDefaultSharedPreferences(this).edit();
//        editor.putString("KEY", "vnjfgjnrghiutnu");
//        editor.apply();

//        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
//        String access = sharedPreferences.getString("KEY", "");
//
//        SharedPreferences.Editor editor = getPreferences(Context.MODE_PRIVATE).edit();
//        editor.putString("KEY", "vnjfgjnrghiutnu");
//        editor.apply();

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        builder.setTitle("Close the app");
//        builder.setMessage("Are your sure you want to close the app?");
//        builder.setPositiveButton("Cancel", (dialog, which) ->
//            Toast.makeText(SplashActivity.this, "Cancel", Toast.LENGTH_SHORT).show()
//        );
//
//        builder.setNegativeButton("OK", (dialog, which) ->
//                Toast.makeText(SplashActivity.this, "OK", Toast.LENGTH_SHORT).show());
//        builder.show();

//        Dialog dialog = new Dialog(this);

        // assert dialog.getWindow() != null;

//        try {
//            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            dialog.setContentView(R.layout.dialog_loading);
//            dialog.show();
//        } catch (NullPointerException ex) {
//            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
//        }

//        LoadingDialog loadingDialog = new LoadingDialog(this);
//        loadingDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(this::navigate, 3000);
    }

    void navigate() {
        Log.v("getUserAccessToken", PrefManager.getUserAccessToken(this));
        if (PrefManager.getUserAccessToken(this).equals("")) {
            startActivity(new Intent(this, SignInActivity.class));
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
