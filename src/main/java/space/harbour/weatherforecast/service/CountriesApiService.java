package space.harbour.weatherforecast.service;

import retrofit2.Call;
import retrofit2.http.GET;
import space.harbour.weatherforecast.model.Country;

import java.util.List;

public interface CountriesApiService {

    @GET("/v3.1/all")
    Call<List<Country>> getAllCountries();
}
