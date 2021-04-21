package server.model;

import server.model.database.*;
import shared.transferobjects.*;
import shared.util.utils;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TextManagerImpl implements TextManager{

    private PropertyChangeSupport support;
    private List<InputChat> chatListe;
    private List<InputUser> userNameList;
    private List<flights> flightList;
    private List<myFlightTicket> myflight;
    private List<Passenger> passengersList;

    private daoInterface dao;



    public TextManagerImpl() {
        support = new PropertyChangeSupport(this);
        chatListe = new ArrayList<>();
        userNameList = new ArrayList<>();
        flightList = new ArrayList<>();
        myflight = new ArrayList<>();
        passengersList = new ArrayList<>();
        dao = daoImpl.getInstance();

    }

    @Override
    public InputUser username(String txt) {
        InputUser inputUser = new InputUser(txt);
        userNameList.add(dao.createUser(txt));
        support.firePropertyChange(utils.NEWUSER, null, inputUser);
        System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
        return inputUser;
    }

    @Override
    public InputChat sendMsg(String str) {
        InputChat inputChat = new InputChat(str);
        // dao.createChar(str);
        chatListe.add(dao.createChar(str));//Denne skal laves om til at den gemmer i databasen
        support.firePropertyChange(utils.NEWCHAT, null, inputChat);
        System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
        return inputChat;
    }

    @Override
    public List<InputUser> getUser() {
        // return dao.readUser();
        return new ArrayList<>(dao.readUser());
    }

    @Override
    public List<seat> getSeat() {
        return new ArrayList<>(dao.getSeat());
    }

    /*@Override
    public List<passenger> getPassenger() {
        return new ArrayList<>(dao.getPassenger());
    }*/

    @Override
    public List<InputChat> getChat() {
       //return dao.readChat();
       return new ArrayList<>(dao.readChat());
    }

    @Override
    public List<flights> getflights() {
        return new ArrayList<>(dao.getflights());
    }

    @Override public Passenger passernger(String FirstName, String LastName,
                                          String TelNumber, String email)
    {
        Passenger passenger;
        passenger = dao.CreatePassengers(FirstName, LastName, TelNumber,email);
        passengersList.add(passenger);
       support.firePropertyChange(utils.NEWPASSENGER, null, passenger);
        System.out.println("Passenger id er : " +passenger);
        return passenger;
    }

    @Override
    public Passenger getpassenger(int passengerID) {
        return dao.Readpassenger(passengerID);
    }

    @Override
    public void createTicket(myFlightTicket myFlightTicket) {
        dao.createTicket(myFlightTicket);
       // System.out.println("TextManagerImpl = " +  dao.getfinish());

       // Myflightlist myt = new Myflightlist(myflightlist.getTicketID(),myflightlist.getPrice(),new passenger(myflightlist.getPassengerID(),myflightlist.getName()),new flights(myflightlist.getFlightName(),myflightlist.getFlightName(),myflightlist.getDeparture(),myflightlist.getArrival(),myflightlist.getFrom(),myflightlist.getTo()),new seat(myflightlist.getSeatID(),myflightlist.getSeatNumber(),myflightlist.getClassType()));

        //dao.getfinish(myflightlist);

       // support.firePropertyChange(, null, myt);
    }

    @Override
    public List<myFlightTicket> getflightlist() {
        return new ArrayList<>(dao.ReadFlightList());
    }


    //---------------------------------------------------------------
/*    @Override
    public void getUpdate(flights flights) {
        dao.getUpdate(flights);
    }
    */
    /* @Override
    public UpdateSeats() {
        return dao.getUpdate();
    }
*/
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
