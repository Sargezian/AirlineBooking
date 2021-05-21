package server.model.database;

import shared.transferobjects.*;
import java.sql.*;

public class PassengerImpl implements PassengerDao {

    private static PassengerImpl daoInstance;
    private daoConnection daoconnection;
    public static synchronized PassengerImpl getInstance() {

        if (daoInstance == null) {
            daoInstance = new PassengerImpl();
        }
        return daoInstance;
    }

    private PassengerImpl()
    {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        daoconnection = daoConnection.getInstance();
    }

    @Override
    public Passenger CreatePassengers(String FirstName, String LastName, String TelNumber, String Email) {
        try {
            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO passenger(FirstName,LastName,TelNumber,email) VALUES (?,?,?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);

                //passenger
                statement.setString(1, FirstName);
                statement.setString(2, LastName);
                statement.setString(3, TelNumber);
                statement.setString(4, Email);
                statement.executeUpdate();
                ResultSet key = statement.getGeneratedKeys();

                if (key.next()) {

                    return new Passenger(key.getInt(1), FirstName, LastName, TelNumber, Email);
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

                //passenger
                statement.setString(1, Firstname);
                statement.setString(2, LastName);
                statement.setString(3, TelNumber);
                statement.setString(4, Email);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {


                    //Getter
                    Passenger passenger = passengerFromResultset(resultSet);
                    return passenger;
                }
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private Passenger passengerFromResultset(
            ResultSet resultSet) throws SQLException
    {
        String FirstName = resultSet.getString("FirstName");
        String Lastname = resultSet.getString("LastName");
        String Telnumber = resultSet.getString("TelNumber");
        String email = resultSet.getString("email");
        int PassengerID = resultSet.getInt("passengerID");
        Passenger passenger = new Passenger(PassengerID, FirstName, Lastname, Telnumber, email);
        return passenger;
    }

}
