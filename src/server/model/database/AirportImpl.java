package server.model.database;

import shared.transferobjects.Airport;
import shared.transferobjects.Flights;

import java.sql.*;

public class AirportImpl implements AirportDao
{
  private static AirportImpl daoInstance;
  private daoConnection daoconnection;

  private AirportImpl() {
    try {
      DriverManager.registerDriver(new org.postgresql.Driver());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    daoconnection = daoConnection.getInstance();
  }


  public static synchronized AirportImpl getInstance(){

    if (daoInstance == null){
      daoInstance = new AirportImpl();
    }
    return daoInstance;
  }
  @Override
  public Airport CreateAirport(String AirportID, String AirportName, String AirportCity) {
    try {
      try (Connection connection = daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO airport(airportID,Name,City) VALUES (?,?,?) ");

        //flights
        statement.setString(1, AirportID  );
        statement.setString(2, AirportName);
        statement.setString(3, AirportCity);

        statement.executeUpdate();


          return new Airport(AirportID,AirportName,AirportCity);
        }



    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }
}

