package space.harbour.weatherforecast.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherEntity {

    @SerializedName(value = "current_weather")
    private CurrentWeather currentWeather;
}
