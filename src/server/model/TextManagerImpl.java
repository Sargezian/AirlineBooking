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
    private List<Passenger> passengersList;

    private FlightDao dao;
    private InputChatDao inputChatDao;
    private InputUserDao inputUserDao;
    private MyFlightTicketDao myFlightTicketDao;
    private PassengerDao passengerDao;
    private SeatDao seatDao;

    public TextManagerImpl() {
        support = new PropertyChangeSupport(this);
        chatListe = new ArrayList<>();
        userNameList = new ArrayList<>();
        passengersList = new ArrayList<>();
        dao = FlightImpl.getInstance();
        inputChatDao = InputChatImpl.getInstance();
        inputUserDao = InputUserImpl.getInstance();
        myFlightTicketDao = MyFlightTicketImpl.getInstance();
        passengerDao = PassengerImpl.getInstance();
        seatDao = SeatImpl.getInstance();

    }

    @Override
    public InputUser username(String txt) {
        InputUser inputUser = new InputUser(txt);
        userNameList.add(inputUserDao.createUser(txt));
        support.firePropertyChange(utils.NEWUSER, null, inputUser);
        System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
        return inputUser;
    }

    @Override
    public InputChat sendMsg(String str) {
        InputChat inputChat = new InputChat(str);
        chatListe.add(inputChatDao.createChar(str));
        support.firePropertyChange(utils.NEWCHAT, null, inputChat);
        System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
        return inputChat;
    }

    @Override
    public List<InputUser> getUser() {
        return new ArrayList<>(inputUserDao.readUser());
    }

    @Override
    public List<seat> getSeat() {
        return new ArrayList<>(seatDao.getSeat());
    }

    @Override
    public List<InputChat> getChat() {
       return new ArrayList<>(inputChatDao.readChat());
    }

    @Override
    public List<flights> getflights() {
        return new ArrayList<>(dao.getflights());
    }

    @Override public Passenger passernger(String FirstName, String LastName,
                                          String TelNumber, String email)
    {
        Passenger passenger;
        passenger = passengerDao.CreatePassengers(FirstName, LastName, TelNumber,email);
        passengersList.add(passenger);
        System.out.println("Passenger id er : " +passenger);
        return passenger;
    }


    @Override
    public void createTicket(myFlightTicket myFlightTicket) {
        myFlightTicketDao.createTicket(myFlightTicket);
        support.firePropertyChange(utils.NEWTICKET, null, myFlightTicket);

    }

    @Override
    public List<myFlightTicket> getflightlist() {
        return new ArrayList<>(myFlightTicketDao.ReadFlightList());
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
