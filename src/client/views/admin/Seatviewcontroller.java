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
import shared.transferobjects.Airport;
import shared.transferobjects.Seat;

import java.rmi.RemoteException;

public class Seatviewcontroller implements ViewController
{

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

    private ViewHandler vh;
    private Seatviewmodel av;

@Override
public void init(ViewHandler vh, ViewModelFactory vmf) {
    this.vh = vh;
    av = vmf.getSeatViewModel();
    av.loadSeat();
    av.loadAirport();

    SeatIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("seatID"));
    SeatNumberCoulmn.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
    ClassTypeCoulmn.setCellValueFactory(new PropertyValueFactory<>("classType"));
    planeIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("planeId"));


    AirportIdCoulmn.setCellValueFactory(new PropertyValueFactory<>("AirportID"));
    AirportNameCoulmn.setCellValueFactory(new PropertyValueFactory<>("AirportName"));
    AirportCityCoulmn.setCellValueFactory(new PropertyValueFactory<>("AirportCity"));

    seatNumber.textProperty().bindBidirectional(av.seatNumberProperty());
    classType.textProperty().bindBidirectional(av.classTypeProperty());
    airportId.textProperty().bindBidirectional(av.airportIdProperty());
    airportName.textProperty().bindBidirectional(av.airportNameProperty());
    airportCity.textProperty().bindBidirectional(av.airportCityProperty());
    SeatTableview.setItems(av.getSeatObservableList());
    AirportTableView.setItems(av.getAirportObservableList());

    }


public void onDelete(ActionEvent actionEvent) {


    }

public void onBack(ActionEvent actionEvent) {
    vh.openToDashView();
    }

public void onLogOff(ActionEvent actionEvent) {
    }

public void onAdd(ActionEvent actionEvent) throws RemoteException
    {
    av.InsertSeatInfomation();
    av.InsertAirportInfomation();
    av.validateAirportInformation();

    System.out.println(av.seatIdProperty());
    System.out.println(av.seatNumberProperty());
    System.out.println(av.classTypeProperty());
    System.out.println(av.airportCityProperty());
    System.out.println(av.airportNameProperty());
    System.out.println(av.airportIdProperty());
    }

    public void aiportAdmin(ActionEvent actionEvent) {
    vh.openAdminAirport();
    }

    public void FlightAdmin(ActionEvent actionEvent) {
    vh.openAdminView();
    }

    public void DeleteAdmin(ActionEvent actionEvent) {


    }
}


