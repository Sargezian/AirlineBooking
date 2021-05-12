package client.views.admin;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
        av.InsertArrivalInformation();
        av.InsertDepartureInformation();
        av.InsertPlaneInformation();
        av.InsertFlightInformation();
    }

    public void seatAdmin(ActionEvent actionEvent) {
        vh.openAdminSeat();

    }
}
