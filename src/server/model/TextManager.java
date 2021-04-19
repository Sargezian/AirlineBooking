package server.model;

import shared.transferobjects.*;
import shared.util.Subject;

import java.rmi.RemoteException;
import java.util.List;

public interface TextManager extends Subject {

    InputChat sendMsg(String str);
    List<InputChat> getChat();
    InputUser username(String txt);
    List<InputUser> getUser();

    List<seat> getSeat();
    List<passenger> getPassenger();
    List<flights> getflights();



    //---------------------------------------------------------------
   /* void getUpdate(flights flights);
    void UpdateSeats();
*/
    //---------------------------------------------------------------

    void finish(Myflightlist myflightlist);

    List<Myflightlist> getflightlist();


}


