module dev.fhtw.oode.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.fhtw.oode.weatherapp to javafx.fxml;
    exports dev.fhtw.oode.weatherapp;
}