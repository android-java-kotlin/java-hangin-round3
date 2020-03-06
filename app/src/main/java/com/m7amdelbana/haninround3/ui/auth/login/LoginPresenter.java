package com.m7amdelbana.haninround3.ui.auth.login;

import android.app.Activity;

import com.m7amdelbana.haninround3.network.models.Token;
import com.m7amdelbana.haninround3.utils.PrefManager;

public class LoginPresenter implements LoginIntractor.LoginIntractorListener {

    private LoginIntractor loginIntractor;
    private LoginView loginView;
    private Activity activity;

    public LoginPresenter(LoginIntractor loginIntractor, LoginView loginView, Activity activity) {
        this.loginIntractor = loginIntractor;
        this.loginView = loginView;
        this.activity = activity;
    }

    void login(String email, String password) {
        if (email.isEmpty()) {
            loginView.empty("email");
        } else if (password.isEmpty()) {
            loginView.empty("password");
        } else {
            loginView.showLoading();
            loginIntractor.login(email, password, this);
        }
    }

    @Override
    public void onResponse(Token token) {
        PrefManager.setUserAccessToken(activity, token.getAccessToken());
        loginView.hideLoading();
        loginView.successLogin();
    }

    @Override
    public void onFailure(String error) {
        loginView.hideLoading();
        loginView.failedLogin();
    }
}
