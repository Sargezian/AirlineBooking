package server.model.database;

import server.model.TextManager;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;

import java.beans.PropertyChangeListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static server.model.database.daoConnection.getConnection;

public class daoImpl implements daoInterface
{
  public daoImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  @Override public InputChat createChar(String str) throws SQLException
  {
    try (Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement("INSERT INTO InputChat(chat) VALUES (?) ");
      statement.setString(1,str);
      statement.executeUpdate();
      return new InputChat(str);
    }
  }

 @Override public List<InputChat> readChat( ) throws SQLException
  {
    try (Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM InputChat");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<InputChat> result = new ArrayList<>();
      while(resultSet.next()){
        String str =  resultSet.getString("chat");
        InputChat inputChat = new InputChat(str);
        result.add(inputChat);
      }
       return result;
    }
  }

 @Override public InputUser createUser(String txt) throws SQLException
  {
      try (Connection connection = getConnection()){
        PreparedStatement statement = connection.prepareStatement("INSERT INTO InputUser(user_) VALUES (?) ", PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(1,txt);
        statement.executeUpdate();
        ResultSet key = statement.getGeneratedKeys();

        if (key.next()){

          return new InputUser(key.getInt(1),txt);
        }

        else{

          throw new SQLException("hej med dig");

        }
    }
  }

 @Override public List<InputUser> readUser() throws SQLException
  {
    try (Connection connection = getConnection()){

      PreparedStatement statement = connection.prepareStatement("SELECT * FROM InputUser ");

      ResultSet resultSet = statement.executeQuery();
      ArrayList<InputUser> result = new ArrayList<>();
      while (resultSet.next()){
        String txt =  resultSet.getString("user_");
        int id = resultSet.getInt("id");
        InputUser inputUser = new InputUser(id,txt);
        result.add(inputUser);

      }
      return result;
    }


  }
}
