package server.model.database;

import shared.transferobjects.Seat;
import shared.transferobjects.flights;
import shared.transferobjects.myFlightTicket;

public interface ShoppingCartDao {


    flights readFlightsFromShoppingCart(String flightName, String from, String to);
    Seat readSeatFromShoppingCart(String seatNumber,String classType);




}
