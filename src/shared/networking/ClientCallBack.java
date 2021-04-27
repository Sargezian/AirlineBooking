package shared.networking;

import shared.transferobjects.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote {

    void updateChat(InputChat entry) throws RemoteException;
    void updateUser(InputUser entry2) throws RemoteException;
    void updateTicket(myFlightTicket myflightticket) throws RemoteException;
    void updateFlight(flights flights) throws  RemoteException;


}
