package server.model.database;

import shared.transferobjects.Passenger;
import shared.transferobjects.Seat;
import shared.transferobjects.flights;
import shared.transferobjects.myFlightTicket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingCartImpl implements ShoppingCartDao {

    private static ShoppingCartImpl daoInstance;

    public static synchronized ShoppingCartImpl getInstance(){

        if (daoInstance == null){
            daoInstance = new ShoppingCartImpl();
        }
        return daoInstance;
    }


    @Override
    public flights readFlightsFromShoppingCart(String flightName, String departures, String arrivals) {
        try {
            try (Connection connection =  daoConnection.getConnection()) {

                PreparedStatement statement = connection.prepareStatement("select *  from flights join Arrival A on A.ArrivalID = flights.ArrivalID join Departure D on D.DepartureID = flights.DepartureID WHERE flightname = ? AND departures = ? AND arrivals = ? ");

                //flight
                statement.setString(1, flightName);

                //departure
                statement.setString(2, departures);

                //arrival
                statement.setString(3, arrivals);


                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    flights flights = new flights(flightName,departures,arrivals);
                    return flights;

                }
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    @Override
    public Seat readSeatFromShoppingCart(String seatNumber, String classType) {

        try {
            try (Connection connection =  daoConnection.getConnection()) {

                PreparedStatement statement = connection.prepareStatement("select *  from seat WHERE seatNumber = ? AND classType = ?  ");

                //seat
                statement.setString(1, seatNumber);
                statement.setString(2, classType);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                   Seat seat = new Seat(seatNumber,classType);
                   return seat;

                }
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }




}
