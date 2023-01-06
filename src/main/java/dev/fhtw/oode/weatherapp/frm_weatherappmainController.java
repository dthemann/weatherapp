package dev.fhtw.oode.weatherapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class frm_weatherappmainController {

    @FXML
    private ImageView IV_Location;

    @FXML
    private ImageView IV_WeatherForecast;

    @FXML
    private ImageView IV_WeatherNow;

    @FXML
    private Button bt_Configure;

    @FXML
    private Button bt_Update;

    @FXML
    private Label lbl_Log;

    @FXML
    private TextArea ta_Location;

    @FXML
    private TextArea ta_WeatherForecast;

    @FXML
    private TextArea ta_WeatherNow;

    @FXML
    void bt_ConfigureButtonClicked(ActionEvent event) {

    }

    @FXML
    void bt_Configure_Clicked(MouseEvent event) throws IOException {

        try {

            Parent new_root = FXMLLoader.load(getClass().getResource("frm_locationFinder.fxml"));

            Stage stage = new Stage();
            Scene scene = new Scene(new_root);

            stage.setTitle("Location Finder");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

        }
    }

    @FXML
    void bt_UpdateButtonClicked(ActionEvent event) {

    }

    @FXML
    void bt_Update_Clicked(MouseEvent event) {

    }

}
