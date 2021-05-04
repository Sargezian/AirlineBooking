package client.views.myflightplan;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.*;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class myflightplanViewModel {

    private ClientText clientText;
    private ObservableList<myFlightTicket> myFlightTickets;
    private StringProperty username;

    public myflightplanViewModel(ClientText clientText) {
        System.out.println("myFlight view model");
        this.clientText = clientText;
        clientText.addListener(utils.NEWTICKET, this::onNewTicket);
        clientText.addListener(utils.NEWTICKET, this::setUsernameProperty);
        username = new SimpleStringProperty();

    }

    public void setUsernameProperty(PropertyChangeEvent event) {
        setUsername();
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

    public void setUsername(){

        InputUser user = SaveInfo.getInstance().getUser();


        clientText.readUsername(user.user);



        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                username.setValue(user.getOutput());

            }
        });


    }




    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }


}