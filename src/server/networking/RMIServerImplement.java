package server.networking;

import server.model.TextManager;
import shared.networking.ClientCallBack;
import shared.networking.RMIServer;
import shared.transferobjects.*;
import shared.util.utils;

import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServerImplement implements RMIServer {

    private final TextManager textManager;

    public RMIServerImplement(TextManager textManager) throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.textManager = textManager;
    }

    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(utils.PORT_NR);
        registry.bind(utils.SERVER,this);
    }

    @Override
    public InputChat createChat(String chat, double star) {
        System.out.println("RMI SERVER READ CHAT");
        return textManager.createChat(chat, star);
    }


    @Override
    public List<InputChat> getChat()  {
        return textManager.getChat();
    }

    @Override
    public int CountChat() throws RemoteException {
        return textManager.CountChat();
    }

    @Override
    public List<Rating> getRatings() throws RemoteException {
        return textManager.getRatings();
    }

    @Override
    public double AverageStars() throws RemoteException {
        return textManager.AverageStars();
    }

    @Override
    public InputUser username(String user, String password)  {
        return textManager.CreateUser(user, password);
    }

    @Override
    public List<myFlightTicket> getflightlist(int userId) throws RemoteException {
        return textManager.getflightlist(userId);
    }

    @Override
    public myFlightTicket readUsername_(String user) throws RemoteException {
        return textManager.readUsername_(user);
    }

    @Override
    public Flights readFlightsFromShoppingCart(String flightName, String departure, String arrival) throws RemoteException {
        return textManager.readFlightsFromShoppingCart(flightName, departure, arrival);
    }

    @Override
    public Seat readSeatFromShoppingCart(String seatNumber, String classType) throws RemoteException {
        return textManager.readSeatFromShoppingCart(seatNumber,classType);
    }

    @Override
    public Flights readPrice(int price) throws RemoteException {
        return textManager.readPrice(price);
    }

    @Override
    public InputUser readUser(String user, String password) throws RemoteException {
        return textManager.readUser(user,password);
    }

    @Override
    public InputUser readUsername(String user) throws RemoteException {
        return textManager.readUsername(user);
    }

    @Override public Passenger passernger(String FirstName, String LastName,
                                          String TelNumber, String email)
    {
        return textManager.passernger(FirstName, LastName, TelNumber,email);
    }

    @Override
    public Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email) throws RemoteException {
        return textManager.ReadPassenger(Firstname,LastName,TelNumber,Email);
    }


    @Override
    public Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate) {
        return textManager.payment(cardholderName, cardNumber, CVV, expirationDate);
    }

    /*@Override
    public List<myFlightTicket> ReadPriceSUM() throws RemoteException  {
        return textManager.ReadPriceSUM();
    }*/


    @Override
    public List<InputUser> getUser()  {
        System.out.println("RMISERVER read user");
        return textManager.getUser();
    }

    @Override
    public void registerChatToClient(ClientCallBack client) {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
                listener = evt -> {
            try {
                client.updateChat((InputChat) evt.getNewValue());
            } catch (RemoteException e) {

                textManager.removeListener(utils.NEWCHAT, finalListener);
            }
        };
            textManager.addListener(utils.NEWCHAT, listener);
        }

    @Override
    public void registerUserToClient(ClientCallBack client) {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                client.updateUser((InputUser) evt.getNewValue());
            } catch (RemoteException e) {

                textManager.removeListener(utils.NEWUSER, finalListener);
            }
        };
        textManager.addListener(utils.NEWUSER, listener);
    }


    @Override
    public void registerTicketToClient(ClientCallBack client) throws RemoteException {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                System.out.println("register ticket to client ");
                client.updateTicket((myFlightTicket) evt.getNewValue());
            } catch (RemoteException e) {

                textManager.removeListener(utils.NEWTICKET, finalListener);
            }
        };
        textManager.addListener(utils.NEWTICKET, listener);

    }

    @Override
    public void registerFlightToClient(ClientCallBack client) throws RemoteException {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                System.out.println("register ticket to client ");
                client.updateFlight((Flights) evt.getNewValue());
            } catch (RemoteException e) {

                textManager.removeListener(utils.NEWFLIGHT, finalListener);
            }
        };
        textManager.addListener(utils.NEWFLIGHT, listener);

    }


    @Override
    public void createTicket(myFlightTicket myFlightTicket) throws RemoteException {
        textManager.createTicket(myFlightTicket);
    }

    @Override
    public List<Flights> getflights() {
        return textManager.getflights();
    }

    @Override
    public List<Flights> readByName(String searchString) throws RemoteException {
        return textManager.readByName(searchString);
    }

    @Override
    public List<Seat> getSeat(int planeId) throws RemoteException {
        return textManager.getSeat(planeId);
    }

    @Override
    public boolean ValidateUser(String user, String password) throws RemoteException {
        return textManager.ValidateUser(user,password);
    }

    @Override public Seat getSeatId(int seatID, String seatNumber,
                                    String classType) throws RemoteException
    {
        return textManager.getSeatID(seatID,seatNumber,classType);
    }

    @Override
    public void delete(int seatID) throws RemoteException {
        textManager.delete(seatID);
    }

   /* @Override
    public Seat seat(String seatNumber, String classType) throws RemoteException {
        return textManager.seat(seatNumber,classType);
    }
*/

}
