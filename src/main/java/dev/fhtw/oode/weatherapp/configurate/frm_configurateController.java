package dev.fhtw.oode.weatherapp.configurate;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class frm_configurateController {

    @FXML
    private Button bt_searchLocation;

    @FXML
    private Button bt_selectLocation;

    @FXML
    private FontAwesomeIconView bt_update_uprate;

    @FXML
    private Button bt_updatelocationAPIKey;

    @FXML
    private Button bt_updateweatherAPIKey;

    @FXML
    private Label lb_locsetup_log;

    @FXML
    private ListView<?> lv_Locations;

    @FXML
    private RadioButton rb_imperialunits;

    @FXML
    private RadioButton rb_metricunits;

    @FXML
    private TextField tb_locationAPIKey;

    @FXML
    private TextField tb_uprate_hh;

    @FXML
    private TextField tb_uprate_mm;

    @FXML
    private TextField tb_uprate_ss;

    @FXML
    private TextField tb_weatherAPIKey;

    @FXML
    private TextField tf_serachLocation;

    @FXML
    void bt_searchLocationButtonClicked(ActionEvent event) {

        String loc_searchString = tf_serachLocation.getText().toString();
        System.out.println(loc_searchString);

        if(StringUtils.isAlphanumeric(loc_searchString))
        {
            List<Configuration.Location> foundLocations = new ArrayList<Configuration.Location>();
            Configuration.Location new_location = new Configuration.Location();
            foundLocations = new_location.get_locationsList(loc_searchString);

            if(!foundLocations.isEmpty())
            {
                ObservableList<Configuration.Location> obsfoundLocations = FXCollections.observableList(foundLocations);
                //lv_Locations.setItems(obsfoundLocations);
            }
        }

    }

    @FXML
    void bt_selectLocationButtonClicked(ActionEvent event) {

    }

    @FXML
    void bt_update_uprate_ButtonClicked(MouseEvent event) {

    }

    @FXML
    void bt_updatelocationAPIKey_ButtonClicked(MouseEvent event) {

    }

    @FXML
    void bt_updateweatherAPIKey_ButtonClicked(MouseEvent event) {

    }

    @FXML
    void rb_imperialunits_Action(ActionEvent event) {

    }

    @FXML
    void rb_metricunits_Action(ActionEvent event) {

    }

    @FXML
    void tb_uprate_hh_Action(ActionEvent event) {

    }

    @FXML
    void tb_uprate_mm_Action(ActionEvent event) {

    }

    @FXML
    void tb_uprate_ss_Action(ActionEvent event) {

    }

}
