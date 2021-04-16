package client.views.passenger;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.passenger;

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
        clientText.finish();
    }

}
