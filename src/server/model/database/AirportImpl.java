package server.model.database;

import shared.transferobjects.Airport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
  @Override
  public List<Airport> getAirport() {
    try {

      try (Connection connection = daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("select * from airport");

        ResultSet resultSet = statement.executeQuery();

        ArrayList<Airport> airportArrayList = new ArrayList<>();
        while (resultSet.next()) {

          String airportId = resultSet.getString("airportID");
          String name = resultSet.getString("Name");
          String city = resultSet.getString("City");

             Airport airport = new Airport(airportId,name,city);

             airportArrayList.add(airport);

        }
        return airportArrayList;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  // TODO: 20/05/2021 læg ind i admin

}

