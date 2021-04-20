package server.model;

import shared.transferobjects.*;
import shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {

    InputChat sendMsg(String str);
    List<InputChat> getChat();

    InputUser username(String txt);
    List<InputUser> getUser();

    List<seat> getSeat();
    List<flights> getflights();
    passenger passernger(String FirstName, String LastName, String TelNumber);

    List<myFlightTicket> getflightlist();
    void createTicket(myFlightTicket myFlightTicket);


}


