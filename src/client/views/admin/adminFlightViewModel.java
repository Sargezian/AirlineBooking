package client.views.admin;

import client.model.ClientModel;
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

    private ClientModel clientModel;

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





    public adminFlightViewModel(ClientModel clientModel) {
        this.clientModel = clientModel;
        flightId = new SimpleStringProperty();
        flightName = new SimpleStringProperty();
        price = new SimpleStringProperty();
        Arrivals = new SimpleStringProperty();
        Departures = new SimpleStringProperty();
        ArrivalDate = new SimpleStringProperty();
        DepartureDate = new SimpleStringProperty();
        PlaneTypes = new SimpleStringProperty();


        clientModel.addListener(utils.NEWFLIGHT, this::onNewInputflight);
        clientModel.addListener(utils.NEWARRIVAL, this::onNewInputArrival);
        clientModel.addListener(utils.NEWDEPARTURE, this::onNewInputDeparture);
        clientModel.addListener(utils.NEWPLANE, this::onNewInputPlane);

    }

    public void InsertFlightInformation() {

        if (flightId.getValue() != null && !"".equals(flightId.getValue()) && flightName.getValue() != null && !"".equals(flightName.getValue()) && price.getValue() != null && !"".equals(price.getValue())) {


            String FlightId = flightId.getValue();
            String Flightname = flightName.getValue();
            String Price = price.getValue();

            clientModel.CreateFlights(FlightId,Flightname,Price);

        }

    }

    public void InsertArrivalInformation() {

        if (Arrivals.getValue() != null && !"".equals(Arrivals.getValue()) && ArrivalDate.getValue() != null && !"".equals(ArrivalDate.getValue())) {


            String arrival = Arrivals.getValue();
            String arrivalDate = ArrivalDate.getValue();


            clientModel.CreateArrival(arrival,arrivalDate);

        }

    }


    public void InsertDepartureInformation() {

        if ( Departures.getValue() != null && !"".equals(Departures.getValue()) && DepartureDate.getValue() != null && !"".equals(DepartureDate.getValue())) {


            String departures = Departures.getValue();
            String departureDate = DepartureDate.getValue();


            clientModel.CreateDeparture(departures,departureDate);

        }

    }


    public void InsertPlaneInformation() {

        if (PlaneTypes.getValue() != null && !"".equals(PlaneTypes.getValue())) {


            String planeTypes = PlaneTypes.getValue();


            clientModel.CreatePlane(planeTypes);

        }

    }


    public boolean deleteFlight(Flights flights){

        clientModel.deleteFlight(flights);
        this.flights.removeAll(flights);

        return true;

    }


    public boolean deleteArrival(Arrival arrival){
        clientModel.deleteArrival(arrival);
        this.arrivals.removeAll(arrival);
        return true;

    }


    public boolean deleteDeparture(Depature depature){

       clientModel.deleteDeparture(depature);
        this.depatures.removeAll(depatures);
        return true;

    }



    public boolean deletePlaneType(PlaneType planeType){
         clientModel.deletePlaneType(planeType);
        this.planeTypes.removeAll(planeType);
        return true;

    }








    public void loadFlights() {
        List<Flights> flight = clientModel.getAllTheFLights();
        flights = FXCollections.observableArrayList(flight);
    }


    public void loadArrival() {
        List<Arrival> arrivals = clientModel.getAllArrival();
        this.arrivals = FXCollections.observableArrayList(arrivals);
    }


    public void loadDeparture() {
        List<Depature> depatures = clientModel.getAllDeparture();
        this.depatures = FXCollections.observableArrayList(depatures);
    }


    public void loadPlane() {
        List<PlaneType> planeTypes1 = clientModel.getAllPlaneType();
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
