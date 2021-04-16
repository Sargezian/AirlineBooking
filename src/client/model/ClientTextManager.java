package client.model;

import client.network.Client;
import shared.transferobjects.*;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ClientTextManager implements ClientText {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;

    public ClientTextManager(Client client) {
        this.client = client;
        client.startClient();
        client.addListener(utils.NEWCHAT, this::onNewInputChat);
        client.addListener(utils.NEWUSER, this::onNewInputUser);
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
    public InputUser username(String txt) {
        return client.username(txt);
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
    public List<seat> getSeat() {
            return client.getSeat();
    }

    @Override
    public List<passenger> getPassenger() {
        return client.getPassenger();
    }

    @Override
    public List<Myflightlist> getflightlist() {
        return client.getflightlist();
    }

    @Override
    public void finish() {
        flights flights = SaveInfo.getInstance().getFlights();
        System.out.println("Gets SavedInfo from flights = " + SaveInfo.getInstance().getFlights());

        seat seat = SaveInfo.getInstance().getSeat();
        System.out.println("Gets SavedInfor from seats = " + SaveInfo.getInstance().getSeat());

        passenger passenger = SaveInfo.getInstance().getPassenger();
        System.out.println("Gets SavedInfo from passenger = " + SaveInfo.getInstance().getPassenger());

    }

    //---------------------------------------------------------------
    /*@Override
    public void getUpdate(flights flights) {
         client.getUpdate(flights);
    }

    @Override
    public void UpdateSeats() {
        client.UpdateSeats();
    }*/
    //---------------------------------------------------------------

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}


