package space.harbour.weatherforecast;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import space.harbour.weatherforecast.model.Country;
import space.harbour.weatherforecast.model.WeatherEntity;
import space.harbour.weatherforecast.service.CountriesService;
import space.harbour.weatherforecast.service.OpenMeteoService;
import org.controlsfx.control.WorldMapView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static space.harbour.weatherforecast.util.Constants.*;

public class Controller implements Initializable {

    public WorldMapView worldMap;

    @FXML
    public TextField textField;
    @FXML
    private Label temperature;
    @FXML
    private Label windSpeed;
    @FXML
    private Label weatherCode;

    private List<Country> countries;

    public Controller() {
    }

    @FXML
    public void showData(ActionEvent actionEvent) {
        if (!textField.getText().isBlank()) {
            if (worldMap.getSelectedLocations().size() == 0 || !textField.getText().equalsIgnoreCase(worldMap.getSelectedLocations().get(0).getName())) {
                setSelectedLocationByTextField();
            }
            OpenMeteoService openMeteoService = new OpenMeteoService();
            WeatherEntity weatherEntity = openMeteoService.getCurrentWeather(worldMap.getSelectedLocations().get(0));
            showForecast(weatherEntity);
        }


    }


    private void setSelectedLocationByTextField() {
         Country countryCapital = countries.stream().filter(country -> {
             if (country.getCapital() != null && country.getCapital()[0].equalsIgnoreCase(textField.getText())){
                 return true;
             }
             return false;
         }).findFirst().get();
        WorldMapView.Location typedLocation = worldMap.getLocations().stream().filter(location -> {
            if (location.getName().equals(countryCapital.getCapital()[0])){
                return true;
            }
            return false;
        }).findFirst().get();
        if(worldMap.getSelectedLocations().size() > 0) {
            worldMap.getSelectedLocations().remove(0);
        }
        worldMap.getSelectedLocations().add(typedLocation);


    }
    @FXML
    public void showCity(MouseEvent mouseEvent) {
        ObservableList<WorldMapView.Location> locations = worldMap.getSelectedLocations();
        if(locations != null && locations.size() > 0) {
            textField.setText(locations.get(0).getName());
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherCode.setWrapText(true);
        CountriesService countriesService = new CountriesService();
        countries = countriesService.getAllCountries();
        for (Country country: countries) {
            if (country.getCapital() == null || country.getCapitalInfo() == null || country.getCapitalInfo().getLatlng() == null) {
                continue;
            }
            worldMap.getLocations()
                    .add(new WorldMapView.Location(country.getCapital()[0],
                            country.getCapitalInfo().getLatlng()[0],
                            country.getCapitalInfo().getLatlng()[1]));
        }
    }

    private void showForecast(WeatherEntity weatherEntity) {
        temperature.setText(temperatureLable + weatherEntity.getCurrentWeather().getTemperature());
        windSpeed.setText(windSpeedLable + (weatherEntity.getCurrentWeather().getWindSpeed()));
        weatherCode.setText(weatherCodesDescription.get(weatherEntity.getCurrentWeather().getWeatherCode()));
    }
}