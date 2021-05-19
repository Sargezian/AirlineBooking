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

    //error
    @FXML public Label error;

    //shopping cart
    @FXML public Label FlightName;
    @FXML public Label departure;
    @FXML public Label arrival;
    @FXML public Label seat;
    @FXML public Label ClassType;

    //price information
    @FXML public Label TotalPrice;

    private ViewHandler vh;
    private passengerViewModel pv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        pv = vmf.getPassengerViewModel();

        //passenger
        FirstName.textProperty().bindBidirectional(pv.firstNameProperty());
        LastName.textProperty().bindBidirectional(pv.lastNameProperty());
        TelNumber.textProperty().bindBidirectional(pv.telNumberProperty());
        Email.textProperty().bindBidirectional(pv.emailProperty());

        //shoppingcart
        FlightName.textProperty().bind(pv.flightNameProperty());
        departure.textProperty().bind(pv.departureProperty());
        arrival.textProperty().bind(pv.arrivalProperty());
        seat.textProperty().bind(pv.seatPropertyProperty());
        ClassType.textProperty().bind(pv.classTypeProperty());
        TotalPrice.textProperty().bind(pv.priceProperty());

        //error
        error.textProperty().bind(pv.errorProperty());

        //reload
        reloadpassenger();

    }

    public void onBack(ActionEvent actionEvent) {

        vh.openSeat();
    }

    public void onOrder(ActionEvent actionEvent) {
        if (pv.validatePassengerInformation()) {
            pv.getPassengerInformation();
            pv.clearFields();
            vh.openLoginView();
        }
    }

  public void reloadpassenger()
  {
      pv.SetShoppingCart();
  }
}
