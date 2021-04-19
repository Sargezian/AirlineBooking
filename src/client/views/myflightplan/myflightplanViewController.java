package client.views.myflightplan;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.dashboard.dashboardViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.Myflightlist;
import shared.transferobjects.flights;

import java.sql.Timestamp;

public class myflightplanViewController implements ViewController {

    @FXML
    public TableView<Myflightlist> myflighttableview;
    @FXML
    public TableColumn<Integer,Myflightlist> FlightIdColumn;
    @FXML
    public TableColumn<String,Myflightlist> FlightnameColumn;
    @FXML
    public TableColumn<String, Myflightlist> PlanetypeColumn;
    @FXML
    public TableColumn<Timestamp,Myflightlist>  DepartureColumn;
    @FXML
    public TableColumn<Timestamp,Myflightlist>  ArrivalColumn;
    @FXML
    public TableColumn<String,Myflightlist>  FromColumn;
    @FXML
    public TableColumn<String,Myflightlist> ToColumn;
    @FXML
    public TableColumn<Integer,Myflightlist>  TicketIdColumn;
    @FXML
    public TableColumn<Integer,Myflightlist>  PriceColumn;
    @FXML
    public TableColumn<Integer,Myflightlist>  PassengerIdColumn;
    @FXML
    public TableColumn<Integer,Myflightlist>  SeatIdColumn;

    @FXML
    public TableColumn<String,Myflightlist> NameColumn;

    @FXML
    public TableColumn<String,Myflightlist> seat;

    @FXML
    public TableColumn<String,Myflightlist> ClasstypeColumn;

    @FXML
    private Label myName;

    private myflightplanViewModel vm;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getmyflightplanViewModel();
        vm.loadMyFlights();
        FlightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightID"));
        FlightnameColumn.setCellValueFactory(new PropertyValueFactory<>("flightName"));
        PlanetypeColumn.setCellValueFactory(new PropertyValueFactory<>("planeType"));
        DepartureColumn.setCellValueFactory(new PropertyValueFactory<>("departure"));
        ArrivalColumn.setCellValueFactory(new PropertyValueFactory<>("arrival"));
        FromColumn.setCellValueFactory(new PropertyValueFactory<>("from"));
        ToColumn.setCellValueFactory(new PropertyValueFactory<>("to"));
        TicketIdColumn.setCellValueFactory(new PropertyValueFactory<>("ticketID"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        PassengerIdColumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        SeatIdColumn.setCellValueFactory(new PropertyValueFactory<>("SeatID"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        seat.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        ClasstypeColumn.setCellValueFactory(new PropertyValueFactory<>("ClassType"));
        myflighttableview.setItems((vm.getMy()));
    }

    public void onBackDashboard(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onChat(ActionEvent actionEvent) {
        vh.openToChatView();
    }
}
