package space.harbour.weatherforecast.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.controlsfx.control.WorldMapView;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import space.harbour.weatherforecast.model.WeatherEntity;
import space.harbour.weatherforecast.util.Constants;

import java.io.IOException;

public class OpenMeteoService {

    private OpenMeteoApiService api;

    public OpenMeteoService() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm").create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.WEATHERURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        api = retrofit.create(OpenMeteoApiService.class);
    }

    public WeatherEntity getCurrentWeather(WorldMapView.Location location){
        Call<WeatherEntity> currentWeatherCall = api.getCurrentWeather(location.getLatitude(), location.getLongitude(), true);
        try {
            Response<WeatherEntity> response = currentWeatherCall.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
