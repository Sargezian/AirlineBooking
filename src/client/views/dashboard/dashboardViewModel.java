package client.views.dashboard;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.flights;
import shared.util.utils;
import java.beans.PropertyChangeEvent;
import java.util.List;

public class dashboardViewModel {

    // TODO: 04/05/2021 felter tomme efter login

    // TODO: 04/05/2021 lave evt. en klokke til foside

    // TODO: 04/05/2021 lave admin side

    // TODO: 04/05/2021 print billet ud når ticket er lavet

    private ClientText clientText;
    private ObservableList<flights> flights;
    private StringProperty search;
    private StringProperty error;


    public dashboardViewModel(ClientText clientText) {
        this.clientText = clientText;
        search = new SimpleStringProperty();
        error = new SimpleStringProperty();
        clientText.addListener(utils.NEWFLIGHT, this::onNewInputflight);
    }


    public void loadFlights() {
        List<flights> flight = clientText.getflights();
        flights = FXCollections.observableArrayList(flight);

    }

    public boolean getFlightInformation(flights flights) {

        if (flights != null) {
            SaveInfo.getInstance().setFlights(flights);
            System.out.println("Save flightInformation  = " + SaveInfo.getInstance());
            return true;
        }else {
            error.set("Please choose a flight for continue ");
            return false;
        }
    }

    public void search(){
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

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }
}
