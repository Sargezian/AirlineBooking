package client.views.passenger;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Myflightlist;
import shared.transferobjects.flights;
import shared.transferobjects.passenger;
import shared.transferobjects.seat;

import java.util.List;

public class passengerViewModel {

    private ClientText clientText;
    private StringProperty FirstName;
    private StringProperty LastName;
    private StringProperty TelNumber;



    public passengerViewModel(ClientText clientText) {
        this.clientText = clientText;
        FirstName = new SimpleStringProperty();
        LastName = new SimpleStringProperty();
        TelNumber = new SimpleStringProperty();
    }


    public void getPassengerInformation() {

        String FirstName = this.FirstName.getValue();
        String LastName = this.LastName.getValue();
        String TelNumber = this.TelNumber.getValue();

        SaveInfo.getInstance().setPassenger(clientText.passernger(FirstName,LastName,TelNumber));
        System.out.println("Save PassengerInformation = " + SaveInfo.getInstance() );
    }



    public void finish() {

        flights ft = SaveInfo.getInstance().getFlights();
        System.out.println("Gets SavedInfo from flights = " + SaveInfo.getInstance().getFlights());

        seat st = SaveInfo.getInstance().getSeat();
        System.out.println("Gets SavedInfo from seats = " + SaveInfo.getInstance().getSeat());

        passenger pg = SaveInfo.getInstance().getPassenger();
        System.out.println("Gets SavedInfo from passenger = " + SaveInfo.getInstance().getPassenger());

        Myflightlist myflightlist1 = new Myflightlist(1, ft.price, pg,ft,st);
        clientText.createTicket(myflightlist1);
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
