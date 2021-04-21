package client.views.myflightplan;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.myFlightTicket;

import java.sql.Timestamp;

public class myflightplanViewController implements ViewController {

    @FXML
    public TableView<myFlightTicket> myflighttableview;
    @FXML
    public TableView<myFlightTicket> flighttableview;
    @FXML
    public TableView<myFlightTicket> TicketTableview;
    @FXML
    public TableView<myFlightTicket> PassengerTableview;
    @FXML
    public TableView<myFlightTicket> DateTableview;

    @FXML
    public TableView<myFlightTicket> SeatTableview;



    @FXML
    public TableColumn<Integer, myFlightTicket> FlightIdColumn;
    @FXML
    public TableColumn<String, myFlightTicket> FlightnameColumn;
    @FXML
    public TableColumn<String, myFlightTicket> PlanetypeColumn;
    @FXML
    public TableColumn<Timestamp, myFlightTicket>  DepartureColumn;
    @FXML
    public TableColumn<Timestamp, myFlightTicket>  ArrivalColumn;
    @FXML
    public TableColumn<String, myFlightTicket>  FromColumn;
    @FXML
    public TableColumn<String, myFlightTicket> ToColumn;
    @FXML
    public TableColumn<Integer, myFlightTicket>  TicketIdColumn;
    @FXML
    public TableColumn<Integer, myFlightTicket>  PriceColumn;
    @FXML
    public TableColumn<Integer, myFlightTicket>  PassengerIdColumn;
    @FXML
    public TableColumn<Integer, myFlightTicket>  SeatIdColumn;

    @FXML
    public TableColumn<String, myFlightTicket> NameColumn;
    @FXML
    public TableColumn<String, myFlightTicket> seat;
    @FXML
    public TableColumn<String, myFlightTicket> ClasstypeColumn;
    public TableColumn<String,myFlightTicket> LastNameCoulmn;
    public TableColumn<String,myFlightTicket> teleNumberColumn;
    public TableColumn<String,myFlightTicket> EmailCoulmn;


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
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        seat.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        ClasstypeColumn.setCellValueFactory(new PropertyValueFactory<>("ClassType"));
        LastNameCoulmn.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        teleNumberColumn.setCellValueFactory(new PropertyValueFactory<>("TelNumber"));
        EmailCoulmn.setCellValueFactory(new PropertyValueFactory<>("Email"));
        SeatTableview.setItems((vm.getMy()));
        flighttableview.setItems((vm.getMy()));
        DateTableview.setItems((vm.getMy()));
        TicketTableview.setItems((vm.getMy()));
        PassengerTableview.setItems((vm.getMy()));
    }

    public void onBackDashboard(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onChat(ActionEvent actionEvent) {
        vh.openToChatView();
    }


}
