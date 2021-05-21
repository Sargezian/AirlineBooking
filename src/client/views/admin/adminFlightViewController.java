package client.views.admin;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.*;

public class adminFlightViewController implements ViewController {

    //flight
    @FXML public TableView<Flights> FlightTableview;
    @FXML public TextField FlightName;
    @FXML public TextField Price;
    @FXML public TextField FlightID;
    @FXML public TableColumn<String, Flights> FlightIdCoulmn;
    @FXML public TableColumn<String,Flights> FlightNameColumn;
    @FXML public TableColumn<String,Flights> PriceCoulmn;

    //arrival
    @FXML public TextField Arrivals;
    @FXML public TextField Arrivaldate;
    @FXML public TableColumn<Integer,Flights> ArrivalIDCoulmn;
    @FXML public TableColumn<String, Flights> ArrivalsColumn;
    @FXML public TableColumn<String, Flights> ArrivalDateCoulmn;
    @FXML public TableView<Arrival> ArrivalTableview;

    //departure
    @FXML public TextField departures;
    @FXML public TextField Departuredate;
    @FXML public TableColumn<Integer,Flights> DepartureIDCoulmn;
    @FXML public TableColumn<String, Flights> DeparturesCoulmn;
    @FXML public TableColumn<String, Flights> DepartureeDateCoulmn;
    @FXML public TableView<Depature> DepartureTableview;

    //planetype
    @FXML public TextField PlaneTypes;
    @FXML public TableColumn<Integer,Flights> PlaneIDCoulmn;
    @FXML public TableColumn<String, Flights> PlaneTypesCoulmn;
    @FXML public TableView<PlaneType> PlaneTableview;

    //airport
    @FXML public TextField airportId;
    @FXML public TextField airportName;
    @FXML public TextField airportCity;
    @FXML public TableView <Airport>AirportTableView;
    @FXML public TableColumn<String,Airport> AirportIdCoulmn;
    @FXML public TableColumn<String,Airport> AirportNameCoulmn;
    @FXML public TableColumn<String,Airport> AirportCityCoulmn;

    //seat
    @FXML public TextField seatNumber;
    @FXML public TextField classType;
    @FXML public TableView<Seat> SeatTableview;
    @FXML public TableColumn<String,Seat> SeatIDCoulmn;
    @FXML public TableColumn<String,Seat> SeatNumberCoulmn;
    @FXML public TableColumn<String,Seat> ClassTypeCoulmn;
    @FXML public TableColumn<Integer,Seat> planeIDCoulmn;

    //error label
    @FXML public Label error;

    private ViewHandler vh;
    private adminFlightViewModel adminFlightViewModel;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        adminFlightViewModel = vmf.getadminViewModel();
        adminFlightViewModel.loadFlights();
        adminFlightViewModel.loadArrival();
        adminFlightViewModel.loadPlane();
        adminFlightViewModel.loadDeparture();
        adminFlightViewModel.loadSeat();
        adminFlightViewModel.loadAirport();

        //flight
        FlightIdCoulmn.setCellValueFactory(new PropertyValueFactory<>("FlightID"));
        FlightNameColumn.setCellValueFactory(new PropertyValueFactory<>("flightName"));
        PriceCoulmn.setCellValueFactory(new PropertyValueFactory<>("price"));
        FlightName.textProperty().bindBidirectional(adminFlightViewModel.flightNameProperty());
        FlightID.textProperty().bindBidirectional(adminFlightViewModel.flightIdProperty());
        Price.textProperty().bindBidirectional(adminFlightViewModel.priceProperty());
        FlightTableview.setItems(adminFlightViewModel.getFlightsList());

        //planetype
        PlaneIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("PlaneId"));
        PlaneTypesCoulmn.setCellValueFactory(new PropertyValueFactory<>("planeType"));
        PlaneTypes.textProperty().bindBidirectional(adminFlightViewModel.planeTypesProperty());
        PlaneTableview.setItems(adminFlightViewModel.getPlanetyp());

        //departure
        DepartureIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("DepartureID"));
        DeparturesCoulmn.setCellValueFactory(new PropertyValueFactory<>("Departure"));
        DepartureeDateCoulmn.setCellValueFactory(new PropertyValueFactory<>("DepartureDate"));
        departures.textProperty().bindBidirectional(adminFlightViewModel.departuresProperty());
        Departuredate.textProperty().bindBidirectional(adminFlightViewModel.departureDateProperty());
        DepartureTableview.setItems(adminFlightViewModel.getDepatures());

        //arrival
        ArrivalIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("ArrivalID"));
        ArrivalsColumn.setCellValueFactory(new PropertyValueFactory<>("Arrival"));
        ArrivalDateCoulmn.setCellValueFactory(new PropertyValueFactory<>("ArrivalDate"));
        Arrivals.textProperty().bindBidirectional(adminFlightViewModel.arrivalsProperty());
        Arrivaldate.textProperty().bindBidirectional(adminFlightViewModel.arrivalDateProperty());
        ArrivalTableview.setItems(adminFlightViewModel.getArrivalsList());

        //seat
        SeatIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("seatID"));
        SeatNumberCoulmn.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        ClassTypeCoulmn.setCellValueFactory(new PropertyValueFactory<>("classType"));
        seatNumber.textProperty().bindBidirectional(adminFlightViewModel.seatNumberProperty());
        classType.textProperty().bindBidirectional(adminFlightViewModel.classTypeProperty());
        SeatTableview.setItems(adminFlightViewModel.getSeatObservableList());

        //airport
        AirportIdCoulmn.setCellValueFactory(new PropertyValueFactory<>("AirportID"));
        AirportNameCoulmn.setCellValueFactory(new PropertyValueFactory<>("AirportName"));
        AirportCityCoulmn.setCellValueFactory(new PropertyValueFactory<>("AirportCity"));
        airportId.textProperty().bindBidirectional(adminFlightViewModel.airportIdProperty());
        airportName.textProperty().bindBidirectional(adminFlightViewModel.airportNameProperty());
        airportCity.textProperty().bindBidirectional(adminFlightViewModel.airportCityProperty());
        AirportTableView.setItems(adminFlightViewModel.getAirportObservableList());

        //error label
        error.textProperty().bind(adminFlightViewModel.errorProperty());
    }


    public void onBack(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onAdd(ActionEvent actionEvent) {

        if(adminFlightViewModel.validateFlightInformation() && adminFlightViewModel.validateArrivalInformation() && adminFlightViewModel.validateDepartureInformation() && adminFlightViewModel.validateSeatInformation() && adminFlightViewModel.validatePlanetypeInformation() && adminFlightViewModel.validateAirportInformation()){

        adminFlightViewModel.InsertAirportInfomation();
        adminFlightViewModel.InsertArrivalInformation();
        adminFlightViewModel.InsertDepartureInformation();
        adminFlightViewModel.InsertPlaneInformation();
        adminFlightViewModel.InsertFlightInformation();
        adminFlightViewModel.InsertSeatInfomation();

        }
    }

}
