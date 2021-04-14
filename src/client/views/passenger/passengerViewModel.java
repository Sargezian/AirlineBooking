package client.views.passenger;

import client.model.ClientText;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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



        //Collections.addAll(, selectedrows);
    }

    public ObservableList<passenger> getPassengers() {
        return passengers;
    }


}
