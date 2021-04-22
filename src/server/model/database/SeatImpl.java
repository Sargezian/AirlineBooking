package server.model.database;

import shared.transferobjects.seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


}
