package com.misfit.testretrofitmvp.service;



import com.misfit.testretrofitmvp.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface CountryAPI {

    @GET("country/get/all")
    Call<Data> getResults();

    @GET("country/get/iso2code/{alpha2_code}")
    Call<Data> getByAlpha2Code(@Path("alpha2_code") String alpha2Code);
}
