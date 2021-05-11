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
    @FXML
    public TextField Arrivals;
    @FXML
    public TextField Arrivaldate;
    @FXML
    public TextField departures;
    @FXML
    public TextField Departuredate;
    @FXML
    public TextField PlaneTypes;
   

    @FXML
    public TableColumn<Integer,Flights> ArrivalIDCoulmn;
    @FXML
    public TableColumn<String, Flights> ArrivalsColumn;
    @FXML
    public TableColumn<String, Flights> ArrivalDateCoulmn;
  
    @FXML
    public TableColumn<Integer,Flights> DepartureIDCoulmn;
    @FXML
    public TableColumn<String, Flights> DeparturesCoulmn;
    @FXML
    public TableColumn<String, Flights> DepartureeDateCoulmn;
  
    @FXML
    public TableColumn<Integer,Flights> PlaneIDCoulmn;
    @FXML
    public TableColumn<String, Flights> PlaneTypesCoulmn;
    @FXML
    public TableView ArrivalTableview;
    @FXML
    public TableView DepartureTableview;
    @FXML
    public TableView PlaneTableview;


    private ViewHandler vh;
    private adminFlightViewModel av;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        av = vmf.getadminViewModel();
        av.loadFlights();
        av.loadArrival();
        av.loadPlane();
        av.loadDeparture();

        FlightIdCoulmn.setCellValueFactory(new PropertyValueFactory<>("FlightID"));
        FlightNameColumn.setCellValueFactory(new PropertyValueFactory<>("flightName"));
        PriceCoulmn.setCellValueFactory(new PropertyValueFactory<>("price"));

        PlaneIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("PlaneId"));
        PlaneTypesCoulmn.setCellValueFactory(new PropertyValueFactory<>("PlaneType"));


        DepartureIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("DepartureID"));
        DeparturesCoulmn.setCellValueFactory(new PropertyValueFactory<>("Departure"));
        DepartureeDateCoulmn.setCellValueFactory(new PropertyValueFactory<>("DepartureDate"));


        ArrivalIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("ArrivalID"));
        ArrivalsColumn.setCellValueFactory(new PropertyValueFactory<>("Arrival"));
        ArrivalDateCoulmn.setCellValueFactory(new PropertyValueFactory<>("ArrivalDate"));

        FlightName.textProperty().bindBidirectional(av.flightNameProperty());
        FlightID.textProperty().bindBidirectional(av.flightIdProperty());
        Price.textProperty().bindBidirectional(av.priceProperty());
        Arrivals.textProperty().bindBidirectional(av.arrivalsProperty());
        Arrivaldate.textProperty().bindBidirectional(av.arrivalDateProperty());
        departures.textProperty().bindBidirectional(av.departuresProperty());
        Departuredate.textProperty().bindBidirectional(av.departureDateProperty());
        PlaneTypes.textProperty().bindBidirectional(av.planeTypesProperty());
        FlightTableview.setItems(av.getFlightsList());
        ArrivalTableview.setItems(av.getArrivalsList());
        DepartureTableview.setItems(av.getDepatures());
        PlaneTableview.setItems(av.getPlanetyp());
    }


    public void onDelete(ActionEvent actionEvent) {


    }

    public void onBack(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onLogOff(ActionEvent actionEvent) {
    }

    public void onAdd(ActionEvent actionEvent) {
        av.InsertArrivalInformation();
        av.InsertDepartureInformation();
        av.InsertPlaneInformation();
        av.InsertFlightInformation();
    }
}
