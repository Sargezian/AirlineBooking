package server.model;

import shared.transferobjects.*;
import shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {

    //chat
    InputChat createChat(String chat, double star);
    List<InputChat> getChat();
    int CountChat();

    //rating
    List<Rating> getRatings();
    double AverageStars();
    int CountRatings(double star);

    //user
    InputUser CreateUser(String user, String password);
    List<InputUser> getUser();
    InputUser readUser(String user,String password);
    InputUser readUsername(String user);
    boolean ValidateUser(String user, String password);

    //seat
    List<Seat> getSeat(int planeId);
    Seat getSeatID(int seatID, String seatNumber, String classType);

    //flight
    List<Flights> getflights();
    List<Flights> readByName(String searchString);
    Flights CreateFlights(String flightID, String flightName, String price );
    void deleteFlight(Flights flights);
    List<Flights> getAllTheFLights();
    Arrival CreateArrival(String Arrival, String Arrivaldate);

    Depature CreateDeparture(String Departure, String DepartureDate);

    PlaneType CreatePlane(String PlaneTypes);

    List<PlaneType> getAllPlaneType();
    List<Depature> getAllDeparture();
    List<Arrival> getAllArrival();

    //passenger
    Passenger passernger(String FirstName, String LastName, String TelNumber, String email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);
    Passenger readByEmail(String email);

    //ticket
    /*List<myFlightTicket> ReadPriceSUM();*/
    List<myFlightTicket> getflightlist(int userId);
    myFlightTicket readUsername_(String user);

    //payment
    Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate);
    void createTicket(myFlightTicket myFlightTicket);

    //shoppingCart
    Flights readFlightsFromShoppingCart(String flightName, String departure, String arrival);
    Seat readSeatFromShoppingCart(String seatNumber,String classType);
    Flights readPrice(String price);


}


