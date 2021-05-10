package client.model;

import shared.transferobjects.*;
import shared.util.Subject;

import java.rmi.RemoteException;
import java.util.List;

public interface ClientText extends Subject {

    //chat
    InputChat createChat(String chat, double star);
    List<InputChat> getChat();
    int CountChat();

    //user
    InputUser username(String user, String password);
    List<InputUser> getUser();
    InputUser readUser(String user,String password);
    InputUser readUsername(String user);
    boolean ValidateUser(String user, String password);

    //ratings
    List<Rating> getRatings();
    int CountRatings(double star);

    //average
    double AverageStars();

    //flight
    List<Flights> getflights();
    List<Flights> readByName(String searchString);
    Flights CreateFlights(String flightName, int price);

    //seat
    List<Seat> getSeat(int planeId);
    Seat getSeatId(int seatID, String seatNumber, String classType);
    Seat CreateSeat(int seatId, String SeatNumber,String classtype);

    //Airport
    Airport CreateAirport(int airportID, Depature depature);
    // Arrival
    Arrival CreateArrival(int arrivalID, String arrival,String arrivalDate);
    // Departure
    Depature CreateDeparture(int departureID, String departure, String departureDate)

    //passenger
    Passenger Createpassernger(String FirstName, String LastName, String TelNumber, String email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);
    Passenger readByEmail(String email);

    //payment
    Payment payment(String cardholderName, String cardNumber, String CVV, String expirationDate);

    //shoppingCart
    Flights readFlightsFromShoppingCart(String flightName, String departure, String arrival);
    Seat readSeatFromShoppingCart(String seatNumber,String classType);

    //ticket
    /* List<myFlightTicket> ReadPriceSUM();*/
    List<myFlightTicket> getflightlist(int userId);
    void createTicket(myFlightTicket myFlightTicket);
    myFlightTicket readUsername_(String user);
    Flights readPrice(int price);



    Object cloak();



}


