package client.views.dashboard;

import client.model.ClientText;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.flights;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class dashboardViewModel {

    private ClientText clientText;
    private ObservableList<shared.transferobjects.flights> flights;
    private dashboardViewController dv;
    private ObservableList<shared.transferobjects.flights> selectedrows;

    public dashboardViewModel(ClientText clientText) {
        this.clientText = clientText;
        clientText.addListener(utils.NEWFLIGHT, this::onNewInputflight);
        // clientText.removeSelectedFlight(utils.REMOVEDFLIGHT, this::removeflight);
    }

    public void setSelected(ObservableList<shared.transferobjects.flights> flights) {
        this.selectedrows = flights;
    }

    public void selected() {
        flights.removeAll(selectedrows);
        /*clientText.removeSelectedFlight();*/
    }


    public void loadfligts() {
        List<shared.transferobjects.flights> flight = clientText.getflights();
        //flights = FXCollections.observableArrayList(flight);

        flights = FXCollections.observableArrayList(
                new flights("airplane1", "1"),
                new flights("airplane2", "1"),
                new flights("airplane3", "1"),
                new flights("airplane4", "1"),
                new flights("airplane5","1"));
    }

    public void onNewInputflight(PropertyChangeEvent evt) {
        flights.add((flights) evt.getNewValue());
    }

    ObservableList<flights> getflight() {
        return flights;
    }

}
