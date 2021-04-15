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


public class myflightplanViewController implements ViewController {

    @FXML
    public TableView<Myflightlist> myflighttableview;
    @FXML
    public TableColumn<String,Myflightlist> FlightIdColumn;
    @FXML
    public TableColumn<String,Myflightlist> FlightnameColumn;
    @FXML
    public TableColumn<String,Myflightlist>  DepartureColumn;
    @FXML
    public TableColumn<String,Myflightlist>  ArrivalColumn;
    @FXML
    public TableColumn<String,Myflightlist>  FromColumn;
    @FXML
    public TableColumn<String,Myflightlist> ToColumn;
    @FXML
    public TableColumn<String,Myflightlist>  TicketIdColumn;
    @FXML
    public TableColumn<String,Myflightlist>  PriceColumn;
    @FXML
    public TableColumn<String,Myflightlist>  PassengerIdColumn;
    @FXML
    public TableColumn<String,Myflightlist>  SeatIdColumn;

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
        myflighttableview.setItems(vm.getMy());
    }

    public void onBackDashboard(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onChat(ActionEvent actionEvent) {
        vh.openToChatView();
    }
}
