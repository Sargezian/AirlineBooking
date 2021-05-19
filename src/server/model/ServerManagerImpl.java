package server.model;

import server.model.database.*;
import shared.transferobjects.*;
import shared.util.utils;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ServerManagerImpl implements ServerManager {

    private PropertyChangeSupport support;
    private List<InputChat> chatListe;
    private List<InputUser> userNameList;
    private List<Passenger> passengersList;
    private List<Seat> seatsList;
    private List<Payment> paymentList;
    private List<Flights> flightsList;
    private List<Arrival> arrivalList;
    private List<Depature> departureList;
    private List<PlaneType> planeTypeList;
    private List<Airport> airportList;

    private FlightDao dao;
    private InputChatDao inputChatDao;
    private InputUserDao inputUserDao;
    private MyFlightTicketDao myFlightTicketDao;
    private PassengerDao passengerDao;
    private SeatDao seatDao;
    private PaymentDao paymentDao;
    private ShoppingCartDao shoppingCartDao;
    private adminDao adminDao;
    private AirportDao airportDao;

    public ServerManagerImpl() {
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
        adminDao = adminImpl.getInstance();
        airportDao =  AirportImpl.getInstance();
        flightsList = new ArrayList<>();
        arrivalList = new ArrayList<>();
        departureList = new ArrayList<>();
        planeTypeList = new ArrayList<>();
        airportList = new ArrayList<>();

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
    public Seat CreateSeat(String SeatNumber, String classtype) {
        Seat seat;
        seat = seatDao.CreateSeat(SeatNumber,classtype);
        seatsList.add(seat);
        support.firePropertyChange(utils.NEWSEAT, null, seat);
        System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
        return seat;
    }

    @Override
    public Seat countSeat()
    {
        List<Seat> counter = seatDao.countSeats();
        System.out.println(counter);
        return (Seat) counter;
    }


    @Override
    public void deleteSeat(Seat seat) {
        seatDao.deleteSeat(seat);
    }

    @Override
    public boolean ValidateUser(String user, String password) {
        return inputUserDao.ValidateUser(user,password);
    }


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
    public int CountRatings(double star) {
        return inputChatDao.CountRatings(star);
    }

    @Override
    public List<Flights> getflights() {
        return new ArrayList<>(dao.getflights());
    }

    @Override
    public List<Flights> readByName(String searchString) {
        return dao.readByName(searchString);
    }

    @Override
    public Flights CreateFlights(String flightID, String flightName, String price) {
        Flights flights;
        flights = adminDao.CreateFlights(flightID,flightName,price);
        flightsList.add(flights);
       support.firePropertyChange(utils.NEWFLIGHT,null,flights);
        return flights;
    }


    @Override
    public void deleteFlight(Flights flights) {
        adminDao.deleteFlight(flights);
    }

    @Override
    public List<Flights> getAllTheFLights() {
        return new ArrayList<>(adminDao.getAllTheFLights());
    }

    @Override
    public Arrival CreateArrival(String Arrival, String Arrivaldate) {
        Arrival arrival;
        arrival = adminDao.CreateArrival(Arrival,Arrivaldate);
        arrivalList.add(arrival);
       support.firePropertyChange(utils.NEWARRIVAL,null,arrival);
        return arrival;
    }

    @Override
    public Depature CreateDeparture(String Departure, String DepartureDate) {
        Depature  departure;
        departure = adminDao.CreateDeparture(Departure,DepartureDate);
        departureList.add(departure);
        support.firePropertyChange(utils.NEWDEPARTURE,null,departure);
        return departure;
    }

    @Override
    public PlaneType CreatePlane(String PlaneTypes) {
        PlaneType planeType;
        planeType = adminDao.CreatePlane(PlaneTypes);
        planeTypeList.add(planeType);
        support.firePropertyChange(utils.NEWPLANE,null,planeType);
        return planeType;
    }

    @Override
    public List<PlaneType> getAllPlaneType() {
        return new ArrayList<>(adminDao.getAllPlaneType());
    }

    @Override
    public List<Depature> getAllDeparture() {
        return new ArrayList<>(adminDao.getAllDeparture());
    }

    @Override
    public List<Arrival> getAllArrival() {
        return new ArrayList<>(adminDao.getAllArrival());
    }

    @Override
    public void deleteArrival(Arrival arrival) {
        adminDao.deleteArrival(arrival);
    }

    @Override
    public void deleteDeparture(Depature depature) {
        adminDao.deleteDeparture(depature);

    }

    @Override
    public void deletePlaneType(PlaneType planeType) {
        adminDao.deletePlaneType(planeType);

    }

    @Override
    public List<Seat> getSeats() {
        return new ArrayList<>(seatDao.getSeats());
    }

    @Override
    public List<Airport> getAirport() {
        return new ArrayList<>(airportDao.getAirport());
    }

    @Override public Passenger passernger(String FirstName, String LastName, String TelNumber, String email) {
        Passenger passenger;
        passenger = passengerDao.CreatePassengers(FirstName, LastName, TelNumber,email);
        passengersList.add(passenger);
        System.out.println("Passenger id er : " +passenger);
        support.firePropertyChange(utils.NEWPASSENGER,null,passenger);
        return passenger;
    }

    @Override
    public Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email) {
        return passengerDao.ReadPassenger(Firstname,LastName,TelNumber,Email);
    }

    @Override
    public Passenger readByEmail(String email) {
        return passengerDao.readByEmail(email);
    }

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
    public Flights readPrice(String price) {
        return shoppingCartDao.readPrice(price);
    }

    @Override
    public Airport CreateAirport(String airportId, String airportName, String airportCity) {
        Airport airport;
        airport = airportDao.CreateAirport(airportId,airportName,airportCity);
        airportList.add(airport);
        support.firePropertyChange(utils.NEWAIRPORT, null, airport);
        System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
        return airport;
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
