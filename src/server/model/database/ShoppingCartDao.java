package server.model.database;

import shared.transferobjects.Seat;
import shared.transferobjects.Flights;

public interface ShoppingCartDao {


    Flights readFlightsFromShoppingCart(String flightName, String departures, String arrivals);
    Seat readSeatFromShoppingCart(String seatNumber,String classType);
    Flights readPrice(String price);




}
