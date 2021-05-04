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
    private List<Seat> seatsList;
    private List<Payment> paymentList;

    private FlightDao dao;
    private InputChatDao inputChatDao;
    private InputUserDao inputUserDao;
    private MyFlightTicketDao myFlightTicketDao;
    private PassengerDao passengerDao;
    private SeatDao seatDao;
    private PaymentDao paymentDao;
    private ShoppingCartDao shoppingCartDao;

    public TextManagerImpl() {
        support = new PropertyChangeSupport(this);
        chatListe = new ArrayList<>();
        userNameList = new ArrayList<>();
        passengersList = new ArrayList<>();
        seatsList = new ArrayList<>();
        paymentList = new ArrayList<>();
        dao = FlightImpl.getInstance();
        inputChatDao = InputChatImpl.getInstance();
        inputUserDao = InputUserImpl.getInstance();
        myFlightTicketDao = MyFlightTicketImpl.getInstance();
        passengerDao = PassengerImpl.getInstance();
        seatDao = SeatImpl.getInstance();
        paymentDao = PaymentImpl.getInstance();
        shoppingCartDao = ShoppingCartImpl.getInstance();

    }

    @Override
    public InputUser CreateUser(String user, String password) {
        InputUser inputUser;
        inputUser = inputUserDao.createUser(user,password);
        userNameList.add(inputUser);
        support.firePropertyChange(utils.NEWUSER, null, inputUser);
        System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
        return inputUser;
    }



    @Override
    public InputChat createChat(String chat, double star) {
        InputChat inputChat = new InputChat(chat,new Rating(star));
        chatListe.add(inputChatDao.createChat(chat,star));
        support.firePropertyChange(utils.NEWCHAT, null, inputChat);
        System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
        return inputChat;
    }

    @Override
    public List<InputUser> getUser() {
        return new ArrayList<>(inputUserDao.readUser());
    }

    @Override
    public List<Seat> getSeat(int planeId) {
        System.out.println("Her getter vi et seat " + seatDao.getSeat(planeId));
        return new ArrayList<>(seatDao.getSeat(planeId));
    }

    @Override public Seat getSeatID(int seatID, String seatNumber,
                                    String classType)
    {
       return seatDao.getSeatId(seatID,seatNumber,classType);
    }

    @Override
    public boolean ValidateUser(String user, String password) {
        return inputUserDao.ValidateUser(user,password);
    }

    /*@Override
    public Seat seat(String seatNumber, String classType) {
        Seat seat;
        seat = seatDao.CreateSeat(seatNumber,classType);
        seatsList.add(seat);
        return seat;
    }*/

    @Override
    public List<InputChat> getChat() {
       return new ArrayList<>(inputChatDao.readChat());
    }

    @Override
    public int CountChat() {
        return inputChatDao.CountChat();
    }

    @Override
    public List<Rating> getRatings() {
        return new ArrayList<>(inputChatDao.getRatings());
    }

    @Override
    public double AverageStars() {
        return inputChatDao.AverageStars();
    }

    @Override
    public List<Flights> getflights() {

        return new ArrayList<>(dao.getflights());
    }

    @Override
    public List<Flights> readByName(String searchString) {
        return dao.readByName(searchString);
    }

    @Override public Passenger passernger(String FirstName, String LastName, String TelNumber, String email) {
        Passenger passenger;
        passenger = passengerDao.CreatePassengers(FirstName, LastName, TelNumber,email);
        passengersList.add(passenger);
        System.out.println("Passenger id er : " +passenger);
        return passenger;
    }

    @Override
    public Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email) {
        return passengerDao.ReadPassenger(Firstname,LastName,TelNumber,Email);
    }



   /* @Override
    public List<myFlightTicket> ReadPriceSUM() {
        return  new ArrayList<>(myFlightTicketDao.ReadPriceSUM());
    }*/

    @Override
    public void createTicket(myFlightTicket myFlightTicket) {
        myFlightTicketDao.createTicket(myFlightTicket);
        support.firePropertyChange(utils.NEWTICKET, null, myFlightTicket);

    }

    @Override
    public Flights readFlightsFromShoppingCart(String flightName, String departure, String arrival) {
        return shoppingCartDao.readFlightsFromShoppingCart(flightName, departure, arrival);
    }

    @Override
    public Seat readSeatFromShoppingCart(String seatNumber, String classType) {
        return shoppingCartDao.readSeatFromShoppingCart(seatNumber,classType);
    }

    @Override
    public Flights readPrice(int price) {
        return shoppingCartDao.readPrice(price);
    }

    @Override
    public InputUser readUser(String user, String password) {
        return inputUserDao.readUser(user,password);
    }

    @Override
    public InputUser readUsername(String user) {
        return inputUserDao.readUsername(user);
    }


    @Override
    public List<myFlightTicket> getflightlist(int userId) {
        return new ArrayList<>(myFlightTicketDao.ReadFlightList(userId));
    }

    @Override
    public myFlightTicket readUsername_(String user) {
        return myFlightTicketDao.readUsername_(user);
    }

    @Override
    public Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate) {
        Payment payment;
        payment = paymentDao.CreatePayment(cardholderName, cardNumber, CVV, expirationDate);
        paymentList.add(payment);
        return payment;

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
