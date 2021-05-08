/*

package client.views.seat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.InputUserImpl;
import server.model.database.SeatDao;
import server.model.database.SeatImpl;
import shared.transferobjects.Flights;
import shared.transferobjects.Passenger;
import shared.transferobjects.Seat;

import static org.junit.jupiter.api.Assertions.*;

class seatViewModelTest
{
  private seatViewModel vm;
  private SeatDao seatDao;

  @BeforeEach public void setup()
  {
    seatDao = new SeatImpl();
  }

  @Test
  public void testifwecanreadfromdatabase(){
    Flights flights = new Flights("200","flydummydeparture","flydummyarrivals");

    Seat seat = new Seat(1,"A9","First Class");
    seatDao.getSeat(1).equals(seat);

    assertEquals(seat,seatDao.getSeat(1));
  }


  @Test
  public void Testifwecanaddtodatabase(){
    seatDao.getSeatId(100,"A49","Fist Class");
    seatDao.getSeat(1);

  }
}


*/
