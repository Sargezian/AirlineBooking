package client.views.passenger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.PassengerDao;
import server.model.database.PassengerImpl;
import shared.transferobjects.Flights;
import shared.transferobjects.Passenger;
import shared.transferobjects.Seat;

import static org.junit.jupiter.api.Assertions.*;

class passengerViewModelTest
{
  private passengerViewModel vm;
  private PassengerDao passengerDao;

  @BeforeEach public void setup()
  {
    vm.getFirstName();

    passengerDao = new PassengerImpl();
  }

  @Test
  public void testifwecanreadfromdatabase(){

    Passenger ps = passengerDao.CreatePassengers("Mar32k","Pede324rsen","49408234516","Mark23hjuler@gmail.com");

    assertEquals(ps,vm.getFirstName());

  }

}
