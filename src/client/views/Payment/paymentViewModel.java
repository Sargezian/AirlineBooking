package client.views.Payment;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.Passenger;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.sql.Date;

public class paymentViewModel {

    private ClientText clientText;
    private StringProperty CardholderName;
    private StringProperty CardNumber;
    private StringProperty CVV;
    private StringProperty ExpirationDate;

    private StringProperty FirstName;
    private StringProperty LastName;
    private StringProperty Email;
    private StringProperty Phone;

    public paymentViewModel(ClientText clientText) {
        this.clientText = clientText;
        clientText.addListener(utils.NEWTICKET, this::onNewTicket);

        CardholderName = new SimpleStringProperty();
        CardNumber = new SimpleStringProperty();
        CVV = new SimpleStringProperty();
        ExpirationDate = new SimpleStringProperty();

        FirstName = new SimpleStringProperty();
        LastName = new SimpleStringProperty();
        Email = new SimpleStringProperty();
        Phone = new SimpleStringProperty();
    }

    private void onNewTicket(PropertyChangeEvent propertyChangeEvent) {

        SetPassengerInfomation();

    }

    public void SetPassengerInfomation() {

        Passenger pg = SaveInfo.getInstance().getPassenger();
        clientText.ReadPassenger(pg.FirstName, pg.LastName, pg.TelNumber, pg.Email);

        FirstName.setValue(pg.FirstName);
        LastName.setValue(pg.LastName);
        Phone.setValue(pg.TelNumber);
        Email.setValue(pg.Email);

        //TODO LAV LISTE

    }

    public void getPaymentInformation() {
        String CardholderName = this.CardholderName.getValue();
        String CardNumber = this.CardNumber.getValue();
        String CVV = this.CVV.getValue();
        String ExpirationDate = this.ExpirationDate.getValue();
        clientText.payment(CardholderName,CardNumber,CVV,ExpirationDate);
    }

    public String getFirstName() {
        return FirstName.get();
    }

    public StringProperty firstNameProperty() {
        return FirstName;
    }

    public String getLastName() {
        return LastName.get();
    }

    public StringProperty lastNameProperty() {
        return LastName;
    }

    public String getEmail() {
        return Email.get();
    }

    public StringProperty emailProperty() {
        return Email;
    }

    public String getPhone() {
        return Phone.get();
    }

    public StringProperty phoneProperty() {
        return Phone;
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
