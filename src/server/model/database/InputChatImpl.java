package server.model.database;

import shared.transferobjects.InputChat;
import shared.transferobjects.Rating;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InputChatImpl implements InputChatDao {

    private static InputChatImpl daoInstance;
    private daoConnection daoconnection;

    public static synchronized InputChatImpl getInstance(){

        if (daoInstance == null){

            daoInstance = new InputChatImpl();

        }

        return daoInstance;
    }

    private InputChatImpl() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        daoconnection = daoConnection.getInstance();
    }

    //createChat
    public InputChat createChat(String chat, int star) {
        try {
            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO InputChat(chat,star) VALUES (?,?) ");

                statement.setString(1, chat);
                statement.setInt(2,star);

                statement.executeUpdate();
                return new InputChat(chat, new Rating(star));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //reads chat
    public List<InputChat> readChat() {
        try {
            try (Connection connection =  daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM InputChat");
                ResultSet resultSet = statement.executeQuery();
                ArrayList<InputChat> result = new ArrayList<>();

                while (resultSet.next()) {
                    String chat = resultSet.getString("chat");
                    int star = resultSet.getInt("star");
                    InputChat inputChat = new InputChat(chat, new Rating(star));
                    result.add(inputChat);
                }
                return result;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Rating> getRatings() {
        try {

            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Rating");
                ResultSet resultSet = statement.executeQuery();

                ArrayList<Rating> rating = new ArrayList<>();
                while (resultSet.next()) {

                    //rating
                    int star = resultSet.getInt("star");
                    Rating rating1 = new Rating(star);
                    rating.add(rating1);
                }
                return rating;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public int CountChat(){
        try {
            try (Connection connection =  daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT count(*) FROM InputChat");
                ResultSet resultSet = statement.executeQuery();

                resultSet.next();
                int count = resultSet.getInt("count") ;

                return count;


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


}
