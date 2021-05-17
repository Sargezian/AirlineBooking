package server.model.database;

import shared.transferobjects.Seat;

import java.util.List;

public interface SeatDao {

    List<Seat> getSeat(int planeId);
    Seat getSeatId(int seatID,String seatNumber, String classType);
    Seat CreateSeat(String SeatNumber,String classtype);
    List<Seat> getSeats();
    void deleteSeat(Seat seat);




}
