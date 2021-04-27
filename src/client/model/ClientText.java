package client.model;

import shared.transferobjects.*;
import shared.util.Subject;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

public interface ClientText extends Subject {

    InputChat sendMsg(String text);
    List<InputChat> getChat();

    InputUser username(String user, String password);

    boolean ValidateUser(String user, String password) ;
    List<InputUser> getUser();

    List<flights> getflights();
    List<flights> readByName(String searchString);

    List<Seat> getSeat();
    Seat getSeatId(String seatID);



    //Seat seat(String seatNumber, String classType);

    Passenger Createpassernger(String FirstName, String LastName, String TelNumber, String email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);



    Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate);



    flights readFlightsFromShoppingCart(String flightName, String from, String to);
    Seat readSeatFromShoppingCart(String seatNumber,String classType);




    /* List<myFlightTicket> ReadPriceSUM();*/
    List<myFlightTicket> getflightlist(int passengerID);
    void createTicket(myFlightTicket myFlightTicket);









}


