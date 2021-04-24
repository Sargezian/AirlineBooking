package server.model.database;

import shared.transferobjects.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerImpl implements PassengerDao {

    private static PassengerImpl daoInstance;

    public static synchronized PassengerImpl getInstance() {

        if (daoInstance == null) {
            daoInstance = new PassengerImpl();
        }
        return daoInstance;
    }

    @Override
    public Passenger CreatePassengers(String FirstName, String LastName, String TelNumber, String Email) {
        try {
            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO passenger(FirstName,LastName,TelNumber,email) VALUES (?,?,?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1, FirstName);
                statement.setString(2, LastName);
                statement.setString(3, TelNumber);
                statement.setString(4, Email);
                statement.executeUpdate();
                ResultSet key = statement.getGeneratedKeys();

                if (key.next()) {

                    return new Passenger(key.getInt(1), TelNumber, FirstName, LastName, Email);
                } else {

                    throw new SQLException("Her bliver det testet på at lave en ny passenger");

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email)  {
        try {
            try (Connection connection =  daoConnection.getConnection()) {

                PreparedStatement statement = connection.prepareStatement("select * from passenger where Firstname = ? and LastName = ? and TelNumber = ? and Email = ?  ");

                statement.setString(1, Firstname);
                statement.setString(2, LastName);
                statement.setString(3, TelNumber);
                statement.setString(4, Email);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    Passenger passenger = new Passenger(Firstname, LastName, TelNumber, Email);
                    return passenger;
                }
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}




