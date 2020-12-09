package com.misfit.testretrofitmvp.view;

import com.misfit.testretrofitmvp.model.Country;
import java.util.List;

public interface CountryView {

    void countriesReady(List<Country> countries);
}
