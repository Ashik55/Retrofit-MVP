package com.misfit.testretrofitmvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.misfit.testretrofitmvp.R;
import com.misfit.testretrofitmvp.model.Country;
import com.misfit.testretrofitmvp.presenter.CountryPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CountryView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountryPresenter countryPresenter = new CountryPresenter(this);

        // Maybe it's best to call it on onResume()
        countryPresenter.getCountries();
    }



    @Override
    public void countriesReady(List<Country> countries) {

        for (Country country : countries) {
            Log.i("RETROFIT", country.getName() + "\n"
                    + " - Alpha2:  " + country.getAlphaCode2() + " \n"
                    + " - Alpha3: " + country.getAlphaCode3());
        }
    }
}