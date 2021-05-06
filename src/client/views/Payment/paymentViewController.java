package client.views.Payment;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;

public class paymentViewController implements ViewController {

    @FXML public TextField CardholderName;
    @FXML public TextField CardNumber;
    @FXML public TextField CVV;
    @FXML public TextField ExpirationDate;

    @FXML public Label getFirstName;
    @FXML public Label getLastName;
    @FXML public Label getEmail;
    @FXML public Label getPhone;

    @FXML public Label getPrice;
    @FXML public Label errorlabel;

    private ViewHandler vh;
    private paymentViewModel pv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        pv = vmf.getPaymentViewModel();
        CardholderName.textProperty().bindBidirectional(pv.cardholderNameProperty());
        CardNumber.textProperty().bindBidirectional(pv.cardNumberProperty());
        CVV.textProperty().bindBidirectional(pv.CVVProperty());
        ExpirationDate.textProperty().bindBidirectional(pv.expirationDateProperty());
        getFirstName.textProperty().bind(pv.firstNameProperty());
        getLastName.textProperty().bind(pv.lastNameProperty());
        getEmail.textProperty().bind(pv.emailProperty());
        getPhone.textProperty().bind(pv.phoneProperty());
        errorlabel.textProperty().bind(pv.errorProperty());
        getPrice.textProperty().bind(pv.priceProperty());
        pv.SetPassengerInfomation();
    }

    public void OnCheckOut(ActionEvent actionEvent) {
        if (pv.validatePaymentInfo()) {
            pv.getPaymentInformation();
            vh.openToMyFlightPlan();
        }
    }
}
