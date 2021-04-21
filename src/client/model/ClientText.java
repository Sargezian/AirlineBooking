package client.model;

import shared.transferobjects.*;
import shared.util.Subject;

import java.util.List;

public interface ClientText extends Subject {

    InputChat sendMsg(String text);
    List<InputChat> getChat();

    InputUser username(String txt);
    List<InputUser> getUser();

    List<flights> getflights();
    List<seat> getSeat();
    passenger passernger(String FirstName, String LastName, String TelNumber,String email);


    List<myFlightTicket> getflightlist();
    void createTicket(myFlightTicket myFlightTicket);









}


