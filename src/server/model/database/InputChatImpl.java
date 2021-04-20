package server.model.database;

import shared.transferobjects.InputChat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InputChatImpl {

    private static InputChatImpl daoInstance;
    private daoConnection daoconnection;


    private InputChatImpl() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        daoconnection = daoConnection.getInstance();
    }

    public static synchronized InputChatImpl getInstance(){

        if (daoInstance == null){

            daoInstance = new InputChatImpl();

        }

        return daoInstance;
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
