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

    @FXML public TableView<myFlightTicket> flighttableview;
    @FXML public TableView<myFlightTicket> TicketTableview;
    @FXML public TableView<myFlightTicket> PassengerTableview;
   /* @FXML
    public TableView<myFlightTicket> PriceTableview;*/

    @FXML public TableColumn<Integer, myFlightTicket> FlightIdColumn;
    @FXML public TableColumn<String, myFlightTicket> FlightnameColumn;


    @FXML public TableColumn<String, myFlightTicket> PlanetypeColumn;


    @FXML public TableColumn<String, myFlightTicket>  DepartureColumn;
    @FXML public TableColumn<Timestamp,myFlightTicket> DepartureDateColumn;

    @FXML public TableColumn<String, myFlightTicket>  ArrivalColumn;
    @FXML public TableColumn<Timestamp,myFlightTicket> ArrivalDateColumn;
    @FXML public TableColumn<Integer, myFlightTicket>  TicketIdColumn;

    @FXML public TableColumn<Integer, myFlightTicket>  PassengerIdColumn;

    @FXML public TableColumn<String, myFlightTicket> NameColumn;
    @FXML public TableColumn<String, myFlightTicket> seat;
    @FXML public TableColumn<String, myFlightTicket> ClasstypeColumn;
    @FXML public TableColumn<String,myFlightTicket> LastNameCoulmn;
    @FXML public TableColumn<String,myFlightTicket> teleNumberColumn;
    @FXML public TableColumn<String,myFlightTicket> EmailCoulmn;

    /*@FXML public TableColumn<String,myFlightTicket> PriceSumColumn;*/

    @FXML
    private Label myName;

    private myflightplanViewModel vm;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getmyflightplanViewModel();
        vm.loadMyFlights();
        //vm.loadPriceSUM();
        FlightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightID"));
        FlightnameColumn.setCellValueFactory(new PropertyValueFactory<>("flightName"));
        PlanetypeColumn.setCellValueFactory(new PropertyValueFactory<>("planeTypes"));
        DepartureColumn.setCellValueFactory(new PropertyValueFactory<>("Departure"));
        ArrivalColumn.setCellValueFactory(new PropertyValueFactory<>("Arrivals"));
        DepartureDateColumn.setCellValueFactory(new PropertyValueFactory<>("DepartureDate"));
        ArrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("ArrivalDate"));
        TicketIdColumn.setCellValueFactory(new PropertyValueFactory<>("ticketID"));

        PassengerIdColumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        seat.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        ClasstypeColumn.setCellValueFactory(new PropertyValueFactory<>("ClassType"));
        LastNameCoulmn.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        teleNumberColumn.setCellValueFactory(new PropertyValueFactory<>("TelNumber"));
        EmailCoulmn.setCellValueFactory(new PropertyValueFactory<>("Email"));
      //  PriceSumColumn.setCellValueFactory(new PropertyValueFactory<>("PriceSum"));
        flighttableview.setItems(vm.getMyFlightTickets());
        TicketTableview.setItems(vm.getMyFlightTickets());
        PassengerTableview.setItems(vm.getMyFlightTickets());
       // PriceTableview.setItems(vm.getMyFlightTickets());
    }

    public void onBackDashboard(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onChat(ActionEvent actionEvent) {
        vh.openToChatView();
    }


}
