package server.model.database;

import shared.transferobjects.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoImpl implements daoInterface  {

  private static daoImpl daoInstance;
  private daoConnection daoconnection;


  private daoImpl() {
    try {
      DriverManager.registerDriver(new org.postgresql.Driver());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    daoconnection = daoConnection.getInstance();
  }

     public static synchronized daoImpl getInstance(){

          if (daoInstance == null){

            daoInstance = new daoImpl();

          }

          return daoInstance;
     }


 /** --------------------------------------------------------------------------------------------------------------------**/

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
         String planeType = resultSet.getString("planeType");
         Timestamp departure = resultSet.getTimestamp("departure");
         Timestamp arrival = resultSet.getTimestamp("arrival");
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

  @Override
  public List<seat> getSeat() {
    try {

      try (Connection connection = daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM seat");
        ResultSet resultSet = statement.executeQuery();

        ArrayList<seat> seats = new ArrayList<>();
        while (resultSet.next()) {
          int seatID = resultSet.getInt("seatID");
          String seatNumber = resultSet.getString("seatNumber");
          String classType = resultSet.getString("classType");
          seat seat = new seat(seatID, seatNumber, classType);
          seats.add(seat);
        }
        return seats;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public passenger CreatePassengers(String FirstName, String LastName, String TelNumber) {
    try {
      try (Connection connection =  daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO passenger(FirstName,LastName,TelNumber) VALUES (?,?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(1, FirstName);
        statement.setString(2, LastName);
        statement.setString(3, TelNumber);
        statement.executeUpdate();
        ResultSet key = statement.getGeneratedKeys();

          if (key.next()) {

            return new passenger(key.getInt(1),TelNumber,FirstName,LastName );
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
  public List<myFlightTicket> ReadFlightList()  {

    try{

      try (Connection connection = daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("select * from flights join myFlightTicket mFT on flights.flightID = mFT.flightID join passenger p on mFT.passengerid = p.passengerid join seat s on s.seatid = mFT.seatid  ");
        ResultSet resultSet = statement.executeQuery();

        ArrayList<myFlightTicket> myFlightTickets = new ArrayList<>();
        while (resultSet.next()) {
          int FlightId = resultSet.getInt("flightid");
          String Flightname = resultSet.getString("flightname");
          String planeType = resultSet.getString("planeType");
          Timestamp departure = resultSet.getTimestamp("departure");
          Timestamp arrival = resultSet.getTimestamp("arrival");
          String from = resultSet.getString("from_");
          String to = resultSet.getString("to_");
          int ticketid = resultSet.getInt("ticketid");
          int price = resultSet.getInt("price");
          int passengerID = resultSet.getInt("passengerid");
          int seatId = resultSet.getInt("seatid");
          String FirstName = resultSet.getString("FirstName");
          String LastName = resultSet.getString("LastName");
          String TelNumber = resultSet.getString("TelNumber");
          String seatNumber = resultSet.getString("seatNumber");
          String classtype = resultSet.getString("classType");
          myFlightTicket myFlightTicket = new myFlightTicket(ticketid,price,new passenger(passengerID,TelNumber,FirstName,LastName),new flights(FlightId,Flightname,planeType,departure,arrival,from,to,price),new seat(seatId,seatNumber,classtype));

        myFlightTickets.add(myFlightTicket);
        }
        return myFlightTickets;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
    }

  @Override
  public void createTicket(myFlightTicket myFlightTicket) {
    try {
      try (Connection connection =  daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement(" insert into myFlightTicket(flightID, passengerID, seatID,price) VALUES (?,?,?,?)");

        System.out.println( "database connection til createticket");

        statement.setInt(1, myFlightTicket.getFlights().getFlightID());
        statement.setInt(2, myFlightTicket.getPassenger().getPassengerID());
        statement.setInt(3, myFlightTicket.getSeat().getSeatID());
        statement.setInt(4, myFlightTicket.getPrice());

        statement.executeUpdate();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }

  public InputUser createUser(String txt) {
    try {
      try (Connection connection =  daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO InputUser(user_) VALUES (?) ", PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(1, txt);
        statement.executeUpdate();
        ResultSet key = statement.getGeneratedKeys();

        if (key.next()) {

          return new InputUser(key.getInt(1), txt);
        } else {

          throw new SQLException("hej med dig");

        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }


  public List<InputUser> readUser() {
    try {
      try (Connection connection =  daoConnection.getConnection()) {

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM InputUser ");

        ResultSet resultSet = statement.executeQuery();
        ArrayList<InputUser> result = new ArrayList<>();
        while (resultSet.next()) {
          String txt = resultSet.getString("user_");
          int id = resultSet.getInt("id");
          InputUser inputUser = new InputUser(id, txt);
          result.add(inputUser);

        }
        return result;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }

  public InputChat createChar(String str) {
    try {
      try (Connection connection = daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO InputChat(chat) VALUES (?) ");
        statement.setString(1, str);
        statement.executeUpdate();
        return new InputChat(str);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }

  public List<InputChat> readChat() {
    try {
      try (Connection connection =  daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM InputChat");
        ResultSet resultSet = statement.executeQuery();
        ArrayList<InputChat> result = new ArrayList<>();
        while (resultSet.next()) {
          String str = resultSet.getString("chat");
          InputChat inputChat = new InputChat(str);
          result.add(inputChat);

        }
        return result;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }




















}


