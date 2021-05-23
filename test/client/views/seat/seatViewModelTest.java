package client.views.seat;

import client.core.ClientFactory;
import client.core.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.*;
import shared.transferobjects.Flights;
import shared.transferobjects.Passenger;
import shared.transferobjects.Seat;

import static org.junit.jupiter.api.Assertions.*;

class seatViewModelTest
{
  private seatViewModel viewModel;
  private SeatDao seatDao;
  private ResetDao resetDao;
  private SeatImpl seatimpl;

  @BeforeEach public void setup()
  {
    seatDao = new SeatImpl();
    ClientFactory.getInstance().getClient();
    viewModel = new seatViewModel(ModelFactory.getInstance().getClientText());
    viewModel.loadSeat();
    seatimpl = SeatImpl.getInstance();
    resetDao = new ResetImpl();

    resetDao.reset();

  }

  @Test public void testifwecanreadfromdatabase()
  {
    Flights flights = new Flights("200", "flydummydeparture", "flydummyarrivals");

    Seat seat = new Seat(1, "A9", "First Class");
    seatDao.getSeat(1).equals(seat);

    assertEquals(seat, seatDao.getSeat(1));
  }

  @Test public void Testifwecanaddtodatabase()
  {
    seatDao.getSeatId(100, "A49", "Fist Class");
    seatDao.getSeat(1);

  }

  @Test public void TestNoSelectedSeet()
  {
    Seat seat = new Seat(54, "A5", "First class");
//    viewModel.getSeat()
 //       .add(seat.getSeatID(), seat.getSeatNumber(), seat.getClassType());
    viewModel.getSeatInformation(seat);
    assertEquals("", viewModel.errorProperty().get());
  }
}