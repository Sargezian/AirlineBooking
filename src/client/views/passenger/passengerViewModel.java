package client.views.passenger;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.beans.property.*;
import shared.transferobjects.*;

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
