package client.views.Payment;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.Passenger;
import shared.transferobjects.Flights;
import shared.util.utils;

import java.beans.PropertyChangeEvent;

public class paymentViewModel {


    private ClientText clientText;

    //payment
    private StringProperty CardholderName;
    private StringProperty CardNumber;
    private StringProperty CVV;
    private StringProperty ExpirationDate;

    //passengerinformation
    private StringProperty FirstName;
    private StringProperty LastName;
    private StringProperty Email;
    private StringProperty Phone;

    //error
    private StringProperty error;

    //price
    private StringProperty price;

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

        price = new SimpleStringProperty();
        error = new SimpleStringProperty();
    }

    private void onNewTicket(PropertyChangeEvent propertyChangeEvent) {
        SetPassengerInfomation();

    }

    public void SetPassengerInfomation() {

        Passenger pg = SaveInfo.getInstance().getPassenger();
        Flights ft =  SaveInfo.getInstance().getFlights();
        clientText.ReadPassenger(pg.FirstName, pg.LastName, pg.TelNumber, pg.Email);
        clientText.readPrice(ft.price);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                FirstName.setValue(pg.FirstName);
                LastName.setValue(pg.LastName);
                Phone.setValue(pg.TelNumber);
                Email.setValue(pg.Email);
                price.setValue(String.valueOf(ft.price));
            }
        });

    }

    public void getPaymentInformation() {

        if (CardholderName.getValue() != null && !"".equals(CardholderName.getValue()) && CardNumber.getValue() != null && !"".equals(CardNumber.getValue()) && CVV.getValue() != null && !"".equals(CVV.getValue())  && ExpirationDate.getValue() != null && !"".equals(ExpirationDate.getValue())) {

            String CardholderName = this.CardholderName.getValue();
            String CardNumber = this.CardNumber.getValue();
            String CVV = this.CVV.getValue();
            String ExpirationDate = this.ExpirationDate.getValue();
            clientText.payment(CardholderName,CardNumber,CVV,ExpirationDate);

        }

    }

    public boolean validatePaymentInfo(){


        if (CardholderName.getValue() == null ) {
            error.set("CardholderName cannot be empty");
            return false;
        }


        if (CardNumber.getValue() == null ) {
            error.set("CardNumber cannot be empty");
            return false;
        }

        if (CardNumber.getValue().length() < 16  ) {
            error.set("CardNumber must contain 16 characters");
            return false;
        }


        if (CardNumber.getValue().length() > 16  ) {
            error.set("CardNumber must contain 16 characters");
            return false;
        }


        if (CVV.getValue() == null) {
            error.set("CVV must contain more than 0 characters");
            return false;
        }


        if (CVV.getValue().length() > 3 ) {
            error.set("CVV must contain less than 3 characters");
            return false;
        }

        if (ExpirationDate.getValue() == null ) {
            error.set("ExpirationDate cannot be empty");
            return false;
        }

        else {

            return true;

        }




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

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }
}
