package client.views.dashboard;

import client.model.ClientText;
import client.views.myflightplan.myflightplanViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.flights;
import shared.util.utils;
import java.beans.PropertyChangeEvent;
import java.util.List;


public class dashboardViewModel {

    private ClientText clientText;
    private ObservableList<flights> flights;
    private ObservableList<flights> selectedrows;

    public dashboardViewModel(ClientText clientText) {
        this.clientText = clientText;
        clientText.addListener(utils.NEWFLIGHT, this::onNewInputflight);
        // clientText.removeSelectedFlight(utils.REMOVEDFLIGHT, this::removeflight);
    }

    public void setSelected(ObservableList<flights> flights) {
        this.selectedrows = flights;
    }

    public void removeSelected() {
        //  System.out.println("minselect" + selectedrows);
         flights.removeAll(selectedrows);
        //flights.addAll(selectedrows);
    }

/*    public void addSelected() {
        for (int i = 0; i < my.size(); i++) {
            //selectedrows.add(i, my.get(i));
            //flights.removeAll(selectedrows);
            flights.add(i, my.get(i));
        }*/
    //}

    public void loadFlights() {
        List<flights> flight = clientText.getflights();
        flights = FXCollections.observableArrayList(flight);
    }

    public void onNewInputflight(PropertyChangeEvent  evt) {
        flights.add((flights) evt.getNewValue());
    }

    public ObservableList<flights> getflight() {
        return flights;
    }

    public ObservableList<flights> getSelectedrows() {
        return selectedrows;
    }
}
