package space.harbour.weatherforecast.service;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import space.harbour.weatherforecast.model.Country;
import space.harbour.weatherforecast.util.Constants;

import java.io.IOException;
import java.util.List;

public class CountriesService {
    private CountriesApiService api;

    public CountriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.COUNTRYRURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(CountriesApiService.class);
    }

    public List<Country> getAllCountries() {
        Call<List<Country>> allCountriesCall = api.getAllCountries();
        try {
            Response<List<Country>> response = allCountriesCall.execute();
            return response.body();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }
}
