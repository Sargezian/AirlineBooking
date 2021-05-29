package client.views.dashboard;

import client.model.ClientModel;
import client.model.SaveInfo;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Flights;
import shared.util.utils;

import javax.mail.internet.AddressException;
import java.beans.PropertyChangeEvent;
import java.util.List;

public class dashboardViewModel {

    private ClientModel clientModel;
    private ObservableList<Flights> flights;
    private StringProperty search;
    private StringProperty error;
    private StringProperty clock;

    public dashboardViewModel(ClientModel clientModel) {
        this.clientModel = clientModel;
        search = new SimpleStringProperty();
        error = new SimpleStringProperty();
        clock = new SimpleStringProperty();
        clientModel.addListener(utils.NEWFLIGHT, this::onNewInputflight);
        clientModel.addListener("time", this::clockProperty);
    }

    //loadflights
    public void loadFlights() {
        List<Flights> flight = clientModel.getflights();
        flights = FXCollections.observableArrayList(flight);
    }

    //getflight information
    public boolean getFlightInformation(Flights flights) {
        if (flights != null) {
            SaveInfo.getInstance().setFlights(flights);
            System.out.println("Save flightInformation  = " + SaveInfo.getInstance());
            return true;
        }else {
            error.set("Please choose a flight for continue ");
            return false;
        }
    }

    //clock
    public void startClock(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                clock.setValue(String.valueOf(clientModel.clock()));
            }
        });
    }

    private void clockProperty(PropertyChangeEvent event) {
        startClock();
    }

    public boolean checkIfFlightSearchIsNull() {
         search();
        if (flights.isEmpty()){
            error.setValue("Could not find the search given");
            search();
            return false;

        } else {
            error.setValue("");
            return true;
        }

    }



    //search
    public void search(){
        flights.setAll(clientModel.readByName(search.getValue()));
    }

    public void onNewInputflight(PropertyChangeEvent  evt) {
        loadFlights();
        search();
    }


    public ObservableList<Flights> getflight() {
        return flights;
    }

    public StringProperty searchProperty() {
        return search;
    }
    public StringProperty errorProperty() {
        return error;
    }
    public StringProperty clockProperty(){return clock;}


}


