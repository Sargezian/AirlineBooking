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

    Passenger passernger(String FirstName, String LastName, String TelNumber, String email) throws RemoteException;
    Passenger getpassenger(int passengerID) throws RemoteException;

    List<myFlightTicket> getflightlist() throws RemoteException;

    void registerChatToClient(ClientCallBack client) throws RemoteException;
    void registerUserToClient(ClientCallBack client) throws RemoteException;
    void createTicket(myFlightTicket myFlightTicket) throws RemoteException;
    void registerPassengerToClient(ClientCallBack client) throws  RemoteException;



}
