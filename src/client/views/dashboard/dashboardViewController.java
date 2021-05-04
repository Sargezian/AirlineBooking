package client.views.dashboard;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.SaveInfo;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.flights;

import java.sql.Timestamp;

public class dashboardViewController implements ViewController {

    @FXML public TableView<flights> tableView;
    @FXML public TableColumn<Integer, flights> flightIDColumn;
    @FXML public TableColumn<String, flights> flightNameColumn;


    @FXML public TableColumn<String, flights> departureColumn;
    @FXML public TableColumn<Timestamp,flights> DepartureDateColumn;

    @FXML public TableColumn<String, flights> planeType;


    @FXML public TableColumn<Timestamp,flights> ArrivalDateColumn;
    @FXML public TableColumn <String,flights>ArrivalColumn;

    @FXML public TableColumn<Integer,flights> priceColumn;


    @FXML public TextField SearchField;

    // TODO: 25/04/2021 læg price

    private ViewHandler vh;
    private dashboardViewModel dv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        dv = vmf.getdashboardViewModel();
        dv.loadFlights();

        flightIDColumn.setCellValueFactory(new PropertyValueFactory<>("flightID"));
        flightNameColumn.setCellValueFactory(new PropertyValueFactory<>("flightName"));

        planeType.setCellValueFactory(new PropertyValueFactory<>("PlaneTypes"));

        departureColumn.setCellValueFactory(new PropertyValueFactory<>("Departures"));
        DepartureDateColumn.setCellValueFactory(new PropertyValueFactory<>("DepartureDate"));

        ArrivalColumn.setCellValueFactory(new PropertyValueFactory<>("Arrivals"));
        ArrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("ArrivalDate"));

        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        tableView.setItems(dv.getflight());

        SearchField.textProperty().bindBidirectional(dv.searchProperty());

    }

    public void OnLogin(ActionEvent actionEvent) {
        vh.openLoginView();
    }

    public void onpush(ActionEvent actionEvent) {
        dv.setSelected(tableView.getSelectionModel().getSelectedItems());
        dv.removeSelected();
       // dv.addSelected();
    }

    public void onNext(ActionEvent actionEvent) {
        dv.getFlightInformation(tableView.getSelectionModel().getSelectedItem());
        vh.openSeat();

    }

    public void onSearch(ActionEvent actionEvent) {
         dv.search();
    }


    public void onReviews(ActionEvent actionEvent) {
        vh.openToChatView();
    }
}
