package com.m7amdelbana.haninround3.ui.auth.login;

public interface LoginView {

    void showLoading();

    void hideLoading();

    void empty(String key);

    void successLogin();

    void failedLogin();
}
