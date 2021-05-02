package client.views.myflightplan;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.InputUser;
import shared.transferobjects.Passenger;
import shared.transferobjects.myFlightTicket;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class myflightplanViewModel {

    private ClientText clientText;
    private ObservableList<myFlightTicket> myFlightTickets;

    public myflightplanViewModel(ClientText clientText) {
        System.out.println("myFlight view model");
        this.clientText = clientText;
        clientText.addListener(utils.NEWTICKET, this::onNewTicket);

    }

    public void loadMyFlights() {

        InputUser id = SaveInfo.getInstance().getUser();

        List<myFlightTicket> flight = clientText.getflightlist(id.getId());

        myFlightTickets = FXCollections.observableArrayList(flight);
        System.out.println("loadlflights = " + flight);
        //Collections.addAll(, selectedrows);
    }

   /* public void loadPriceSUM() {
        List<myFlightTicket> pricelist = clientText.ReadPriceSUM();
        myFlightTickets = FXCollections.observableArrayList(pricelist);

    }*/

    public ObservableList<myFlightTicket> getMyFlightTickets() {
        System.out.println("myFlightTickets = " + myFlightTickets);
        return myFlightTickets;
    }

    public void onNewTicket(PropertyChangeEvent evt) {
        // getPassengerInformation(1);
        myFlightTickets.clear();
        InputUser id = SaveInfo.getInstance().getUser();

        List<myFlightTicket> getflightlist = clientText.getflightlist(id.getId());
        System.out.println("viewmodel on new passenger" + getflightlist.size());
        myFlightTickets.addAll(getflightlist);

    }

// TODO: 25/04/2021 email og passenger name skal laves her

}
