package client.views.Payment;

import client.model.ClientModel;
import client.model.SaveInfo;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.*;
import shared.util.utils;

import java.beans.PropertyChangeEvent;

public class paymentViewModel {

    private ClientModel clientModel;

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

    public paymentViewModel(ClientModel clientModel) {
        this.clientModel = clientModel;
        clientModel.addListener(utils.NEWTICKET, this::onNewTicket);

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


    public void createTicket() {

        Flights ft = SaveInfo.getInstance().getFlights();
        System.out.println("Gets SavedInfo from flights = " + SaveInfo.getInstance().getFlights());

        Seat st = SaveInfo.getInstance().getSeat();
        System.out.println("Gets SavedInfo from seats = " + SaveInfo.getInstance().getSeat());

        Passenger pg = SaveInfo.getInstance().getPassenger();
        System.out.println("Gets SavedInfo from passenger = " + SaveInfo.getInstance().getPassenger());

        InputUser user = SaveInfo.getInstance().getUser();
        System.out.println("Gets SavedInfo from Inputuser = " + SaveInfo.getInstance().getUser());

        myFlightTicket myFlightTicket1 = new myFlightTicket(String.valueOf(1),pg,ft,st,user);

        clientModel.createTicket(myFlightTicket1);

}

public void set(){
    error.setValue("");

}

public boolean validatepayment() {

        if (validatePaymentInfo() == true){
            error.set("");

            return true;


        } else {
            return false;
        }

}


    public void SetPassengerInfomation() {

        Passenger pg = SaveInfo.getInstance().getPassenger();
        Flights ft =  SaveInfo.getInstance().getFlights();
        clientModel.ReadPassenger(pg.getFirstName(), pg.getLastName(), pg.getTelNumber(), pg.getEmail());
        clientModel.readPrice(ft.getPrice());

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                FirstName.setValue(pg.getFirstName());
                LastName.setValue(pg.getLastName());
                Phone.setValue(pg.getTelNumber());
                Email.setValue(pg.getEmail());
                price.setValue(String.valueOf(ft.getPrice()));
            }
        });
    }

    public void getPaymentInformation() {

        if (CardholderName.getValue() != null && !"".equals(CardholderName.getValue()) && CardNumber.getValue() != null && !"".equals(CardNumber.getValue()) && CVV.getValue() != null && !"".equals(CVV.getValue())  && ExpirationDate.getValue() != null && !"".equals(ExpirationDate.getValue())) {

            String CardholderName = this.CardholderName.getValue();
            String CardNumber = this.CardNumber.getValue();
            String CVV = this.CVV.getValue();
            String ExpirationDate = this.ExpirationDate.getValue();
            clientModel.payment(CardholderName,CardNumber,CVV,ExpirationDate);

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

    public void clearFields() {
        CardholderName.setValue("");
        CardNumber.setValue("");
        CVV.setValue("");
        ExpirationDate.setValue("");

    }

    private void onNewTicket(PropertyChangeEvent propertyChangeEvent) {
        SetPassengerInfomation();

    }



    public StringProperty firstNameProperty() {
        return FirstName;
    }
    public StringProperty lastNameProperty() {
        return LastName;
    }
    public StringProperty emailProperty() {
        return Email;
    }
    public StringProperty phoneProperty() {
        return Phone;
    }
    public StringProperty cardholderNameProperty() {
        return CardholderName;
    }
    public StringProperty cardNumberProperty() {
        return CardNumber;
    }
    public StringProperty CVVProperty() {
        return CVV;
    }
    public StringProperty expirationDateProperty() {
        return ExpirationDate;
    }
    public StringProperty errorProperty() {
        return error;
    }
    public StringProperty priceProperty() {
        return price;
    }

}
