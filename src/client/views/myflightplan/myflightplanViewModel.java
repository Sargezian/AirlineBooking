package client.views.myflightplan;

import client.model.ClientText;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.myFlightTicket;

import java.util.List;

public class myflightplanViewModel {

    private ClientText clientText;
    private ObservableList<myFlightTicket> my;

    public myflightplanViewModel(ClientText clientText) {
        this.clientText = clientText;
    }

    public void loadMyFlights() {
        List<myFlightTicket> flight = clientText.getflightlist();
        my = FXCollections.observableArrayList(flight);
        System.out.println("loadlflights = " + flight);
        //Collections.addAll(, selectedrows);
    }

    public ObservableList<myFlightTicket> getMy() {
        System.out.println("getmy = " + my);
        return my;
    }


}
