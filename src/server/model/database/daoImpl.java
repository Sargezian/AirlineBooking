package server.model.database;

import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.transferobjects.flights;

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




  public InputChat createChar(String str) {
    System.out.println("Her starter create Chat");
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
    System.out.println("Her slutter Create Chat");
    return null;
  }


  public List<InputChat> readChat() {
    System.out.println("her begynder readchat");
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
        System.out.println(result.size() + " readchat size ");
        return result;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    System.out.println("her slutter readchat");
    return null;
  }


  public InputUser createUser(String txt) {
    System.out.println("Her begynder createUser");
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
    System.out.println("Her slutter create User");
    return null;
  }


  public List<InputUser> readUser() {
    System.out.println("Her begynder readUser");
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
    System.out.println("Her Slutter read user ");
    return null;
  }



  public void update(InputChat inputchat) {
    System.out.println("Her begynder Update");
    try {
      try (Connection connection =  daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("UPDATE InputChat set chat=? ");
        statement.setString(1, inputchat.getInput());
        statement.executeUpdate();

      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }


  public void update(InputUser inputuser) {
    try {
      try (Connection connection =  daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("UPDATE InputUser SET id = ?,user_ =? ");
        statement.setInt(1, inputuser.getId());
        statement.setString(2, inputuser.getOutput());
        statement.executeUpdate();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }


  public void remove(InputChat inputChat) {
    try {
      try (Connection connection =  daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("DELETE  FROM InputChat ");
        statement.executeUpdate();


      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }


  public void remove(InputUser inputUser) {
    try {
      try (Connection connection =  daoConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("DELETE  FROM InputUser");
        statement.executeUpdate();

      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }


 /** --------------------------------------------------------------------------------------------------------------------**/

  @Override
  public List<flights> getflights() {
   try{

     System.out.println("databse connnection virker");
     try(Connection connection = daoConnection.getConnection()){
       PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights");
       ResultSet resultSet = statement.executeQuery();

       ArrayList<flights> flightslist = new ArrayList<>();
       while (resultSet.next()) {
         String flight = resultSet.getString("flightname");
         String seats = resultSet.getString("seats");
         flights flights = new flights(flight,seats);
         flightslist.add(flights);

       }
       return flightslist;

     }




   } catch (Exception e) {
     e.printStackTrace();
   }

 return null;
  }

}