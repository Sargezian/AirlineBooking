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
    public InputChat sendMsg(String str) {
        System.out.println("RMI SERVER READ CHAT");
        return textManager.sendMsg(str);
    }


    @Override
    public List<InputChat> getChat()  {
        return textManager.getChat();
    }

    @Override
    public InputUser username(String txt)  {
        return textManager.username(txt);
    }

    @Override
    public List<myFlightTicket> getflightlist() throws RemoteException {
        return textManager.getflightlist();
    }

    @Override public Passenger passernger(String FirstName, String LastName,
                                          String TelNumber, String email)
    {
        return textManager.passernger(FirstName, LastName, TelNumber,email);
    }

    @Override
    public Passenger getpassenger(int passengerID) throws RemoteException {
        return textManager.getpassenger(passengerID);
    }

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
    public void registerPassengerToClient(ClientCallBack client)  {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                System.out.println("register passenger to client ");
                client.updatePassenger((Passenger) evt.getNewValue());
            } catch (RemoteException e) {

                textManager.removeListener(utils.NEWPASSENGER, finalListener);
            }
        };
        textManager.addListener(utils.NEWPASSENGER, listener);

    }


    @Override
    public void createTicket(myFlightTicket myFlightTicket) throws RemoteException {
        textManager.createTicket(myFlightTicket);
    }

   /* @Override
    public void UpdateSeats() {
        textManager.UpdateSeats();
    }*/



    @Override
    public List<flights> getflights() {
        return textManager.getflights();
    }

    @Override
    public List<seat> getSeat() throws RemoteException {
        return textManager.getSeat();
    }

/*
    @Override
    public List<passenger> getPassenger() throws RemoteException {
        return textManager.getPassenger();
    }
*/


}
