package client.views.seat;

import client.core.ClientFactory;
import client.core.ModelFactory;
import client.model.SaveInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.*;
import shared.transferobjects.*;

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

  @Test public void TestSelectedSeat()
  {
    SaveInfo.getInstance().setFlights(new Flights("1","sas",new Depature(1,"KBH","2021-08-08 19:30:00"),new Arrival(1,"AAR","2021-09-08 19:30:00")
        ,new PlaneType(1,"Airbus7"),"200"));
    SaveInfo.getInstance().setSeat(new Seat(1,"22","Business class"));
    Seat seat = SaveInfo.getInstance().getSeat();
    viewModel.getSeatInformation(seat);
    assertNull( viewModel.errorProperty().get());
  }

  @Test public void TestNoSelectedSeat()
  {
    SaveInfo.getInstance().setFlights(new Flights("1","sas",new Depature(1,"KBH","2021-08-08 19:30:00"),new Arrival(1,"AAR","2021-09-08 19:30:00")
        ,new PlaneType(1,"Airbus7"),"200"));
    Seat seat = SaveInfo.getInstance().getSeat();
    viewModel.getSeatInformation(seat);
    assertEquals("Please select seat for continue", viewModel.errorProperty().get());
  }
}