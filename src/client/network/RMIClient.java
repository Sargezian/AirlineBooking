package client.network;

import shared.networking.ClientCallBack;
import shared.networking.RMIServer;
import shared.transferobjects.*;
import shared.util.utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements Client, ClientCallBack
{

  private RMIServer server;
  private PropertyChangeSupport support;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry(utils.PORT_NR);
      server = (RMIServer) registry.lookup(utils.SERVER);
      server.registerChatToClient(this);
      server.registerUserToClient(this);
      server.registerTicketToClient(this);
      server.registerFlightToClient(this);
      //server.registerpassengerToClient(this);

    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public InputChat createChat(String chat, int star)
  {
    try
    {
      return server.createChat(chat,star);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override public List<InputChat> getChat()
  {
    try
    {
      return server.getChat();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override
  public int CountChat() {
    try
    {
      return server.CountChat();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override public InputUser username(String user, String password)
  {
    try
    {
      return server.username(user, password);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override public List<InputUser> getUser()
  {
    try
    {
      return server.getUser();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override public List<flights> getflights()
  {
    try
    {
      return server.getflights();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override
  public List<flights> readByName(String searchString) {
    try
    {
      return server.readByName(searchString);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override public List<Seat> getSeat(int planeId)
  {
    try
    {
      return server.getSeat(planeId);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override
  public boolean ValidateUser(String user, String password) {
    try
    {
      return server.ValidateUser(user,password);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override
  public Seat getSeatId(int seatID, String seatNumber, String classType) {
    try
    {
      return server.getSeatId(seatID,seatNumber,classType);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }


  @Override public List<myFlightTicket> getflightlist(int userId)
  {
    try
    {
      return server.getflightlist(userId);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override public Passenger passernger(String FirstName, String LastName,
                                        String TelNumber, String email)
  {
    try
    {
      return server.passernger(FirstName, LastName, TelNumber,email);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override
  public Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email) {
    try
    {
      return server.passernger(Firstname, LastName, TelNumber,Email);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }


  @Override
  public Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate) {
    try
    {
      return server.payment(cardholderName,cardNumber,CVV,expirationDate);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  /*@Override
  public List<myFlightTicket> ReadPriceSUM() {
    try
    {
      return server.ReadPriceSUM();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }*/

  @Override public void createTicket(myFlightTicket myFlightTicket)
  {

    try
    {
      server.createTicket(myFlightTicket);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }

  }

  @Override
  public flights readFlightsFromShoppingCart(String flightName, String departure, String arrival) {
    try
    {
      return server.readFlightsFromShoppingCart(flightName, departure, arrival);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override
  public Seat readSeatFromShoppingCart(String seatNumber, String classType) {
    try
    {
      return server.readSeatFromShoppingCart(seatNumber,classType);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override
  public InputUser readUser(String user, String password) {
    try
    {
      return server.readUser(user,password);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override
  public List<Rating> getRatings() {
    try
    {
      return server.getRatings();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override
  public int AverageStars() {
    try
    {
      return server.AverageStars();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

  @Override public void updateChat(InputChat entry) throws RemoteException
  {
    support.firePropertyChange(utils.NEWCHAT, null, entry);

  }

  @Override public void updateUser(InputUser entry2) throws RemoteException
  {
    support.firePropertyChange(utils.NEWUSER, null, entry2);

  }


  @Override
  public void updateTicket(myFlightTicket myflightticket) throws RemoteException {
    support.firePropertyChange(utils.NEWTICKET, null, myflightticket);

  }

  @Override
  public void updateFlight(flights flights) throws RemoteException {
    support.firePropertyChange(utils.NEWFLIGHT,null, flights);

  }


  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
