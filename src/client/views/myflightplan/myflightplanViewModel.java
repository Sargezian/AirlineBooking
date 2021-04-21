package client.views.myflightplan;

import client.model.ClientText;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.myFlightTicket;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class myflightplanViewModel {

    private ClientText clientText;
    private ObservableList<myFlightTicket> my;



    public myflightplanViewModel(ClientText clientText) {
        System.out.println("myFlight view model");
        this.clientText = clientText;
        clientText.addListener(utils.NEWTICKET, this::onNewTicket);

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


    public void onNewTicket(PropertyChangeEvent evt) {
        // getPassengerInformation(1);
        my.clear();
        List<myFlightTicket> getflightlist = clientText.getflightlist();
        System.out.println("viewmodel on new passenger" + getflightlist.size());
        my.addAll(getflightlist);



    }


}
