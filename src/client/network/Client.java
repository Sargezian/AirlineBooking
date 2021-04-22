package client.network;

import shared.transferobjects.*;
import shared.util.Subject;

import java.util.List;

public interface Client extends Subject {

    InputChat sendMsg(String str);
    List<InputChat> getChat();

    InputUser username(String txt);
    List<InputUser> getUser();

    List<flights> getflights();
    List<seat> getSeat();
    Passenger passernger(String FirstName, String LastName, String TelNumber, String email);


    List<myFlightTicket> getflightlist();
    void createTicket(myFlightTicket myFlightTicket);

    void startClient();

}
