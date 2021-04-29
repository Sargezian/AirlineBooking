package server.model.database;

import shared.transferobjects.Seat;

import java.util.List;

public interface SeatDao {

    List<Seat> getSeat();
    Seat getSeatId(String seatID,String seatNumber, String classType);


    //Seat CreateSeat(String seatNumber, String classType);


}
