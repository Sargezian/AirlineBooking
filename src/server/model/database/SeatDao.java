package server.model.database;

import shared.transferobjects.Seat;

import java.util.List;

public interface SeatDao {

    List<Seat> getSeat();
    Seat getSeatId(int seatID,String seatNumber, String classType);


    //Seat CreateSeat(String seatNumber, String classType);


}
