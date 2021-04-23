package client.model;

import client.network.Client;
import shared.transferobjects.*;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Date;
import java.util.List;

public class ClientTextManager implements ClientText {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;

    public ClientTextManager(Client client) {
        System.out.println("client textmanager");
        this.client = client;
        client.startClient();
        client.addListener(utils.NEWCHAT, this::onNewInputChat);
        client.addListener(utils.NEWUSER, this::onNewInputUser);
        client.addListener(utils.NEWTICKET, this::onNewTicket);

    }

    private void onNewTicket(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange(propertyChangeEvent);
    }

    private void onNewInputChat(PropertyChangeEvent evt) {
        support.firePropertyChange(evt);
    }

    private void onNewInputUser(PropertyChangeEvent evt) {
        support.firePropertyChange(evt);
    }

    @Override
    public InputChat sendMsg(String text) {
        return client.sendMsg(text);
    }

    @Override
    public List<InputChat> getChat() {
        return client.getChat();
    }

    @Override
    public InputUser username(String user, String password) {
        return client.username(user, password);
    }

    @Override
    public List<InputUser> getUser() {
       return client.getUser();
    }

    @Override
    public List<flights> getflights() {
        return client.getflights();
    }

    @Override
    public List<Seat> getSeat() {
            return client.getSeat();
    }

   /* @Override
    public Seat seat(String seatNumber, String classType) {
        return client.seat(seatNumber,classType);
    }*/

    @Override
    public List<myFlightTicket> getflightlist() {
        return client.getflightlist();
    }

    @Override public Passenger Createpassernger(String FirstName, String LastName,
                                                String TelNumber, String email)
    {
        return client.passernger(FirstName, LastName, TelNumber,email);
    }

    @Override
    public Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate) {
        return client.payment(cardholderName,cardNumber,CVV,expirationDate);
    }
    /*@Override
    public List<myFlightTicket> ReadPriceSUM() {
        return client.ReadPriceSUM();
    }*/


    @Override
    public void createTicket(myFlightTicket myFlightTicket) {
        client.createTicket(myFlightTicket);

    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}


