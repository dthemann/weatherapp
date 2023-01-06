module dev.fhtw.oode.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;


    opens dev.fhtw.oode.weatherapp to javafx.fxml;
    exports dev.fhtw.oode.weatherapp;
    exports dev.fhtw.oode.weatherapp.location;
    opens dev.fhtw.oode.weatherapp.location to javafx.fxml;
}