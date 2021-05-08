
package server.model.database;

import shared.transferobjects.Passenger;
import shared.transferobjects.PlaneType;
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
    public List<Seat> getSeat(int planeId) {
        try {

            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("select * from seat where planeID = ?");
                statement.setInt(1,planeId);
                ResultSet resultSet = statement.executeQuery();

                ArrayList<Seat> Seats = new ArrayList<>();
                while (resultSet.next()) {

                    //seat
                    int seatID = resultSet.getInt("seatID");
                    String seatNumber = resultSet.getString("seatNumber");
                    String classType = resultSet.getString("classType");
                    int getplaneId = resultSet.getInt("planeId");
                    //Linje 38 skal måske kun have seat ID
                    Seat seat = new Seat(seatID, seatNumber, classType, new PlaneType(planeId));
                    Seats.add(seat);
                }
                return Seats;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public Seat getSeatId(int seatID, String seatNumber, String classType) {
        try {
            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO Seat(seatID, seatNumber,classType ) VALUES (?,?,?) ");

                //seat
                statement.setInt(1, seatID);
                statement.setString(2,seatNumber);
                statement.setString(3, classType);
                statement.executeUpdate();
                ResultSet key = statement.getGeneratedKeys();

                if (key.next()) {

                    return new Seat(seatID, seatNumber,classType);
                } else {

                    throw new SQLException("Her bliver det testet på at lave en ny seat");

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}




