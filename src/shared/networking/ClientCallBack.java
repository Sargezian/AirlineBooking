package shared.networking;

import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.transferobjects.flights;
import shared.transferobjects.passenger;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote {

    void updateChat(InputChat entry) throws RemoteException;
    void updateUser(InputUser entry2) throws RemoteException;
    void updatePassenger(passenger passenger) throws RemoteException;


    //void updateFlights(flights entry3) throws RemoteException;




}
