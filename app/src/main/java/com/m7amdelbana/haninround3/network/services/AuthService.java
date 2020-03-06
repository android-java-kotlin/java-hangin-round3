package com.m7amdelbana.haninround3.network.services;

import com.m7amdelbana.haninround3.network.api.APIConstants;
import com.m7amdelbana.haninround3.network.models.SignForm;
import com.m7amdelbana.haninround3.network.models.Token;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {

    @POST(APIConstants.SERVICE_USERS_LOGIN)
    Call<Token> signIn(@Body SignForm signForm);
}
