package client.views.Payment;

import client.model.ClientText;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class paymentViewModel {

    private ClientText clientText;
    private StringProperty CardholderName;
    private StringProperty CardNumber;
    private StringProperty CVV;
    private StringProperty ExpirationDate;

    public paymentViewModel(ClientText clientText) {
        this.clientText = clientText;
        CardholderName = new SimpleStringProperty();
        CardNumber = new SimpleStringProperty();
        CVV = new SimpleStringProperty();
        ExpirationDate = new SimpleStringProperty();

    }

    public void getPaymentInformation() {
        String CardholderName = this.CardholderName.getValue();
        String CardNumber = this.CardNumber.getValue();
        String CVV = this.CVV.getValue();
        String ExpirationDate = this.ExpirationDate.getValue();
        clientText.payment(CardholderName,CardNumber,CVV,ExpirationDate);

    }

    public String getCardholderName() {
        return CardholderName.get();
    }

    public StringProperty cardholderNameProperty() {
        return CardholderName;
    }

    public String getCardNumber() {
        return CardNumber.get();
    }

    public StringProperty cardNumberProperty() {
        return CardNumber;
    }

    public String getCVV() {
        return CVV.get();
    }

    public StringProperty CVVProperty() {
        return CVV;
    }

    public String getExpirationDate() {
        return ExpirationDate.get();
    }

    public StringProperty expirationDateProperty() {
        return ExpirationDate;
    }
}
