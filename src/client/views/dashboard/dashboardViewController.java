package client.views.dashboard;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.SaveInfo;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.Flights;
import java.sql.Timestamp;



public class dashboardViewController implements ViewController {

    @FXML public TableView<Flights> tableView;
    @FXML public TableColumn<Integer, Flights> flightIDColumn;
    @FXML public TableColumn<String, Flights> flightNameColumn;


    @FXML public TableColumn<String, Flights> departureColumn;
    @FXML public TableColumn<Timestamp, Flights> DepartureDateColumn;

    @FXML public TableColumn<String, Flights> planeType;


    @FXML public TableColumn<Timestamp, Flights> ArrivalDateColumn;
    @FXML public TableColumn <String, Flights>ArrivalColumn;

    @FXML public TableColumn<Integer, Flights> priceColumn;


    @FXML public TextField SearchField;
    @FXML public Label errorlabel;
    @FXML public Label clock;

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

        errorlabel.textProperty().bind(dv.errorProperty());

        clock.textProperty().bind(dv.clockProperty());


        tableView.setItems(dv.getflight());

        SearchField.textProperty().bindBidirectional(dv.searchProperty());
        dv.startClock();


    }

    public void OnLogin(ActionEvent actionEvent) {
        SaveInfo.getInstance().reset();
        vh.openLoginView();

    }


    public void onNext(ActionEvent actionEvent) {
        if(dv.getFlightInformation(tableView.getSelectionModel().getSelectedItem())) {
            tableView.refresh();
            vh.openSeat();


        }



    }

    public void onSearch(ActionEvent actionEvent) {
         dv.search();
    }


    public void onReviews(ActionEvent actionEvent) {
        SaveInfo.getInstance().reset();
        vh.openToChatView();
    }

}
