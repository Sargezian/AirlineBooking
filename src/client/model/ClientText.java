package client.model;

import shared.transferobjects.*;
import shared.util.Subject;

import java.sql.Date;
import java.util.List;

public interface ClientText extends Subject {

    InputChat sendMsg(String text);
    List<InputChat> getChat();

    InputUser username(String user, String password);
    List<InputUser> getUser();

    List<flights> getflights();

    List<Seat> getSeat();

    //Seat seat(String seatNumber, String classType);

    Passenger Createpassernger(String FirstName, String LastName, String TelNumber, String email);
    Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate);



    /* List<myFlightTicket> ReadPriceSUM();*/
    List<myFlightTicket> getflightlist();
    void createTicket(myFlightTicket myFlightTicket);









}


