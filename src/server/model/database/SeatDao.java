package server.model.database;

import shared.transferobjects.Seat;

import java.util.List;

public interface SeatDao {

    List<Seat> getSeat();


    //Seat CreateSeat(String seatNumber, String classType);


}
