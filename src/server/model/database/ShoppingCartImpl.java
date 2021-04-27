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
    public flights readFlightsFromShoppingCart(String flightName, String from, String to) {
        try {
            try (Connection connection =  daoConnection.getConnection()) {

                PreparedStatement statement = connection.prepareStatement("select *  from flights WHERE flightName = ? AND from_ = ? AND to_ = ? ");

                statement.setString(1, flightName);
                statement.setString(2, from);
                statement.setString(3, to);


                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    flights flights = new flights(flightName,from,to);
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
