package client.network;

import shared.transferobjects.*;
import shared.util.Subject;

import java.sql.Date;
import java.util.List;

public interface Client extends Subject {

    InputChat sendMsg(String str);
    List<InputChat> getChat();

    InputUser username(String user, String password);
    List<InputUser> getUser();

    List<flights> getflights();
    List<flights> readByName(String searchString);

    List<Seat> getSeat();
    boolean ValidateUser(String user, String password) ;
    //Seat seat(String seatNumber, String classType);

    Passenger passernger(String FirstName, String LastName, String TelNumber, String email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);


    Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate);


    //List<myFlightTicket> ReadPriceSUM();
    List<myFlightTicket> getflightlist(int passengerID);
    void createTicket(myFlightTicket myFlightTicket);

    flights readFlightsFromShoppingCart(String flightName, String from, String to);
    Seat readSeatFromShoppingCart(String seatNumber,String classType);


    void startClient();

}
