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

  @Override
  public void update(InputChat inputchat) throws SQLException {
    try (Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement("UPDATE InputChat SET chat=? ");
      statement.setString(1,inputchat.getInput());
      statement.executeUpdate();

    }
  }

  @Override
  public void update(InputUser inputuser) throws SQLException {
    try (Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement("UPDATE InputUser SET id=?,use_ =? ");
      statement.setInt(1,inputuser.getId());
      statement.setString(2,inputuser.getOutput());
      statement.executeUpdate();
    }

  }

  @Override
  public void remove(InputChat inputChat) throws SQLException {
    try (Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement("DELETE  FROM InputChat ");
      statement.executeUpdate();


    }
  }

  @Override
  public void remove(InputUser inputUser) throws SQLException {
    try (Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement("DELETE  FROM InputUser");
      statement.executeUpdate();

    }
  }
}
