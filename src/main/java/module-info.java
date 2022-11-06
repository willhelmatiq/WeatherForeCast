module space.harbour.weatherforecast {
    requires javafx.controls;
    requires javafx.fxml;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires lombok;
    requires com.google.gson;
    requires org.controlsfx.controls;


    opens space.harbour.weatherforecast to javafx.fxml, retrofit2, retrofit2.converter.gson, javafx.controls;
    opens space.harbour.weatherforecast.model to retrofit2, retrofit2.converter.gson, com.google.gson;
    exports space.harbour.weatherforecast;
}