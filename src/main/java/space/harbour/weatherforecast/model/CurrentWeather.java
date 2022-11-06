package space.harbour.weatherforecast.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CurrentWeather {

    double temperature;
    @SerializedName(value = "windspeed")
    double windSpeed;
    @SerializedName(value = "weathercode")
    int weatherCode;

}
