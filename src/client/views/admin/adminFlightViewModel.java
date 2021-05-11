package client.views.admin;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Flights;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class adminFlightViewModel {

    private ClientText clientText;

    private StringProperty flightId;

    private StringProperty flightName;

    private StringProperty price;

    private ObservableList<Flights> flights;



    public adminFlightViewModel(ClientText clientText) {
        this.clientText = clientText;
        flightId = new SimpleStringProperty();
        flightName = new SimpleStringProperty();
        price = new SimpleStringProperty();
        clientText.addListener(utils.NEWFLIGHT, this::onNewInputflight);

    }

    public void InsertFlightInformation() {

        if (flightId.getValue() != null && !"".equals(flightId.getValue()) && flightName.getValue() != null && !"".equals(flightName.getValue()) && price.getValue() != null && !"".equals(price.getValue())) {

            String FlightId = flightId.getValue();
            String Flightname = flightName.getValue();
            String Price = price.getValue();

            clientText.CreateFlights(FlightId,Flightname,Price);

        }

    }


    public void deleteFlight(){



    }



    public void loadFlights() {
        List<Flights> flight = clientText.getAllTheFLights();
        flights = FXCollections.observableArrayList(flight);
    }


    public void onNewInputflight(PropertyChangeEvent evt) {
        flights.add((Flights) evt.getNewValue());
    }



    public String getFlightId() {
        return flightId.get();
    }

    public StringProperty flightIdProperty() {
        return flightId;
    }

    public String getFlightName() {
        return flightName.get();
    }

    public StringProperty flightNameProperty() {
        return flightName;
    }

    public String getPrice() {
        return price.get();
    }

    public ObservableList<Flights> getFlights() {
        return flights;
    }

    public StringProperty priceProperty() {
        return price;
    }
}
