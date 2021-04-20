package server.model.database;

import shared.transferobjects.InputUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InputUserImpl implements InputUserDao {


    private static InputUserImpl daoInstance;
    private daoConnection daoconnection;


    private InputUserImpl() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        daoconnection = daoConnection.getInstance();
    }

    public static synchronized InputUserImpl getInstance(){

        if (daoInstance == null){

            daoInstance = new InputUserImpl();

        }

        return daoInstance;
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


}
