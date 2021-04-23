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
       PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights ");
       ResultSet resultSet = statement.executeQuery();

       ArrayList<flights> flightlist = new ArrayList<>();
       while (resultSet.next()) {
         int flightID = resultSet.getInt("flightID");
         String flightName = resultSet.getString("flightName");

         //ny table her.
         String planeType = resultSet.getString("planeType");
         Timestamp departure = resultSet.getTimestamp("departure");
         Timestamp arrival = resultSet.getTimestamp("arrival");
         //

         String from = resultSet.getString("from_");
         String to = resultSet.getString("to_");
         int price = resultSet.getInt("price");
         flights flights = new flights(flightID, flightName,planeType, departure, arrival, from, to,price);
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


