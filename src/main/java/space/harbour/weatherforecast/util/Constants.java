package space.harbour.weatherforecast.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public final static String WEATHERURL = "https://api.open-meteo.com/";
    public final static String COUNTRYRURL = "https://restcountries.com/";
    public final static String temperatureLable = "temperature: ";
    public final static String windSpeedLable = "wind speed: ";

    public final static Map<Integer, String> weatherCodesDescription = new HashMap<>();
    static {
        weatherCodesDescription.put(0, "Clear sky");
        weatherCodesDescription.put(1, "Mainly clear");
        weatherCodesDescription.put(2, "Partly cloudy");
        weatherCodesDescription.put(3, "Overcast");
        weatherCodesDescription.put(45, "Fog");
        weatherCodesDescription.put(48, "Depositing rime fog");
        weatherCodesDescription.put(51, "Drizzle: Light");
        weatherCodesDescription.put(53, "Drizzle: Moderate");
        weatherCodesDescription.put(55, "Drizzle: Dense intensity");
        weatherCodesDescription.put(56, "Freezing Drizzle: Light");
        weatherCodesDescription.put(57, "Freezing Dense intensity");
        weatherCodesDescription.put(61, "Rain: Slight");
        weatherCodesDescription.put(63, "Rain: Moderate");
        weatherCodesDescription.put(65, "Rain: Heavy intensity");
        weatherCodesDescription.put(66, "Freezing Rain: Light");
        weatherCodesDescription.put(67, "Freezing Heavy intensity");
        weatherCodesDescription.put(71, "Snow fall: Slight");
        weatherCodesDescription.put(73, "Snow fall: Moderate");
        weatherCodesDescription.put(75, "Snow fall: Heavy intensity");
        weatherCodesDescription.put(77, "Snow grains");
        weatherCodesDescription.put(80, "Rain showers: Slight");
        weatherCodesDescription.put(81, "Rain showers: Moderate");
        weatherCodesDescription.put(82, "Rain showers: Violent");
        weatherCodesDescription.put(95, "Thunderstorm: Slight or moderate");
        weatherCodesDescription.put(96, "Thunderstorm with slight hail");
        weatherCodesDescription.put(99, "Thunderstorm with heavy hail");
    }


}
