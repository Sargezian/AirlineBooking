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

    @FXML public TableView<Flights> FlightTableview;
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
    public TableView<Arrival> ArrivalTableview;
    @FXML
    public TableView<Depature> DepartureTableview;
    @FXML
    public TableView<PlaneType> PlaneTableview;


    @FXML
    public TextField airportId;
    @FXML
    public TextField airportName;
    @FXML
    public TextField airportCity;

    @FXML
    public TextField seatNumber;
    @FXML
    public TextField classType;
    @FXML
    public TableView<Seat> SeatTableview;
    @FXML
    public TableColumn<String,Seat> SeatIDCoulmn;
    @FXML
    public TableColumn<String,Seat> SeatNumberCoulmn;
    @FXML
    public TableColumn<String,Seat> ClassTypeCoulmn;

    @FXML
    public TableView <Airport>AirportTableView;
    @FXML
    public TableColumn<String,Airport> AirportIdCoulmn;
    @FXML
    public TableColumn<String,Airport> AirportNameCoulmn;
    @FXML
    public TableColumn<String,Airport> AirportCityCoulmn;
    public TableColumn<Integer,Seat> planeIDCoulmn;
    @FXML public Label error;


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
        av.loadSeat();
        av.loadAirport();

        FlightIdCoulmn.setCellValueFactory(new PropertyValueFactory<>("FlightID"));
        FlightNameColumn.setCellValueFactory(new PropertyValueFactory<>("flightName"));
        PriceCoulmn.setCellValueFactory(new PropertyValueFactory<>("price"));

        PlaneIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("PlaneId"));
        PlaneTypesCoulmn.setCellValueFactory(new PropertyValueFactory<>("planeType"));


        DepartureIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("DepartureID"));
        DeparturesCoulmn.setCellValueFactory(new PropertyValueFactory<>("Departure"));
        DepartureeDateCoulmn.setCellValueFactory(new PropertyValueFactory<>("DepartureDate"));


        ArrivalIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("ArrivalID"));
        ArrivalsColumn.setCellValueFactory(new PropertyValueFactory<>("Arrival"));
        ArrivalDateCoulmn.setCellValueFactory(new PropertyValueFactory<>("ArrivalDate"));


        SeatIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("seatID"));
        SeatNumberCoulmn.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        ClassTypeCoulmn.setCellValueFactory(new PropertyValueFactory<>("classType"));
        planeIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("planeId"));

        AirportIdCoulmn.setCellValueFactory(new PropertyValueFactory<>("AirportID"));
        AirportNameCoulmn.setCellValueFactory(new PropertyValueFactory<>("AirportName"));
        AirportCityCoulmn.setCellValueFactory(new PropertyValueFactory<>("AirportCity"));

        FlightName.textProperty().bindBidirectional(av.flightNameProperty());
        FlightID.textProperty().bindBidirectional(av.flightIdProperty());
        Price.textProperty().bindBidirectional(av.priceProperty());
        Arrivals.textProperty().bindBidirectional(av.arrivalsProperty());
        Arrivaldate.textProperty().bindBidirectional(av.arrivalDateProperty());
        departures.textProperty().bindBidirectional(av.departuresProperty());
        Departuredate.textProperty().bindBidirectional(av.departureDateProperty());
        PlaneTypes.textProperty().bindBidirectional(av.planeTypesProperty());
        seatNumber.textProperty().bindBidirectional(av.seatNumberProperty());
        classType.textProperty().bindBidirectional(av.classTypeProperty());
        airportId.textProperty().bindBidirectional(av.airportIdProperty());
        airportName.textProperty().bindBidirectional(av.airportNameProperty());
        airportCity.textProperty().bindBidirectional(av.airportCityProperty());


        FlightTableview.setItems(av.getFlightsList());
        ArrivalTableview.setItems(av.getArrivalsList());
        DepartureTableview.setItems(av.getDepatures());
        PlaneTableview.setItems(av.getPlanetyp());
        SeatTableview.setItems(av.getSeatObservableList());
        AirportTableView.setItems(av.getAirportObservableList());


        error.textProperty().bind(av.errorProperty());
    }


    public void onDelete(ActionEvent actionEvent) {

        Depature selectedItem = DepartureTableview.getSelectionModel().getSelectedItem();
        Flights selectedItem1 = FlightTableview.getSelectionModel().getSelectedItem();
        Arrival selectedItem2 = ArrivalTableview.getSelectionModel().getSelectedItem();
        PlaneType selectedItem3 = PlaneTableview.getSelectionModel().getSelectedItem();

        if (selectedItem != null){
            av.deleteDeparture(DepartureTableview.getSelectionModel().getSelectedItem());

        }

        if (selectedItem1 != null){
            av.deleteArrival(ArrivalTableview.getSelectionModel().getSelectedItem());

        }

        if (selectedItem2 != null){
            av.deleteFlight(FlightTableview.getSelectionModel().getSelectedItem());

        }


        if (selectedItem3 != null){
            av.deletePlaneType(PlaneTableview.getSelectionModel().getSelectedItem());

        }

    }

    public void onBack(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onLogOff(ActionEvent actionEvent) {
    }

    public void onAdd(ActionEvent actionEvent) {

        if(av.validateFlightInformation() && av.validateArrivalInformation() && av.validateDepartureInformation() && av.validateSeatInformation() && av.validatePlanetypeInformation() && av.validateAirportInformation()){


        av.InsertAirportInfomation();
        av.InsertArrivalInformation();
        av.InsertDepartureInformation();
        av.InsertPlaneInformation();
        av.InsertFlightInformation();
        av.InsertSeatInfomation();


        System.out.println(av.seatIdProperty());
        System.out.println(av.seatNumberProperty());
        System.out.println(av.classTypeProperty());
        System.out.println(av.airportCityProperty());
        System.out.println(av.airportNameProperty());
        System.out.println(av.airportIdProperty());

        }
    }


    public void seatAdmin(ActionEvent actionEvent) {
        vh.openAdminSeat();

    }
}
