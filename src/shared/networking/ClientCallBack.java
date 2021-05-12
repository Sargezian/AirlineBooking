package shared.networking;

import shared.transferobjects.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote {

    //updates
    void updateChat(InputChat entry) throws RemoteException;
    void updateUser(InputUser entry2) throws RemoteException;
    void updateTicket(myFlightTicket myflightticket) throws RemoteException;
    void updateFlight(Flights flights) throws  RemoteException;
    void updateArrival(Arrival arrival) throws  RemoteException;
    void updateDeparture(Depature depature) throws  RemoteException;
    void updatePlane(PlaneType planeType) throws  RemoteException;
    void updateSeat(Seat Seat) throws  RemoteException;
    void updateAirport(Airport airport) throws  RemoteException;


}
