package com.m7amdelbana.haninround3.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.m7amdelbana.haninround3.R;

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

    @OnClick({R.id.signIn_button, R.id.signIn_signUp_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.signIn_button:
                break;
            case R.id.signIn_signUp_button:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
        }
    }
}
