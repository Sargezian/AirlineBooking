package client.views.admin;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.SaveInfo;
import client.views.ViewController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.Flights;

import javax.naming.Binding;

public class adminFlightViewController implements ViewController {


    @FXML public TableView FlightTableview;
    @FXML
    public TextField FlightName;
    @FXML
    public TextField Price;
    @FXML
    public TextField FlightID;
    @FXML
    public TableColumn<String, Flights> FlightIdCoulmn;
    @FXML
    public TableColumn<String,Flights> FlightNameColumn;
    @FXML
    public TableColumn<String,Flights> PriceCoulmn;


    private ViewHandler vh;
    private adminFlightViewModel av;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        av = vmf.getadminViewModel();
        av.loadFlights();

        FlightIdCoulmn.setCellValueFactory(new PropertyValueFactory<>("FlightID"));
        FlightNameColumn.setCellValueFactory(new PropertyValueFactory<>("flightName"));
        PriceCoulmn.setCellValueFactory(new PropertyValueFactory<>("price"));
        FlightName.textProperty().bindBidirectional(av.flightNameProperty());
        FlightID.textProperty().bindBidirectional(av.flightIdProperty());
        Price.textProperty().bindBidirectional(av.priceProperty());
        FlightTableview.setItems(av.getFlights());

    }


    public void onDelete(ActionEvent actionEvent) {


    }

    public void onBack(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onLogOff(ActionEvent actionEvent) {
    }

    public void onAdd(ActionEvent actionEvent) {
        av.InsertFlightInformation();
    }
}
