package client.views.admin;

import client.model.ClientModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
    private IntegerProperty seatId;
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

        seatId = new SimpleIntegerProperty();
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


    public void InsertSeatInfomation()
    {

        if (seatId.getValue() != null && !"".equals(seatId.getValue()) && seatNumber.getValue() != null && !"".equals(seatNumber.getValue()) && classType.getValue() != null && !"".equals(classType.getValue()))  {


            String SeatNumber = this.seatNumber.getValue();
            String SeatClassType = this.classType.getValue();
            clientModel.CreateSeat(SeatNumber,SeatClassType);


        }

    }

    public void InsertAirportInfomation()
    {

        if (airportId.getValue() != null && !"".equals(airportId.getValue()) && airportCity.getValue() != null && !"".equals(airportCity.getValue()) && airportName.getValue() != null && !"".equals(airportName.getValue()))  {

            String AirportID = this.airportId.getValue();
            String AirportName = this.airportName.getValue();
            String AirportCity = this.airportCity.getValue();
            clientModel.CreateAirport(AirportID,AirportName,AirportCity);

        }

    }

    //flight
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

    //arrival
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

    //departure
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

    //planetype
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
        if (seatId.getValue() == null)
        {
            error.set("seatId cannot be empty");
            return false;
        }
        if (seatNumber.getValue() == null)
        {
            error.set("SeatNumber cannot be empty");
            return false;
        }
        if (!classType.getValue().equals("Economy class") || !classType.getValue().equals("Business class") || !classType.getValue().equals("First class"))
        {
            error.set("classType must be either; Economy class, Business class or First class ");
            return false;
        }

        else
        {
            return true;
        }

    }


    public boolean validateAirportInformation()
    {
        //airport
        if (airportId.getValue() == null)
        {
            error.set("AirportID cannot be empty");
            return false;
        }
        if (airportId.getValue().length() != 3)
        {
            error.set("airportID must be 3 characters");
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



    public void loadSeat() {
        List<Seat> seat = clientModel.getSeats();
        seatObservableList = FXCollections.observableArrayList(seat);
    }

    public void loadAirport() {
        List<Airport> airportList = clientModel.getAirport();
        airportObservableList = FXCollections.observableArrayList(airportList);
    }

    public void onNewInputAirport(PropertyChangeEvent event) {
        airportObservableList.add((Airport) event.getNewValue());

    }

    public void onNewInputSeat(PropertyChangeEvent event) {
        seatObservableList.add((Seat) event.getNewValue());
    }

    public ObservableList<Seat> getSeatObservableList() {
        return seatObservableList;
    }

    public ObservableList<Airport> getAirportObservableList() {
        return airportObservableList;
    }

    public String getAirportId()
    {
        return airportId.get();
    }

    public StringProperty airportIdProperty()
    {
        return airportId;
    }

    public void setAirportId(String airportId)
    {
        this.airportId.set(airportId);
    }

    public String getAirportName()
    {
        return airportName.get();
    }

    public StringProperty airportNameProperty()
    {
        return airportName;
    }

    public void setAirportName(String airportName)
    {
        this.airportName.set(airportName);
    }

    public String getAirportCity()
    {
        return airportCity.get();
    }

    public StringProperty airportCityProperty()
    {
        return airportCity;
    }

    public void setAirportCity(String airportCity)
    {
        this.airportCity.set(airportCity);
    }

    public String getError()
    {
        return error.get();
    }

    public StringProperty errorProperty()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error.set(error);
    }

    public int getSeatId()
    {
        return seatId.get();
    }

    public IntegerProperty seatIdProperty()
    {
        return seatId;
    }

    public void setSeatId(int seatId)
    {
        this.seatId.set(seatId);
    }

    public String getSeatNumber()
    {
        return seatNumber.get();
    }

    public StringProperty seatNumberProperty()
    {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber)
    {
        this.seatNumber.set(seatNumber);
    }

    public String getClassType()
    {
        return classType.get();
    }

    public StringProperty classTypeProperty()
    {
        return classType;
    }

    public void setClassType(String classType)
    {
        this.classType.set(classType);
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
