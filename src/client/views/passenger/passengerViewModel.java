package client.views.passenger;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.application.Platform;
import javafx.beans.property.*;
import shared.transferobjects.*;
import shared.util.utils;

import java.beans.PropertyChangeEvent;

public class passengerViewModel {

    private ClientText clientText;

    //passenger
    private StringProperty FirstName;
    private StringProperty LastName;
    private StringProperty TelNumber;
    private StringProperty Email;

    //shoppingcar
    private StringProperty FlightName;
    private StringProperty departure;
    private StringProperty arrival;
    private StringProperty seatProperty;
    private StringProperty ClassType;

    //error
    private StringProperty error;

    public passengerViewModel(ClientText clientText) {
        this.clientText = clientText;
        FirstName = new SimpleStringProperty();
        LastName = new SimpleStringProperty();
        TelNumber = new SimpleStringProperty();
        Email = new SimpleStringProperty();
        FlightName = new SimpleStringProperty();
        departure = new SimpleStringProperty();
        arrival = new SimpleStringProperty();
        seatProperty = new SimpleStringProperty();
        ClassType = new SimpleStringProperty();
        error = new SimpleStringProperty();

       clientText.addListener(utils.NEWTICKET, this::onNewTicket);
    }


    private void onNewTicket(PropertyChangeEvent event) {
         SetShoppingCart();
    }


    public void SetShoppingCart() {

        flights flights = SaveInfo.getInstance().getFlights();
        Seat seat = SaveInfo.getInstance().getSeat();

        clientText.readFlightsFromShoppingCart(flights.flightName,flights.getDepartures(),flights.getArrivals());
        clientText.readSeatFromShoppingCart(seat.seatNumber,seat.classType);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                FlightName.setValue(flights.flightName);
                departure.setValue(flights.getDepartures());
                arrival.setValue(flights.getArrivals());
                seatProperty.setValue(seat.seatNumber);
                ClassType.setValue(seat.classType);
            }
        });
    }

    public boolean getPassengerInformation() {

            if (FirstName.getValue() != null && !"".equals(FirstName.getValue()) && LastName.getValue() != null && !"".equals(LastName.getValue()) && TelNumber.getValue() != null && !"".equals(TelNumber.getValue())  && Email.getValue() != null && !"".equals(Email.getValue()) && Email.getValue().contains("@")) {

                String FirstName = this.FirstName.getValue();
                String LastName = this.LastName.getValue();
                String TelNumber = this.TelNumber.getValue();
                String Email = this.Email.getValue();
                SaveInfo.getInstance().setPassenger(clientText.Createpassernger(FirstName,LastName,TelNumber,Email));
                return true;
            }
            else if (FirstName.getValue() == null ) {
                error.set("FirstName cannot be empty");
                return false;
            }
            else if (LastName.getValue() == null ) {
                error.set("LastName cannot be empty");
                return false;
            }
            else if (TelNumber.getValue() == null ) {
                error.set("TelNumber cannot be empty");
                return false;
            }
            else if (Email.getValue() == null) {
                error.set("Email cannot be empty ");
                return false;
            }
             else if (!Email.getValue().contains("@")) {
                 error.set("Email must contain '@' ");
                 return false;
            } else {
                error.set("Fields cannot be emty");
                return false;
            }
    }



    public void clearFields() {
        FirstName.setValue("");
        LastName.setValue("");
        TelNumber.setValue("");
        Email.setValue("");
        error.setValue("");

    }

    public String getFlightName() {
        return FlightName.get();
    }

    public StringProperty flightNameProperty() {
        return FlightName;
    }

    public String getDeparture() {
        return departure.get();
    }

    public StringProperty departureProperty() {
        return departure;
    }

    public String getArrival() {
        return arrival.get();
    }

    public StringProperty arrivalProperty() {
        return arrival;
    }

    public String getSeatProperty() {
        return seatProperty.get();
    }

    public StringProperty seatPropertyProperty() {
        return seatProperty;
    }

    public String getClassType() {
        return ClassType.get();
    }

    public StringProperty classTypeProperty() {
        return ClassType;
    }


    public String getEmail() {
        return Email.get();
    }

    public StringProperty emailProperty() {
        return Email;
    }

    public String getFirstName()
    {
        return FirstName.get();
    }

    public StringProperty firstNameProperty()
    {
        return FirstName;
    }

    public String getLastName()
    {
        return LastName.get();
    }

    public StringProperty lastNameProperty()
    {
        return LastName;
    }

    public String getTelNumber()
    {
        return TelNumber.get();
    }

    public StringProperty telNumberProperty()
    {
        return TelNumber;
    }

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }

    // TODO: 25/04/2021 Indkøbskurven skal virke her
}
