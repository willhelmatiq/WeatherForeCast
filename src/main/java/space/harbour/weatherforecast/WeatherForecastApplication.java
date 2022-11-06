package space.harbour.weatherforecast;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherForecastApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherForecastApplication.class.getResource("map.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Current Weather");
        Image logo = new Image("file:src/main/resources/space/harbour/weatherforecast/weather-logo.png");
        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}