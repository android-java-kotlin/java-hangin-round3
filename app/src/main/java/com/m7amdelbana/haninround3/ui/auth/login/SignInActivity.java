package com.m7amdelbana.haninround3.ui.auth.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.m7amdelbana.haninround3.R;
import com.m7amdelbana.haninround3.ui.auth.SignUpActivity;
import com.m7amdelbana.haninround3.ui.main.MainActivity;
import com.m7amdelbana.haninround3.utils.LoadingDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity implements LoginView {

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

    private LoginPresenter loginPresenter;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(new LoginIntractor(), this, this);
        loadingDialog = new LoadingDialog(this);
    }

    @OnClick({R.id.signIn_button, R.id.signIn_signUp_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.signIn_button:
                loginPresenter.login(edtEmail.getText().toString(), edtPassword.getText().toString());
                break;
            case R.id.signIn_signUp_button:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
        }
    }

    @Override
    public void showLoading() {
        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
        loadingDialog.hide();
    }

    @Override
    public void empty(String key) {
        switch (key) {
            case "email":
                edtEmail.setError("Email is empty");
                break;
            case "password":
                edtPassword.setError("Password is empty");
                break;
        }
    }

    @Override
    public void successLogin() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void failedLogin() {
        Toast.makeText(this, "Failed Login", Toast.LENGTH_SHORT).show();
    }
}
