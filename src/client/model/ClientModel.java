package client.model;

import shared.transferobjects.*;
import shared.util.Subject;

import java.rmi.RemoteException;
import java.util.List;

public interface ClientModel extends Subject {

    //chat
    List<InputChat> getChat();
    InputChat createChat(String chat, double star);
    int CountChat();

    //user
    List<InputUser> getUser();
    InputUser username(String user, String password);
    InputUser readUser(String user,String password);
    InputUser readUsername(String user);
    boolean ValidateUser(String user, String password);

    //ratings
    List<Rating> getRatings();
    int CountRatings(double star);

    //average
    double AverageStars();

    //flight
    List<Flights> getflights();
    List<Flights> readByName(String searchString);
    List<Flights> getAllTheFLights();
    Flights CreateFlights(String flightID, String flightName, String price);

    //admin
    List<Seat> getSeats();
    List<Airport> getAirport();
    List<PlaneType> getAllPlaneType();
    List<Depature> getAllDeparture();
    List<Arrival> getAllArrival();
    Airport CreateAirport(String airportId, String airportName, String airportCity);
    Arrival CreateArrival(String Arrival, String Arrivaldate);
    Depature CreateDeparture(String Departure, String DepartureDate);
    PlaneType CreatePlane(String PlaneTypes);

    //seat
    List<Seat> getSeat(int planeId);
    Seat getSeatId(int seatID, String seatNumber, String classType);
    Seat CreateSeat(String SeatNumber,String classtype);

    //passenger
    Passenger Createpassernger(String FirstName, String LastName, String TelNumber, String email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);

    //payment
    Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate);

    //shoppingCart
    Flights readFlightsFromShoppingCart(String flightName, String departure, String arrival);
    Seat readSeatFromShoppingCart(String seatNumber,String classType);

    //ticket
    List<myFlightTicket> getflightlist(int userId);
    void createTicket(myFlightTicket myFlightTicket);
    Flights readPrice(String price);

    //Clock
    Object clock();
}


