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

    public InputUser createUser(String user, String password) {
        try {
            try (Connection connection =  daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO InputUser(user_, password) VALUES (?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1, user);
                statement.setString(2, password);
                statement.executeUpdate();
                ResultSet key = statement.getGeneratedKeys();

                if (key.next()) {

                    return new InputUser(key.getInt(1), user, password);
                } else {

                    throw new SQLException("Login test");

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<InputUser> readUser() {
        try {
            try (Connection connection =  daoConnection.getConnection()) {

                PreparedStatement statement = connection.prepareStatement("SELECT * FROM InputUser ");

                ResultSet resultSet = statement.executeQuery();
                ArrayList<InputUser> result = new ArrayList<>();
                while (resultSet.next()) {
                    String user = resultSet.getString("user_");
                    int id = resultSet.getInt("id");
                    InputUser inputUser = new InputUser(id, user);
                    result.add(inputUser);

                }
                return result;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }



    public boolean ValidateUser(String user, String password)  {
        try {
            try (Connection connection =  daoConnection.getConnection()) {

                PreparedStatement statement = connection.prepareStatement("SELECT * FROM InputUser WHERE user_ = ? AND password = ? ");
                statement.setString(1,user);
                statement.setString(2,password);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    return true;
                }

                else{

                    return false;
                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


}
