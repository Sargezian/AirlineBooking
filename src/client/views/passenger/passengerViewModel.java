package client.views.passenger;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import shared.transferobjects.*;
import shared.util.utils;

import java.beans.PropertyChangeEvent;

public class passengerViewModel {

    private ClientText clientText;
    private StringProperty FirstName;
    private StringProperty LastName;
    private StringProperty TelNumber;
    private StringProperty Email;


    private StringProperty FlightName;
    private StringProperty From;
    private StringProperty to;


    private StringProperty seat;
    private StringProperty ClassType;
    private StringProperty Food;



    public passengerViewModel(ClientText clientText) {
        this.clientText = clientText;
        FirstName = new SimpleStringProperty();
        LastName = new SimpleStringProperty();
        TelNumber = new SimpleStringProperty();
        Email = new SimpleStringProperty();
        FlightName = new SimpleStringProperty();
        From = new SimpleStringProperty();
        to = new SimpleStringProperty();
        seat = new SimpleStringProperty();
        ClassType = new SimpleStringProperty();
        Food = new SimpleStringProperty();
        clientText.addListener(utils.NEWTICKET, this::onNewTicket);
    }

    private void onNewTicket(PropertyChangeEvent event) {
         SetShoppingCart();

    }


    public void SetShoppingCart() {

        flights flights = SaveInfo.getInstance().getFlights();
        Seat seat = SaveInfo.getInstance().getSeat();


        clientText.readFlightsFromShoppingCart(flights.flightName,flights.from,flights.to);
        clientText.readSeatFromShoppingCart(seat.seatNumber,seat.classType);

        FlightName.setValue(flights.flightName);
        From.setValue(flights.from);
        to.setValue(flights.to);

        this.seat.setValue(seat.seatNumber);
        ClassType.setValue(seat.classType);


    }












    public void getPassengerInformation() {

        String FirstName = this.FirstName.getValue();
        String LastName = this.LastName.getValue();
        String TelNumber = this.TelNumber.getValue();
        String Email = this.Email.getValue();
        SaveInfo.getInstance().setPassenger(clientText.Createpassernger(FirstName,LastName,TelNumber,Email));
    }


    public void finish() {

        flights ft = SaveInfo.getInstance().getFlights();
        System.out.println("Gets SavedInfo from flights = " + SaveInfo.getInstance().getFlights());

        Seat st = SaveInfo.getInstance().getSeat();
        System.out.println("Gets SavedInfo from seats = " + SaveInfo.getInstance().getSeat());

        Passenger pg = SaveInfo.getInstance().getPassenger();
        System.out.println("Gets SavedInfo from passenger = " + SaveInfo.getInstance().getPassenger());

        myFlightTicket myFlightTicket1 = new myFlightTicket(1, ft.price, pg,ft,st);
        clientText.createTicket(myFlightTicket1);
    }

    public String getFlightName() {
        return FlightName.get();
    }

    public StringProperty flightNameProperty() {
        return FlightName;
    }

    public String getFrom() {
        return From.get();
    }

    public StringProperty fromProperty() {
        return From;
    }

    public String getTo() {
        return to.get();
    }

    public StringProperty toProperty() {
        return to;
    }

    public String getSeat() {
        return seat.get();
    }

    public StringProperty seatProperty() {
        return seat;
    }

    public String getClassType() {
        return ClassType.get();
    }

    public StringProperty classTypeProperty() {
        return ClassType;
    }

    public String getFood() {
        return Food.get();
    }

    public StringProperty foodProperty() {
        return Food;
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


    // TODO: 25/04/2021 Indkøbskurven skal virke her ved hjælp af join og bedre design skal laves 

}
