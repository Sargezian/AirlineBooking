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
        clientModel.addListener("time", this::clockPropertye);
    }


    public void loadFlights() {
        List<Flights> flight = clientModel.getflights();
        flights = FXCollections.observableArrayList(flight);
    }



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

    public void startClock(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                clock.setValue(String.valueOf(clientModel.clock()));
            }
        });
    }

    private void clockPropertye(PropertyChangeEvent event) {
        startClock();
    }

    public void search(){
        flights.setAll(clientModel.readByName(search.getValue()));
    }

    public String getSearch() {
        return search.get();
    }

    public StringProperty searchProperty() {
        return search;
    }

    public void onNewInputflight(PropertyChangeEvent  evt) {
        loadFlights();

    }

    public ObservableList<Flights> getflight() {
        return flights;
    }

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }

    public StringProperty clockProperty(){return clock;}


}


