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
 public List<flights> getflights() {
   try {

     try (Connection connection = daoConnection.getConnection()) {
       PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights inner join arrival a on a.arrivalid = flights.arrivalid inner join departure d on d.departureid = flights.departureid join planetype p on p.planeid = flights.planeid");
       ResultSet resultSet = statement.executeQuery();

       ArrayList<flights> flightlist = new ArrayList<>();
       while (resultSet.next()) {
         int flightID = resultSet.getInt("flightid");
         String flightName = resultSet.getString("flightName");

         //ny table her.
         String planeType = resultSet.getString("planeTypes");
         int planeID = resultSet.getInt("planeid");

         int depatureID = resultSet.getInt("departureid");
         String departure = resultSet.getString("departures");
         Timestamp depatureDate = resultSet.getTimestamp("departuredate");

         int arrivalID = resultSet.getInt("arrivalid");
         Timestamp arrivaldate = resultSet.getTimestamp("arrivaldate");
         String arrival = resultSet.getString("arrivals");

         //
         int price = resultSet.getInt("price");
         flights flights = new flights(flightID, flightName, new Depature(depatureID,departure,depatureDate),new Arrival(arrivalID,arrival,arrivaldate),new PlaneType(planeID,planeType),price);
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
  public List<flights> readByName(String searchString) {
    try {

      try (Connection connection = daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights WHERE flightName LIKE ? ");
        statement.setString(1,"%" + searchString +"%");
        ResultSet resultSet = statement.executeQuery();

        ArrayList<flights> flightlist = new ArrayList<>();
        while (resultSet.next()) {
          int flightID = resultSet.getInt("flightID");
          String flightName = resultSet.getString("flightName");
          String planeType = resultSet.getString("planeType");


          Timestamp departure = resultSet.getTimestamp("departure");
          Timestamp arrival = resultSet.getTimestamp("arrival");



          String from = resultSet.getString("from_");
          String to = resultSet.getString("to_");
          int price = resultSet.getInt("price");



          /*flights flights = new flights(flightID, flightName,planeType, departure, arrival, from, to,price);
          flightlist.add(flights);*/
        }
        return flightlist;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}


