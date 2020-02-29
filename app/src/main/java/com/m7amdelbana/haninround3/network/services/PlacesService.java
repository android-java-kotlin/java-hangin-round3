package com.m7amdelbana.haninround3.network.services;

import com.m7amdelbana.haninround3.network.api.APIConstants;
import com.m7amdelbana.haninround3.network.models.Place;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlacesService {

    @GET(APIConstants.SERVICE_PLACES)
    Call<List<Place>> getPlaces();
}
