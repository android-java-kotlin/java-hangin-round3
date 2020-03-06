package com.m7amdelbana.haninround3.ui.auth.login;

import com.m7amdelbana.haninround3.network.api.APIClient;
import com.m7amdelbana.haninround3.network.models.SignForm;
import com.m7amdelbana.haninround3.network.models.Token;
import com.m7amdelbana.haninround3.network.services.AuthService;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginIntractor {

    interface LoginIntractorListener {

        void onResponse(Token token);

        void onFailure(String error);
    }

    void login(String email, String password, LoginIntractorListener listener) {
        SignForm signForm = new SignForm(email, password);
        AuthService authService = APIClient.getClient().create(AuthService.class);

        authService.signIn(signForm).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(@NotNull Call<Token> call, @NotNull Response<Token> response) {
                if (response.isSuccessful()) {
                    listener.onResponse(response.body());
                } else {
                    listener.onFailure("Invalid email or password.");
                }
            }

            @Override
            public void onFailure(@NotNull Call<Token> call, @NotNull Throwable t) {
                listener.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
