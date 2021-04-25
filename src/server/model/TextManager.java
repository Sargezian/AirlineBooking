package server.model;

import shared.transferobjects.*;
import shared.util.Subject;

import java.sql.Date;
import java.util.List;

public interface TextManager extends Subject {

    InputChat sendMsg(String str);
    List<InputChat> getChat();

    InputUser CreateUser(String user, String password);
    List<InputUser> getUser();

    List<Seat> getSeat();
    //Seat seat(String seatNumber, String classType);
    boolean ValidateUser(String user, String password) ;

    List<flights> getflights();

    Passenger passernger(String FirstName, String LastName, String TelNumber, String email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);


    /*List<myFlightTicket> ReadPriceSUM();*/
    List<myFlightTicket> getflightlist();


    Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate);


    void createTicket(myFlightTicket myFlightTicket);


}


