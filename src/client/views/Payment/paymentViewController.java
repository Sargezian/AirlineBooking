package client.views.Payment;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class paymentViewController implements ViewController {

    //cardInformation
    @FXML public TextField CardholderName;
    @FXML public TextField CardNumber;
    @FXML public TextField CVV;
    @FXML public TextField ExpirationDate;

    //passengerInformation
    @FXML public Label getFirstName;
    @FXML public Label getLastName;
    @FXML public Label getEmail;
    @FXML public Label getPhone;

    //price
    @FXML public Label getPrice;

    //error Label
    @FXML public Label errorlabel;

    private ViewHandler vh;
    private paymentViewModel pv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        pv = vmf.getPaymentViewModel();

        //cardInformation
        CardholderName.textProperty().bindBidirectional(pv.cardholderNameProperty());
        CardNumber.textProperty().bindBidirectional(pv.cardNumberProperty());
        CVV.textProperty().bindBidirectional(pv.CVVProperty());
        ExpirationDate.textProperty().bindBidirectional(pv.expirationDateProperty());

        //passengerInformation
        getFirstName.textProperty().bind(pv.firstNameProperty());
        getLastName.textProperty().bind(pv.lastNameProperty());
        getEmail.textProperty().bind(pv.emailProperty());
        getPhone.textProperty().bind(pv.phoneProperty());

        //errorlabel
        errorlabel.textProperty().bind(pv.errorProperty());

        //price
        getPrice.textProperty().bind(pv.priceProperty());

        //reload
        reloadpayment();
    }

    public void OnCheckOut(ActionEvent actionEvent) {
        if (pv.validatePaymentInfo()) {
            pv.getPaymentInformation();
            pv.createTicket();
            vh.openToMyFlightPlan();
            pv.clearFields();
        }
    }

  public void reloadpayment()
  {
      pv.SetPassengerInfomation();
  }
}
