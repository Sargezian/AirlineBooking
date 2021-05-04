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

    //user
    InputUser CreateUser(String user, String password);
    List<InputUser> getUser();
    InputUser readUser(String user,String password);
    InputUser readUsername(String user);

    //seat
    List<Seat> getSeat(int planeId);
    Seat getSeatID(int seatID, String seatNumber, String classType);
    boolean ValidateUser(String user, String password) ;

    //flight
    List<Flights> getflights();
    List<Flights> readByName(String searchString);

    //passenger
    Passenger passernger(String FirstName, String LastName, String TelNumber, String email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);

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
    Flights readPrice(int price);


}


