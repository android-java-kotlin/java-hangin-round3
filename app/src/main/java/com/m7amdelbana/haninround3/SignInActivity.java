package com.m7amdelbana.haninround3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity {


    @BindView(R.id.signIn_email_editText)
    EditText edtEmail;
    @BindView(R.id.signIn_password_editText)
    EditText edtPassword;
    @BindView(R.id.signIn_forget_button)
    Button btnForgetPassword;
    @BindView(R.id.signIn_button)
    Button btnSign;
    @BindView(R.id.signIn_signUp_button)
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
    }
}
