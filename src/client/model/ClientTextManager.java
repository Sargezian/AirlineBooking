package client.model;

import client.network.Client;

import shared.transferobjects.*;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

public class ClientTextManager implements ClientText {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;

    public ClientTextManager(Client client) {
        System.out.println("client textmanager");
        this.client = client;
        client.startClient();
        client.addListener(utils.NEWCHAT, this::onNewInputChat);
        client.addListener(utils.NEWUSER, this::onNewInputUser);
        client.addListener(utils.NEWTICKET, this::onNewTicket);
        client.addListener(utils.NEWFLIGHT,this::onNewFlight);
        client.addListener(utils.NEWARRIVAL,this::onNewArrival);
        client.addListener(utils.NEWDEPARTURE,this::onNewDeparture);
        client.addListener(utils.NEWPLANE,this::onNewPlane);
        client.addListener(utils.NEWSEAT,this::onNewSeat);
        client.addListener(utils.NEWAIRPORT,this::onNewAirport);


    }

    private void onNewAirport(PropertyChangeEvent event) {
        support.firePropertyChange(event);
    }

    private void onNewSeat(PropertyChangeEvent event) {
        support.firePropertyChange(event);
    }

    private void onNewTicket(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange(propertyChangeEvent);
    }

    private void onNewFlight(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange(propertyChangeEvent);
    }

    private void onNewArrival(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange(propertyChangeEvent);
    }

    private void onNewDeparture(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange(propertyChangeEvent);
    }

    private void onNewPlane(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange(propertyChangeEvent);
    }


    private void onNewInputChat(PropertyChangeEvent evt) {
        support.firePropertyChange(evt);
    }

    private void onNewInputUser(PropertyChangeEvent evt) {
        support.firePropertyChange(evt);
    }

    @Override
    public InputChat createChat(String chat, double star) {
        return client.createChat(chat, star);
    }

    @Override
    public List<InputChat> getChat() {
        return client.getChat();
    }

    @Override
    public int CountChat() {
        return client.CountChat();
    }

    @Override
    public int CountRatings(double star) {
        return client.CountRatings(star);
    }

    @Override
    public InputUser username(String user, String password) {
        return client.username(user, password);
    }

    @Override
    public boolean ValidateUser(String user, String password) {
        return client.ValidateUser(user,password);
    }

    @Override
    public List<InputUser> getUser() {
       return client.getUser();
    }

    @Override
    public List<Flights> getflights() {
        return client.getflights();
    }

    @Override
    public List<Flights> readByName(String searchString) {
        return client.readByName(searchString);
    }

    @Override
    public Flights CreateFlights(String flightID, String flightName, String price) {
        return client.CreateFlights(flightID,flightName, price);
    }

    @Override
    public void deleteFlight(Flights flights) {
        client.deleteFlight(flights);

    }

    @Override
    public List<Flights> getAllTheFLights() {
        return client.getAllTheFLights();
    }

    @Override
    public Arrival CreateArrival(String Arrival, String Arrivaldate) {
        return client.CreateArrival(Arrival,Arrivaldate);
    }

    @Override
    public Depature CreateDeparture(String Departure, String DepartureDate) {
        return client.CreateDeparture(Departure,DepartureDate);
    }

    @Override
    public PlaneType CreatePlane(String PlaneTypes) {
        return client.CreatePlane(PlaneTypes);
    }

    @Override
    public List<PlaneType> getAllPlaneType() {
        return client.getAllPlaneType();
    }

    @Override
    public List<Depature> getAllDeparture() {
        return client.getAllDeparture();
    }

    @Override
    public List<Arrival> getAllArrival() {
        return client.getAllArrival();
    }

    @Override
    public void deleteArrival(Arrival arrival) {
        client.deleteArrival(arrival);

    }

    @Override
    public void deleteDeparture(Depature depature) {
        client.deleteDeparture(depature);

    }

    @Override
    public void deletePlaneType(PlaneType planeType) {
             client.deletePlaneType(planeType);
    }

    @Override
    public List<Seat> getSeats() {
        return client.getSeats();
    }

    @Override
    public List<Airport> getAirport() {
        return client.getAirport();
    }

    //-----------------------Seat Start---------------------------------------------
    @Override
    public List<Seat> getSeat(int planeId) {
            return client.getSeat(planeId);
    }

    @Override public Seat getSeatId(int seatID, String seatNumber,
                                    String classType)
    {
       return client.getSeatId(seatID,seatNumber,classType);
    }

    @Override public Seat CreateSeat(String SeatNumber,
        String classtype)
    {
        return client.CreateSeat(SeatNumber,classtype);
    }


    @Override public Airport CreateAirport(String airportId, String airportName, String airportCity)

    {
        return client.CreateAirport(airportId,airportName,airportCity);
    }


    //--------------------------Seat End--------------------------------------------

    @Override
    public InputUser readUser(String user, String password) {
        return client.readUser(user,password);
    }

    @Override
    public InputUser readUsername(String user) {
        return client.readUsername(user);
    }

    @Override
    public List<Rating> getRatings() {
        return client.getRatings();
    }

    @Override
    public double AverageStars() {
        return client.AverageStars();
    }




    @Override
    public List<myFlightTicket> getflightlist(int userId) {
        return client.getflightlist(userId);
    }

    @Override public Passenger Createpassernger(String FirstName, String LastName,
                                                String TelNumber, String email)
    {
        return client.passernger(FirstName, LastName, TelNumber,email);
    }

    @Override
    public Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email) {
        return client.ReadPassenger(Firstname,LastName,TelNumber,Email);
    }

    @Override
    public Passenger readByEmail(String email) {
        return client.readByEmail(email);
    }


    @Override
    public Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate) {
        return client.payment(cardholderName,cardNumber,CVV,expirationDate);
    }

    @Override
    public Flights readFlightsFromShoppingCart(String flightName, String departure, String arrival) {
        return client.readFlightsFromShoppingCart(flightName, departure, arrival);
    }

    @Override
    public Seat readSeatFromShoppingCart(String seatNumber, String classType) {
        return client.readSeatFromShoppingCart(seatNumber,classType);
    }
    /*@Override
    public List<myFlightTicket> ReadPriceSUM() {
        return client.ReadPriceSUM();
    }*/

    @Override
    public void createTicket(myFlightTicket myFlightTicket) {
        client.createTicket(myFlightTicket);

    }

    @Override
    public Flights readPrice(String price) {
        return client.readPrice(price);
    }

    @Override
    public myFlightTicket readUsername_(String user) {
        return client.readUsername_(user);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    public Object cloak(){
        Date myDate=new Date();
        support.firePropertyChange("time",-1,1);

        return myDate;
    }






}


