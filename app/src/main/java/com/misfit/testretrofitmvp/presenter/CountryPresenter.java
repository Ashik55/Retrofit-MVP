package com.misfit.testretrofitmvp.presenter;


import com.misfit.testretrofitmvp.model.Country;
import com.misfit.testretrofitmvp.model.Data;
import com.misfit.testretrofitmvp.service.CountryService;
import com.misfit.testretrofitmvp.view.CountryView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryPresenter {

    private CountryView countryView;
    private CountryService countryService;

    public CountryPresenter(CountryView view) {
        this.countryView = view;

        if (this.countryService == null) {
            this.countryService = new CountryService();
        }
    }

    public void getCountries() {
        countryService
                .getAPI()
                .getResults()
                .enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        Data data = response.body();

                        if (data != null && data.getRestResponse() != null) {
                            List<Country> result = data.getRestResponse().getResult();
                            countryView.countriesReady(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
