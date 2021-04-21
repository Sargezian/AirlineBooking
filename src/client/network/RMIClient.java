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
      server.registerPassengerToClient(this);

    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public InputChat sendMsg(String str)
  {
    try
    {
      return server.sendMsg(str);
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

  @Override public InputUser username(String txt)
  {
    try
    {
      return server.username(txt);
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

  @Override public List<seat> getSeat()
  {
    try
    {
      return server.getSeat();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }
  }

   /* @Override
    public List<passenger> getPassenger() {
        try {
            return server.getPassenger();
        } catch (RemoteException e) {
            throw new RuntimeException("Kunne ikke få fat i server");
        }
    }*/

  @Override public List<myFlightTicket> getflightlist()
  {
    try
    {
      return server.getflightlist();
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
  public Passenger getpassenger(int passengerID) {
    try
    {
       return server.getpassenger(passengerID);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Kunne ikke få fat i server");
    }

  }

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

  //---------------------------------------------------------------
  /*  @Override
    public void getUpdate(flights flights) {
        server.getUpdate(flights);
    }
    */
     /* @Override
    public void UpdateSeats() {
        server.UpdateSeats();
    }*/
  //---------------------------------------------------------------

  @Override public void updateChat(InputChat entry) throws RemoteException
  {
    support.firePropertyChange(utils.NEWCHAT, null, entry);

  }

  @Override public void updateUser(InputUser entry2) throws RemoteException
  {
    support.firePropertyChange(utils.NEWUSER, null, entry2);

  }

  @Override
  public void updatePassenger(Passenger passenger) throws RemoteException {
    support.firePropertyChange(utils.NEWPASSENGER, null, passenger);
    System.out.println("update passenger");
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
