package client.network;

import shared.transferobjects.*;
import shared.util.Subject;

import java.rmi.RemoteException;
import java.util.List;

public interface Client extends Subject {

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

    //rating
    List<Rating> getRatings();
    int CountRatings(double star);

    //average
    double AverageStars();

    //flights
    List<Flights> getflights();
    List<Flights> readByName(String searchString);
    Flights CreateFlights(String flightID, String flightName, String price);

    //admin
    List<Flights> getAllTheFLights();
    List<Seat> getSeats();
    List<Airport> getAirport();
    List<PlaneType> getAllPlaneType();
    List<Depature> getAllDeparture();
    List<Arrival> getAllArrival();
    Airport CreateAirport(String airportId, String airportName,
                          String airportCity);
    Arrival CreateArrival(String Arrival, String Arrivaldate);
    Depature CreateDeparture(String Departure, String DepartureDate);
    PlaneType CreatePlane(String PlaneTypes);

    //seats
    List<Seat> getSeat(int planeId);
    Seat getSeatId(int seatID, String seatNumber, String classType);
    Seat CreateSeat(String SeatNumber,String classtype);
    void deleteSeat(Seat seat);

    //passenger
    Passenger passernger(String FirstName, String LastName, String TelNumber, String email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);

    //payment
    Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate);

    //ticket
    List<myFlightTicket> getflightlist(int userId);
    void createTicket(myFlightTicket myFlightTicket);

    //ShoppingCart
    Flights readFlightsFromShoppingCart(String flightName, String departure, String arrival);
    Seat readSeatFromShoppingCart(String seatNumber,String classType);
    Flights readPrice(String price);

    void startClient();
}
