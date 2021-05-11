package client.views.admin;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Arrival;
import shared.transferobjects.Depature;
import shared.transferobjects.Flights;
import shared.transferobjects.PlaneType;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class adminFlightViewModel {

    private ClientText clientText;

    private StringProperty flightId;

    private StringProperty flightName;

    private StringProperty price;

    private StringProperty Arrivals;

    private StringProperty ArrivalDate;

    private StringProperty Departures;

    private StringProperty DepartureDate;

    private StringProperty PlaneTypes;

    private ObservableList<Flights> flights;

    private ObservableList<Arrival> arrivals;

    private ObservableList<Depature> depatures;

    private  ObservableList<PlaneType> planeTypes;





    public adminFlightViewModel(ClientText clientText) {
        this.clientText = clientText;
        flightId = new SimpleStringProperty();
        flightName = new SimpleStringProperty();
        price = new SimpleStringProperty();
        Arrivals = new SimpleStringProperty();
        Departures = new SimpleStringProperty();
        ArrivalDate = new SimpleStringProperty();
        DepartureDate = new SimpleStringProperty();
        PlaneTypes = new SimpleStringProperty();


        clientText.addListener(utils.NEWFLIGHT, this::onNewInputflight);
        clientText.addListener(utils.NEWARRIVAL, this::onNewInputArrival);
        clientText.addListener(utils.NEWDEPARTURE, this::onNewInputDeparture);
        clientText.addListener(utils.NEWPLANE, this::onNewInputPlane);

    }

    public void InsertFlightInformation() {

        if (flightId.getValue() != null && !"".equals(flightId.getValue()) && flightName.getValue() != null && !"".equals(flightName.getValue()) && price.getValue() != null && !"".equals(price.getValue())) {


            String FlightId = flightId.getValue();
            String Flightname = flightName.getValue();
            String Price = price.getValue();

            clientText.CreateFlights(FlightId,Flightname,Price);

        }

    }

    public void InsertArrivalInformation() {

        if (Arrivals.getValue() != null && !"".equals(Arrivals.getValue()) && ArrivalDate.getValue() != null && !"".equals(ArrivalDate.getValue())) {


            String arrival = Arrivals.getValue();
            String arrivalDate = ArrivalDate.getValue();


            clientText.CreateArrival(arrival,arrivalDate);

        }

    }


    public void InsertDepartureInformation() {

        if ( Departures.getValue() != null && !"".equals(Departures.getValue()) && DepartureDate.getValue() != null && !"".equals(DepartureDate.getValue())) {


            String departures = Departures.getValue();
            String departureDate = DepartureDate.getValue();


            clientText.CreateDeparture(departures,departureDate);

        }

    }


    public void InsertPlaneInformation() {

        if (PlaneTypes.getValue() != null && !"".equals(PlaneTypes.getValue())) {


            String planeTypes = PlaneTypes.getValue();


            clientText.CreatePlane(planeTypes);

        }

    }





    public void deleteFlight(){



    }



    public void loadFlights() {
        List<Flights> flight = clientText.getAllTheFLights();
        flights = FXCollections.observableArrayList(flight);
    }


    public void loadArrival() {
        List<Arrival> arrivals = clientText.getAllArrival();
        this.arrivals = FXCollections.observableArrayList(arrivals);
    }


    public void loadDeparture() {
        List<Depature> depatures = clientText.getAllDeparture();
        this.depatures = FXCollections.observableArrayList(depatures);
    }


    public void loadPlane() {
        List<PlaneType> planeTypes1 = clientText.getAllPlaneType();
        planeTypes = FXCollections.observableArrayList(planeTypes1);
    }



    public void onNewInputflight(PropertyChangeEvent evt) {
        flights.add((Flights) evt.getNewValue());
    }

    public void onNewInputArrival(PropertyChangeEvent evt) {
        arrivals.add((Arrival) evt.getNewValue());
    }


    public void onNewInputDeparture(PropertyChangeEvent evt) {
        depatures.add((Depature) evt.getNewValue());
    }


    public void onNewInputPlane(PropertyChangeEvent evt) {
        planeTypes.add((PlaneType) evt.getNewValue());
    }





    public String getArrivals() {
        return Arrivals.get();
    }

    public StringProperty arrivalsProperty() {
        return Arrivals;
    }

    public String getArrivalDate() {
        return ArrivalDate.get();
    }

    public StringProperty arrivalDateProperty() {
        return ArrivalDate;
    }

    public String getDepartures() {
        return Departures.get();
    }

    public StringProperty departuresProperty() {
        return Departures;
    }

    public String getDepartureDate() {
        return DepartureDate.get();
    }

    public StringProperty departureDateProperty() {
        return DepartureDate;
    }

    public String getPlaneTypes() {
        return PlaneTypes.get();
    }

    public StringProperty planeTypesProperty() {
        return PlaneTypes;
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

    public ObservableList<Flights> getFlightsList() {
        return flights;
    }

    public ObservableList<Arrival> getArrivalsList() {
        return arrivals;
    }

    public ObservableList<Depature> getDepatures() {
        return depatures;
    }

    public ObservableList<PlaneType> getPlanetyp() {
        return planeTypes;
    }

    public StringProperty priceProperty() {
        return price;
    }
}
