package com.m7amdelbana.haninround3.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.m7amdelbana.haninround3.R;

public class SignUpActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initToolbar();

        imgToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.app_bar_layout);
        imgToolbar = findViewById(R.id.toolbar_back_imageView);
        setSupportActionBar(toolbar);
    }
}
