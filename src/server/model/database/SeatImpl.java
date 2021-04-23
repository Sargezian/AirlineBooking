package server.model.database;

import shared.transferobjects.Seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatImpl implements SeatDao {

    private static SeatImpl daoInstance;

    public static synchronized SeatImpl getInstance(){

        if (daoInstance == null){
            daoInstance = new SeatImpl();
        }
        return daoInstance;
    }

    @Override
    public List<Seat> getSeat() {
        try {

            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM seat");
                ResultSet resultSet = statement.executeQuery();

                ArrayList<Seat> Seats = new ArrayList<>();
                while (resultSet.next()) {
                    int seatID = resultSet.getInt("seatID");
                    String seatNumber = resultSet.getString("seatNumber");
                    String classType = resultSet.getString("classType");
                    Seat seat = new Seat(seatID, seatNumber, classType);
                    Seats.add(seat);
                }
                return Seats;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

   /* @Override
    public Seat CreateSeat(String seatNumber, String classType) {
        try {
            try (Connection connection =  daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO seat(seatNumber,classType) VALUES (?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1, seatNumber);
                statement.setString(2, classType);
                statement.executeUpdate();
                ResultSet key = statement.getGeneratedKeys();

                if (key.next()) {

                    return new Seat(key.getInt(1),seatNumber,classType);
                } else {

                    throw new SQLException("Her bliver det testet på at lave en ny seat");

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }*/


}
