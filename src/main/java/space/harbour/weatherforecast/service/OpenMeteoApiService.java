package space.harbour.weatherforecast.service;

import retrofit2.http.Query;
import retrofit2.Call;
import retrofit2.http.GET;
import space.harbour.weatherforecast.model.WeatherEntity;


public interface OpenMeteoApiService {
    @GET("v1/forecast")
    Call<WeatherEntity> getCurrentWeather(@Query("latitude") double latitude,
                                          @Query("longitude") double longitude,
                                          @Query("current_weather") boolean current_weather);
}
