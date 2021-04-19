package shared.networking;

import shared.transferobjects.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote {

    InputChat sendMsg(String str) throws RemoteException;
    List<InputChat> getChat() throws RemoteException;
    InputUser username(String txt) throws RemoteException;
    List<InputUser> getUser() throws RemoteException;
    List<flights> getflights() throws RemoteException;
    List<seat> getSeat() throws RemoteException;
   // List<passenger> getPassenger() throws RemoteException;
    List<Myflightlist> getflightlist() throws RemoteException;
    passenger passernger(String FirstName, String LastName, String TelNumber) throws RemoteException;


    void registerChatToClient(ClientCallBack client) throws RemoteException;
    void registerUserToClient(ClientCallBack client) throws RemoteException;

    void createTicket(Myflightlist myflightlist) throws RemoteException;


/*    void getUpdate(flights flights);
    void UpdateSeats();*/
}
