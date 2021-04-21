package client.views.passenger;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.beans.property.*;
import shared.transferobjects.*;
import shared.util.utils;

import java.beans.PropertyChangeEvent;

public class passengerViewModel {

    private ClientText clientText;
    private StringProperty FirstName;
    private StringProperty LastName;
    private StringProperty TelNumber;
    private StringProperty Email;


    public passengerViewModel(ClientText clientText) {
        this.clientText = clientText;
        FirstName = new SimpleStringProperty();
        LastName = new SimpleStringProperty();
        TelNumber = new SimpleStringProperty();
        Email = new SimpleStringProperty();
        clientText.addListener(utils.NEWPASSENGER, this::onNewPassenger);

    }

    public void getPassengerInformation(int passenger) {

        String FirstName = this.FirstName.getValue();
        String LastName = this.LastName.getValue();
        String TelNumber = this.TelNumber.getValue();
        String Email = this.Email.getValue();


        SaveInfo.getInstance().setPassenger(clientText.getpassenger(passenger));
        System.out.println("Save PassengerInformation = " + SaveInfo.getInstance() );
    }


//    public Passenger getpass(){
//
//        return clientText.getpassenger(passenger);
//    }


    public void finish() {

        flights ft = SaveInfo.getInstance().getFlights();
        System.out.println("Gets SavedInfo from flights = " + SaveInfo.getInstance().getFlights());

        seat st = SaveInfo.getInstance().getSeat();
        System.out.println("Gets SavedInfo from seats = " + SaveInfo.getInstance().getSeat());

        Passenger pg = SaveInfo.getInstance().getPassenger();
        System.out.println("Gets SavedInfo from passenger = " + SaveInfo.getInstance().getPassenger());

        myFlightTicket myFlightTicket1 = new myFlightTicket(1, ft.price, pg,ft,st);
        clientText.createTicket(myFlightTicket1);
    }

    public void onNewPassenger(PropertyChangeEvent evt) {
        getPassengerInformation(1);
        System.out.println("viewmodel on new passenger");

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



}
