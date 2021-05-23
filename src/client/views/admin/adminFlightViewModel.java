package client.views.admin;

import client.model.ClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.*;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class adminFlightViewModel {

    private ClientModel clientModel;

    //flight
    private StringProperty flightId;
    private StringProperty flightName;
    private StringProperty price;
    private ObservableList<Flights> flights;

    //arrival
    private StringProperty Arrivals;
    private StringProperty ArrivalDate;
    private ObservableList<Arrival> arrivals;

    //departure
    private StringProperty Departures;
    private StringProperty DepartureDate;
    private ObservableList<Depature> depatures;

    //planetype
    private StringProperty PlaneTypes;
    private  ObservableList<PlaneType> planeTypes;

    //seat
    private StringProperty seatNumber;
    private StringProperty classType;
    private ObservableList<Seat>seatObservableList;

    //airport
    private StringProperty airportId;
    private StringProperty airportName;
    private StringProperty airportCity;
    private ObservableList<Airport> airportObservableList;

    //error label
    private StringProperty error;

    //constructor
    public adminFlightViewModel(ClientModel clientModel) {
        this.clientModel = clientModel;

        flightId = new SimpleStringProperty();
        flightName = new SimpleStringProperty();
        price = new SimpleStringProperty();

        Arrivals = new SimpleStringProperty();
        ArrivalDate = new SimpleStringProperty();

        Departures = new SimpleStringProperty();
        DepartureDate = new SimpleStringProperty();

        PlaneTypes = new SimpleStringProperty();

        seatNumber = new SimpleStringProperty();
        classType = new SimpleStringProperty();

        airportId = new SimpleStringProperty();
        airportName = new SimpleStringProperty();
        airportCity = new SimpleStringProperty();

        error = new SimpleStringProperty();
        clientModel.addListener(utils.NEWSEAT,this::onNewInputSeat);
        clientModel.addListener(utils.NEWAIRPORT,this::onNewInputAirport);
        clientModel.addListener(utils.NEWFLIGHT, this::onNewInputflight);
        clientModel.addListener(utils.NEWARRIVAL, this::onNewInputArrival);
        clientModel.addListener(utils.NEWDEPARTURE, this::onNewInputDeparture);
        clientModel.addListener(utils.NEWPLANE, this::onNewInputPlane);
    }

    //InsertInformation
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
    public void InsertSeatInfomation() {

        if (seatNumber.getValue() != null && !"".equals(seatNumber.getValue()) && classType.getValue() != null && !"".equals(classType.getValue()))  {


            String SeatNumber = this.seatNumber.getValue();
            String SeatClassType = this.classType.getValue();
            clientModel.CreateSeat(SeatNumber,SeatClassType);


        }

    }
    public void InsertAirportInfomation() {
        if (airportId.getValue() != null && !"".equals(airportId.getValue()) && airportCity.getValue() != null && !"".equals(airportCity.getValue()) && airportName.getValue() != null && !"".equals(airportName.getValue()))  {

            String AirportID = this.airportId.getValue();
            String AirportName = this.airportName.getValue();
            String AirportCity = this.airportCity.getValue();
            clientModel.CreateAirport(AirportID,AirportName,AirportCity);

        }
    }


    public boolean validate(){
        if(validateFlightInformation() && validateArrivalInformation() && validateDepartureInformation() && validateSeatInformation() && validatePlanetypeInformation() && validateAirportInformation()){

            return true;


        } else{
            return false;
        }



    }

    //validateInformation
    public boolean validateFlightInformation() {
        if (flightId.getValue() == null)
        {
            error.set("flightID cannot be empty");
            return false;
        }
        if (flightName.getValue() == null)
        {
            error.set("flight Name cannot be empty");
            return false;
        }
        if (price.getValue() == null)
        {
            error.set("price cannot be empty");
            return false;
        }

        else
        {
            return true;
        }
    }
    public boolean validateArrivalInformation() {
        if (Arrivals.getValue() == null)
        {
            error.set("Arrivals cannot be empty");
            return false;
        }
        if (ArrivalDate.getValue() == null)
        {
            error.set("ArrivalDate cannot be empty");
            return false;
        }

        else
        {
            return true;
        }

    }
    public boolean validateDepartureInformation() {
        if (Departures.getValue() == null)
        {
            error.set("Departure cannot be empty");
            return false;
        }
        if (DepartureDate.getValue() == null)
        {
            error.set("DepartureDate cannot be empty");
            return false;
        }

        else
        {
            return true;
        }
    }
    public boolean validatePlanetypeInformation() {
        if (PlaneTypes.getValue() == null)
        {
            error.set("planetype cannot be empty");
            return false;
        }

        else
        {
            return true;
        }

    }
    public boolean validateSeatInformation() {
        if (seatNumber.getValue() != null)
        {
            return true;
        }
        if (classType.getValue().equals("Economy class") || classType.getValue().equals("Business class") || classType.getValue().equals("First class"))
        {
            return true;
        }

        else
        {
            error.set("classType must be either; Economy class, Business class or First class ");
            return false;
        }

    }
    public boolean validateAirportInformation() {
        //airport
        if (airportId.getValue() == null)
        {
            error.set("AirportID cannot be empty");
            return false;
        }
        if (airportId.getValue().length() > 3)
        {
            error.set("airportID must be under 3 characters");
            return false;
        }

        if (airportName.getValue() == null)
        {
            error.set("Airport Name cannot be empty");
            return false;
        }
        if (airportCity.getValue() == null)
        {
            error.set("Airport City cannot be empty");
            return false;
        }
        else
        {
            return true;
        }
    }

    //load
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
    public void loadSeat() {
        List<Seat> seat = clientModel.getSeats();
        seatObservableList = FXCollections.observableArrayList(seat);
    }
    public void loadAirport() {
        List<Airport> airportList = clientModel.getAirport();
        airportObservableList = FXCollections.observableArrayList(airportList);
    }

    //propertyChangeEvent
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
    public void onNewInputSeat(PropertyChangeEvent event) {
        seatObservableList.add((Seat) event.getNewValue());
    }
    public void onNewInputAirport(PropertyChangeEvent event) {
        airportObservableList.add((Airport) event.getNewValue());

    }

    //stringproperty
    public StringProperty arrivalsProperty() {
        return Arrivals;
    }
    public StringProperty arrivalDateProperty() {
        return ArrivalDate;
    }
    public StringProperty departuresProperty() {
        return Departures;
    }
    public StringProperty departureDateProperty() {
        return DepartureDate;
    }
    public StringProperty planeTypesProperty() {
        return PlaneTypes;
    }
    public StringProperty flightIdProperty() {
        return flightId;
    }
    public StringProperty flightNameProperty() {
        return flightName;
    }
    public StringProperty priceProperty() {
        return price;
    }
    public StringProperty classTypeProperty()
    {
        return classType;
    }
    public StringProperty errorProperty()
    {
        return error;
    }
    public StringProperty seatNumberProperty()
    {
        return seatNumber;
    }
    public StringProperty airportCityProperty()
    {
        return airportCity;
    }
    public StringProperty airportNameProperty()
    {
        return airportName;
    }
    public StringProperty airportIdProperty()
    {
        return airportId;
    }

    //observableList
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
    public ObservableList<Seat> getSeatObservableList() {
        return seatObservableList;
    }
    public ObservableList<Airport> getAirportObservableList() {
        return airportObservableList;
    }


}
