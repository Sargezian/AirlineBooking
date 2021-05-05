package server.model.database;

import shared.transferobjects.Seat;

import java.util.List;

public interface SeatDao {

    List<Seat> getSeat(int planeId);
    Seat getSeatId(int seatID,String seatNumber, String classType);
    void delete(int seatID);

    //Seat CreateSeat(String seatNumber, String classType);


}
