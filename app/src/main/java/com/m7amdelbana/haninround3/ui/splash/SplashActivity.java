package com.m7amdelbana.haninround3.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.m7amdelbana.haninround3.R;
import com.m7amdelbana.haninround3.ui.auth.SignInActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(this::navigateToMain, 3000);
    }

    void navigateToMain() {
        startActivity(new Intent(this, SignInActivity.class));
    }
}
