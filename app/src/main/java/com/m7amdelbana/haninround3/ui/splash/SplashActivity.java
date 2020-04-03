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
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(this::navigate, 3000);
    }

    void navigate() {
//        if (PrefManager.getUserAccessToken(this).equals("")) {
//            startActivity(new Intent(this, SignInActivity.class));
//        } else {
            startActivity(new Intent(this, MainActivity.class));
//        }
    }
}
