package shared.networking;

import shared.transferobjects.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote {

    InputChat sendMsg(String str) throws RemoteException;
    List<InputChat> getChat() throws RemoteException;
    int CountChat() throws RemoteException;

    InputUser username(String user, String password) throws RemoteException;
    List<InputUser> getUser() throws RemoteException;

    List<flights> getflights() throws RemoteException;
    List<flights> readByName(String searchString) throws RemoteException;

    List<Seat> getSeat() throws RemoteException;

    boolean ValidateUser(String user, String password) throws RemoteException ;
    //Seat seat(String seatNumber, String classType) throws RemoteException;
    Seat getSeatId(int seatID, String seatNumber, String classType) throws RemoteException;


    Passenger passernger(String FirstName, String LastName, String TelNumber, String email) throws RemoteException;
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email) throws RemoteException;


    Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate) throws RemoteException;



    //List<myFlightTicket> ReadPriceSUM() throws RemoteException;
    List<myFlightTicket> getflightlist(int userId) throws RemoteException;


    flights readFlightsFromShoppingCart(String flightName, String departure, String arrival) throws RemoteException;
    Seat readSeatFromShoppingCart(String seatNumber,String classType) throws RemoteException;


    InputUser readUser(String user,String password) throws RemoteException;



    void registerChatToClient(ClientCallBack client) throws RemoteException;
    void registerUserToClient(ClientCallBack client) throws RemoteException;
    void createTicket(myFlightTicket myFlightTicket) throws RemoteException;
    void registerTicketToClient(ClientCallBack client) throws  RemoteException;
    void registerFlightToClient(ClientCallBack client) throws  RemoteException;





}
