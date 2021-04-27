package client.views.dashboard;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import shared.transferobjects.flights;
import shared.util.utils;
import java.beans.PropertyChangeEvent;
import java.util.List;

public class dashboardViewModel {

    private ClientText clientText;
    private ObservableList<flights> flights;
    private ObservableList<flights> selectedrows;
    private StringProperty search;


    public dashboardViewModel(ClientText clientText) {
        this.clientText = clientText;
        search = new SimpleStringProperty();
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

    public void getFlightInformation(flights flights) {
        SaveInfo.getInstance().setFlights(flights);
        System.out.println("Save flightInformation  = " + SaveInfo.getInstance());
    }

    public void se(){
        flights.setAll(clientText.readByName(search.getValue()));


    }




    public String getSearch() {
        return search.get();
    }

    public StringProperty searchProperty() {
        return search;
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
