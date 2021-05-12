package client.network;

import shared.transferobjects.*;
import shared.util.Subject;

import java.rmi.RemoteException;
import java.util.List;

public interface Client extends Subject {

    //chat
    InputChat createChat(String chat, double star);
    List<InputChat> getChat();
    int CountChat();

    //user
    InputUser username(String user, String password);
    List<InputUser> getUser();
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
    Flights CreateFlights(String flightID, String flightName, String price);
    List<Flights> readByName(String searchString);


    //admin
    void deleteFlight(Flights flights);
    List<Flights> getAllTheFLights();
    Arrival CreateArrival(String Arrival, String Arrivaldate);
    Depature CreateDeparture(String Departure, String DepartureDate);
    PlaneType CreatePlane(String PlaneTypes);
    List<PlaneType> getAllPlaneType();
    List<Depature> getAllDeparture();
    List<Arrival> getAllArrival();;
    void deleteArrival(Arrival arrival);
    void deleteDeparture(Depature depature);
    void deletePlaneType(PlaneType planeType);

    //seats
    List<Seat> getSeat(int planeId);
    Seat getSeatId(int seatID, String seatNumber, String classType);

    //passenger
    Passenger passernger(String FirstName, String LastName, String TelNumber, String email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);
    Passenger readByEmail(String email);

    //payment
    Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate);

    //ticket
    //List<myFlightTicket> ReadPriceSUM();
    List<myFlightTicket> getflightlist(int userId);
    void createTicket(myFlightTicket myFlightTicket);
    myFlightTicket readUsername_(String user);

    //ShoppingCart
    Flights readFlightsFromShoppingCart(String flightName, String departure, String arrival);
    Seat readSeatFromShoppingCart(String seatNumber,String classType);
    Flights readPrice(String price);

    void startClient();
}
