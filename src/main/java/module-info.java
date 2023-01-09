module dev.fhtw.oode.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.apache.commons.lang3;
    requires de.jensd.fx.glyphs.fontawesome;
    requires com.fasterxml.jackson.databind;
    requires android.json;


    opens dev.fhtw.oode.weatherapp to javafx.fxml;
    exports dev.fhtw.oode.weatherapp;
    exports dev.fhtw.oode.weatherapp.configurate;
    opens dev.fhtw.oode.weatherapp.configurate to javafx.fxml;
}