package server.model.database;

import shared.transferobjects.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightImpl implements FlightDao {

  private static FlightImpl daoInstance;
  private daoConnection daoconnection;

  private FlightImpl() {
    try {
      DriverManager.registerDriver(new org.postgresql.Driver());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    daoconnection = daoConnection.getInstance();
  }


     public static synchronized FlightImpl getInstance(){

          if (daoInstance == null){
            daoInstance = new FlightImpl();
          }
          return daoInstance;
     }

@Override
  public Flights CreateFlights(String flightID, String flightName, String price ) {
    try {
      try (Connection connection = daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO flights(flightID,flightName,price) VALUES (?,?,?)");

        //flights


        statement.setString(1,flightID);
        statement.setString(2, flightName);
        statement.setString(3,price);

        statement.executeUpdate();
          return new Flights(flightID,flightName,price);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override
  public void deleteFlight(Flights flights) {
    try {
      try (Connection connection = daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("DELETE From flights WHERE flightID = ? ");
        statement.setString(1,flights.getFlightID());
        statement.executeUpdate();

      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


  }


  @Override
 public List<Flights> getflights() {
   try {

     try (Connection connection = daoConnection.getConnection()) {
       PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights inner join arrival a on a.arrivalid = flights.arrivalid inner join departure d on d.departureid = flights.departureid join planetype p on p.planeid = flights.planeid");
       ResultSet resultSet = statement.executeQuery();

       ArrayList<Flights> flightlist = new ArrayList<>();
       while (resultSet.next()) {

         //flight
         String flightID = resultSet.getString("flightid");
         String flightName = resultSet.getString("flightName");
         String price = resultSet.getString("price");

         //planetype
         String planeType = resultSet.getString("planeTypes");
         int planeID = resultSet.getInt("planeid");

         // depature
         int depatureID = resultSet.getInt("departureid");
         String departure = resultSet.getString("departures");
         String depatureDate = resultSet.getString("departuredate");

         //arrival
         int arrivalID = resultSet.getInt("arrivalid");
         String arrivaldate = resultSet.getString("arrivaldate");
         String arrival = resultSet.getString("arrivals");

         Flights flights = new Flights(flightID, flightName, new Depature(depatureID,departure,depatureDate),new Arrival(arrivalID,arrival,arrivaldate),new PlaneType(planeID,planeType),price);
         flightlist.add(flights);
       }
       return flightlist;
     }
   } catch (Exception e) {
     e.printStackTrace();
   }
   return null;
 }

  @Override
  public List<Flights> readByName(String searchString) {
    try {

      try (Connection connection = daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights inner join arrival a on a.arrivalid = flights.arrivalid inner join departure d on d.departureid = flights.departureid join planetype p on p.planeid = flights.planeid WHERE flightName iLIKE ? or departures ilike ? or arrivals ilike ?  ");
        statement.setString(1,"%" + searchString +"%");
        statement.setString(2,"%" + searchString +"%");
        statement.setString(3,"%" + searchString +"%");


        ResultSet resultSet = statement.executeQuery();

        ArrayList<Flights> flightlist = new ArrayList<>();
        while (resultSet.next()) {

          //flight
          String flightID = resultSet.getString("flightid");
          String flightName = resultSet.getString("flightName");
          String price = resultSet.getString("price");

          //planetype
          String planeType = resultSet.getString("planeTypes");
          int planeID = resultSet.getInt("planeid");

          // depature
          int depatureID = resultSet.getInt("departureid");
          String departure = resultSet.getString("departures");
          String depatureDate = resultSet.getString("departuredate");

          //arrival
          int arrivalID = resultSet.getInt("arrivalid");
          String arrivaldate = resultSet.getString("arrivaldate");
          String arrival = resultSet.getString("arrivals");

          Flights flights = new Flights(flightID, flightName, new Depature(depatureID,departure,depatureDate),new Arrival(arrivalID,arrival,arrivaldate),new PlaneType(planeID,planeType),price);
          flightlist.add(flights);
        }
        return flightlist;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

@Override
  public List<Flights> getAllTheFLights() {
    try {

      try (Connection connection = daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights");
        ResultSet resultSet = statement.executeQuery();

        ArrayList<Flights> flightlist = new ArrayList<>();
        while (resultSet.next()) {

          //flight
          String flightID = resultSet.getString("flightID");
          String flightName = resultSet.getString("flightName");
          String price = resultSet.getString("price");



          Flights flights = new Flights(flightID, flightName,price);
          flightlist.add(flights);
        }
        return flightlist;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }






}


