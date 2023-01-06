package dev.fhtw.oode.weatherapp.location;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class frm_locationFinderController {

    @FXML
    private Button bt_searchLocation;

    @FXML
    private Button bt_selectLocation;

    @FXML
    private Label lb_locsetup_log;

    @FXML
    private ListView<?> lv_Locations;

    @FXML
    private TextField tf_serachLocation;

    @FXML
    void bt_searchLocationButtonClicked(ActionEvent event) {

        String loc_searchString;
        loc_searchString = tf_serachLocation.getText().toString();

        System.out.println(loc_searchString);

    }

    @FXML
    void bt_selectLocationButtonClicked(ActionEvent event) {

    }

}
