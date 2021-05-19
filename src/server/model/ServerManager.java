package server.model;

import shared.transferobjects.*;
import shared.util.Subject;

import java.util.List;

public interface ServerManager extends Subject
{

    //chat
    List<InputChat> getChat();
    InputChat createChat(String chat, double star);
    int CountChat();

    //rating
    List<Rating> getRatings();
    double AverageStars();
    int CountRatings(double star);

    //user
    List<InputUser> getUser();
    InputUser CreateUser(String user, String password);
    InputUser readUser(String user, String password);
    InputUser readUsername(String user);
    boolean ValidateUser(String user, String password);

    //seat
    List<Seat> getSeat(int planeId);
    Seat getSeatID(int seatID, String seatNumber, String classType);
    Seat CreateSeat(String SeatNumber, String classtype);
    void deleteSeat(Seat seat);

    //flight
    List<Flights> getflights();
    List<Flights> readByName(String searchString);
    Flights CreateFlights(String flightID, String flightName, String price);

    //Admin
    List<Flights> getAllTheFLights();
    List<Seat> getSeats();
    List<Airport> getAirport();
    List<PlaneType> getAllPlaneType();
    List<Depature> getAllDeparture();
    List<Arrival> getAllArrival();
    Arrival CreateArrival(String Arrival, String Arrivaldate);
    Depature CreateDeparture(String Departure, String DepartureDate);
    PlaneType CreatePlane(String PlaneTypes);
    Airport CreateAirport(String airportId, String airportName, String airportCity);
    void deleteArrival(Arrival arrival);
    void deleteDeparture(Depature depature);
    void deletePlaneType(PlaneType planeType);
    void deleteFlight(Flights flights);

    //passenger
    Passenger passernger(String FirstName, String LastName, String TelNumber,
        String email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber,
        String Email);
    Passenger readByEmail(String email);

    //ticket
    List<myFlightTicket> getflightlist(int userId);

    //payment
    Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate);
    void createTicket(myFlightTicket myFlightTicket);

    //shoppingCart
    Flights readFlightsFromShoppingCart(String flightName, String departure,
        String arrival);
    Seat readSeatFromShoppingCart(String seatNumber, String classType);
    Flights readPrice(String price);

}


