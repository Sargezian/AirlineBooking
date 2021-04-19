package client.views.passenger;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Myflightlist;
import shared.transferobjects.flights;
import shared.transferobjects.passenger;
import shared.transferobjects.seat;

import java.util.List;

public class passengerViewModel {

    private ClientText clientText;
    private ObservableList<passenger> passengers;

    public passengerViewModel(ClientText clientText) {
        this.clientText = clientText;
    }

    public void loadPassenger(){
        List<passenger> passenger = clientText.getPassenger();
        passengers = FXCollections.observableArrayList(passenger);
    }

    public ObservableList<passenger> getPassengers() {
        return passengers;
    }

    public void getPassengerInformation(passenger passenger) {


        SaveInfo.getInstance().setPassenger(passenger);
        System.out.println("Save PassengerInformation = " + SaveInfo.getInstance() );
    }

    public void finish() {


        flights ft = SaveInfo.getInstance().getFlights();
        System.out.println("Gets SavedInfo from flights = " + SaveInfo.getInstance().getFlights());

        seat st = SaveInfo.getInstance().getSeat();
        System.out.println("Gets SavedInfo from seats = " + SaveInfo.getInstance().getSeat());

        passenger pg = SaveInfo.getInstance().getPassenger();
        System.out.println("Gets SavedInfo from passenger = " + SaveInfo.getInstance().getPassenger());

        Myflightlist myflightlist1 = new Myflightlist(null, ft.price, pg,ft,st);
        clientText.createTicket(myflightlist1);
    }

}
