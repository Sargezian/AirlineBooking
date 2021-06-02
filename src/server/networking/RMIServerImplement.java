package server.networking;

import server.model.ServerManager;
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

    private final ServerManager serverManager;

    public RMIServerImplement(ServerManager serverManager) throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.serverManager = serverManager;
    }

    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(utils.PORT_NR);
        registry.bind(utils.SERVER,this);
    }

    @Override public Airport CreateAirport(String airportId, String airportName,
        String airportCity)
    {
        return serverManager.CreateAirport(airportId,airportName,airportCity);
    }

    @Override
    public InputChat createChat(String chat, double star) {
        System.out.println("RMI SERVER READ CHAT");
        return serverManager.createChat(chat, star);
    }


    @Override
    public List<InputChat> getChat()  {
        return serverManager.getChat();
    }

    @Override
    public int CountChat() throws RemoteException {
        return serverManager.CountChat();
    }

    @Override
    public List<Rating> getRatings() throws RemoteException {
        return serverManager.getRatings();
    }

    @Override
    public double AverageStars() throws RemoteException {
        return serverManager.AverageStars();
    }

    @Override
    public int CountRatings(double star) throws RemoteException {
        return serverManager.CountRatings(star);
    }

    @Override
    public InputUser username(String user, String password)  {
        return serverManager.CreateUser(user, password);
    }

    @Override
    public List<myFlightTicket> getflightlist(int userId) throws RemoteException {
        return serverManager.getflightlist(userId);
    }

    @Override
    public Flights readFlightsFromShoppingCart(String flightName, String departure, String arrival) throws RemoteException {
        return serverManager.readFlightsFromShoppingCart(flightName, departure, arrival);
    }

    @Override
    public Seat readSeatFromShoppingCart(String seatNumber, String classType) throws RemoteException {
        return serverManager.readSeatFromShoppingCart(seatNumber,classType);
    }

    @Override
    public Flights readPrice(String price) throws RemoteException {
        return serverManager.readPrice(price);
    }

    @Override
    public InputUser readUser(String user, String password) throws RemoteException {
        return serverManager.readUser(user,password);
    }

    @Override
    public InputUser readUsername(String user) throws RemoteException {
        return serverManager.readUsername(user);
    }

    @Override public Passenger passernger(String FirstName, String LastName,
                                          String TelNumber, String email)
    {
        return serverManager.passernger(FirstName, LastName, TelNumber,email);
    }

    @Override
    public Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email) throws RemoteException {
        return serverManager.ReadPassenger(Firstname,LastName,TelNumber,Email);
    }

    @Override
    public Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate) {
        return serverManager.payment(cardholderName, cardNumber, CVV, expirationDate);
    }

    @Override
    public List<InputUser> getUser()  {
        System.out.println("RMISERVER read user");
        return serverManager.getUser();
    }

    @Override
    public void registerChatToClient(ClientCallBack client) {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
                listener = evt -> {
            try {
                client.updateChat((InputChat) evt.getNewValue());
            } catch (RemoteException e) {

                serverManager.removeListener(utils.NEWCHAT, finalListener);
            }
        };
            serverManager.addListener(utils.NEWCHAT, listener);
        }

    @Override
    public void registerUserToClient(ClientCallBack client) {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                client.updateUser((InputUser) evt.getNewValue());
            } catch (RemoteException e) {

                serverManager.removeListener(utils.NEWUSER, finalListener);
            }
        };
        serverManager.addListener(utils.NEWUSER, listener);
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

                serverManager.removeListener(utils.NEWTICKET, finalListener);
            }
        };
        serverManager.addListener(utils.NEWTICKET, listener);

    }

    @Override
    public void registerFlightToClient(ClientCallBack client) throws RemoteException {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                System.out.println("register Flight to client ");
                client.updateFlight((Flights) evt.getNewValue());
            } catch (RemoteException e) {

                serverManager.removeListener(utils.NEWFLIGHT, finalListener);
            }
        };
        serverManager.addListener(utils.NEWFLIGHT, listener);

    }

    @Override
    public void registerArrivalToClient(ClientCallBack client) throws RemoteException {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                System.out.println("register Arrival to client ");
                client.updateArrival((Arrival) evt.getNewValue());
            } catch (RemoteException e) {

                serverManager.removeListener(utils.NEWARRIVAL, finalListener);
            }
        };
        serverManager.addListener(utils.NEWARRIVAL, listener);
    }

    @Override
    public void registerDepartureToClient(ClientCallBack client) throws RemoteException {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                System.out.println("register Departure to client ");
                client.updateDeparture((Depature) evt.getNewValue());
            } catch (RemoteException e) {

                serverManager.removeListener(utils.NEWDEPARTURE, finalListener);
            }
        };
        serverManager.addListener(utils.NEWDEPARTURE, listener);
    }

    @Override
    public void registerPlaneToClient(ClientCallBack client) throws RemoteException {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                System.out.println("register Plane to client ");
                client.updatePlane((PlaneType) evt.getNewValue());
            } catch (RemoteException e) {

                serverManager.removeListener(utils.NEWPLANE, finalListener);
            }
        };
        serverManager.addListener(utils.NEWPLANE, listener);
    }

    @Override
    public void registerSeatToClient(ClientCallBack client) throws RemoteException {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                System.out.println("register Seat to client ");
                client.updateSeat((Seat) evt.getNewValue());
            } catch (RemoteException e) {

                serverManager.removeListener(utils.NEWSEAT, finalListener);
            }
        };
        serverManager.addListener(utils.NEWSEAT, listener);


    }

    @Override
    public void registerAirportToClient(ClientCallBack client) throws RemoteException {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                System.out.println("register Airport to client ");
                client.updateAirport((Airport) evt.getNewValue());
            } catch (RemoteException e) {

                serverManager.removeListener(utils.NEWAIRPORT, finalListener);
            }
        };
        serverManager.addListener(utils.NEWAIRPORT, listener);

    }


    @Override
    public void createTicket(myFlightTicket myFlightTicket) throws RemoteException {
        serverManager.createTicket(myFlightTicket);
    }

    @Override
    public List<Flights> getflights() {
        return serverManager.getflights();
    }

    @Override
    public List<Flights> readByName(String searchString) throws RemoteException {
        return serverManager.readByName(searchString);
    }

    @Override
    public Flights CreateFlights(String flightID, String flightName, String price) throws RemoteException {
        return serverManager.CreateFlights(flightID,flightName,price);
    }

    @Override
    public List<Flights> getAllTheFLights() throws RemoteException {
        return serverManager.getAllTheFLights();
    }

    @Override
    public Arrival CreateArrival(String Arrival, String Arrivaldate) throws RemoteException {
        return serverManager.CreateArrival(Arrival,Arrivaldate);
    }

    @Override
    public Depature CreateDeparture(String Departure, String DepartureDate) throws RemoteException {
        return serverManager.CreateDeparture(Departure,DepartureDate);
    }

    @Override
    public PlaneType CreatePlane(String PlaneTypes) throws RemoteException {
        return serverManager.CreatePlane(PlaneTypes);
    }

    @Override
    public List<PlaneType> getAllPlaneType() throws RemoteException {
        return serverManager.getAllPlaneType();
    }

    @Override
    public List<Depature> getAllDeparture() throws RemoteException{
        return serverManager.getAllDeparture();
    }

    @Override
    public List<Arrival> getAllArrival()throws RemoteException {
        return serverManager.getAllArrival();
    }

    @Override
    public List<Seat> getSeats() throws RemoteException {
        return serverManager.getSeats();
    }

    @Override
    public List<Airport> getAirport() throws RemoteException {
        return serverManager.getAirport();
    }

    @Override
    public List<Seat> getSeat(int planeId) throws RemoteException {
        return serverManager.getSeat(planeId);
    }

    @Override
    public boolean ValidateUser(String user, String password) throws RemoteException {
        return serverManager.ValidateUser(user,password);
    }

    @Override public Seat getSeatId(int seatID, String seatNumber,
                                    String classType) throws RemoteException
    {
        return serverManager.getSeatID(seatID,seatNumber,classType);
    }

    @Override public Seat CreateSeat(String SeatNumber, String classtype)
    {
        return serverManager.CreateSeat(SeatNumber,classtype);
    }


    @Override
    public void deleteSeat(Seat seat) throws RemoteException {
        serverManager.deleteSeat(seat);
    }


}
