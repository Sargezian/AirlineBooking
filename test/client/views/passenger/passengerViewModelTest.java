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
  private PassengerDao passengerDao;

  @BeforeEach public void setup()
  {
    passengerDao = new PassengerImpl();
  }

  @Test
  public void testifwecanreadfromdatabase(){


    Passenger passenger = new Passenger(1,"hej","Hej","12345678","Mark@gmail.com");
    Passenger test = passengerDao.CreatePassengers(passenger.passengerID,passenger.FirstName, passenger.LastName, passenger.TelNumber,passenger.Email);


    assertEquals(test,passengerDao.ReadPassenger(test.FirstName,
        test.LastName, test.TelNumber, test.Email));

  }

}
