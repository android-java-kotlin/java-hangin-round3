package com.m7amdelbana.haninround3.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;

import com.m7amdelbana.haninround3.R;
import com.m7amdelbana.haninround3.ui.auth.SignInActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Dialog dialog = new Dialog(this);
        assert dialog.getWindow() != null;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_loading);
        dialog.show();
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
