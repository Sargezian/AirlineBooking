package client.views.passenger;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class passengerViewController implements ViewController {

    //passenger information
    @FXML public TextField FirstName;
    @FXML public TextField LastName;
    @FXML public TextField TelNumber;
    @FXML public TextField Email;

    //shopping cart
    @FXML public Label FlightName;
    @FXML public Label From;
    @FXML public Label to;
    @FXML public Label seat;
    @FXML public Label ClassType;
    @FXML public Label Food;

    //price information
    @FXML public Label Subtotal;
    @FXML public Label seatPrice;
    @FXML public Label FoodPrice;
    @FXML public Label TotalPrice;

    private ViewHandler vh;
    private passengerViewModel pv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        pv = vmf.getPassengerViewModel();
        FirstName.textProperty().bindBidirectional(pv.firstNameProperty());
        LastName.textProperty().bindBidirectional(pv.lastNameProperty());
        TelNumber.textProperty().bindBidirectional(pv.telNumberProperty());
        Email.textProperty().bindBidirectional(pv.emailProperty());
        /*pv.loadPassenger();
        *//*passengerIDColumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));*//*
        tableView.setItems(pv.getPassengers());*/
    }

    public void onBack(ActionEvent actionEvent) {
        vh.openSeat();
    }

    public void onOrder(ActionEvent actionEvent) {
        pv.getPassengerInformation();
        pv.finish();
        vh.openLoginView();
    }


}
