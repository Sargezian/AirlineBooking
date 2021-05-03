package server.model;

import shared.transferobjects.*;
import shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {

    InputChat sendMsg(String str);
    List<InputChat> getChat();
    int CountChat();

    InputUser CreateUser(String user, String password);
    List<InputUser> getUser();

    List<Seat> getSeat();
    Seat getSeatID(int seatID, String seatNumber, String classType);
    boolean ValidateUser(String user, String password) ;

    List<flights> getflights();
    List<flights> readByName(String searchString);

    Passenger passernger(String FirstName, String LastName, String TelNumber, String email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);

    /*List<myFlightTicket> ReadPriceSUM();*/
    List<myFlightTicket> getflightlist(int userId);

    Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate);


    void createTicket(myFlightTicket myFlightTicket);


    flights readFlightsFromShoppingCart(String flightName, String departure, String arrival);
    Seat readSeatFromShoppingCart(String seatNumber,String classType);






    InputUser readUser(String user,String password);



}


