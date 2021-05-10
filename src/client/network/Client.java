package client.network;

import shared.transferobjects.*;
import shared.util.Subject;

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

    //rating
    List<Rating> getRatings();
    int CountRatings(double star);

    //average
    double AverageStars();

    //flights
    List<Flights> getflights();
    Flights CreateFlights(String flightName, int price);
    List<Flights> readByName(String searchString);

    //seats
    List<Seat> getSeat(int planeId);
    Seat getSeatId(int seatID, String seatNumber, String classType);
    Seat CreateSeat(int seatId, String SeatNumber,String classtype);
    boolean ValidateUser(String user, String password);

    //Airport
    Airport CreateAirport(int airportID,Depature depature);
    //arrival
    Arrival CreateArrival(int arrivalID, String arrival, String arrivalDate);
    //passenger
    Passenger passernger(String FirstName, String LastName, String TelNumber, String email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);
    Passenger readByEmail(String email);

    //Departure
    Depature CreateDeparture(int departureID, String departure, String departureDate);

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
    Flights readPrice(int price);

    void startClient();
}
