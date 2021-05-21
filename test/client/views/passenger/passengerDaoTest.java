package client.views.passenger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.PassengerDao;
import server.model.database.PassengerImpl;
import shared.transferobjects.Flights;
import shared.transferobjects.Passenger;
import shared.transferobjects.Seat;

import static org.junit.jupiter.api.Assertions.*;

class passengerDaoTest
{
    private PassengerDao passengerDao;

    @BeforeEach public void setup()
    {
        passengerDao = PassengerImpl.getInstance();
    }

    @Test
    public void testIfWeCanCreateAndReadFromDatabase(){

        Passenger passenger = new Passenger("hej","Hej","12345678","Mark@gmail.com");
        Passenger test = passengerDao.CreatePassengers(passenger.getFirstName(), passenger.getLastName(), passenger.getTelNumber(),passenger.getEmail());
        Passenger readpassenger = passengerDao.ReadPassenger(test.getFirstName(),
                test.getLastName(), test.getTelNumber(), test.getEmail());

        assertEquals(test.getFirstName(), readpassenger.getFirstName());
        assertEquals(test.getPassengerID(), readpassenger.getPassengerID());
        assertEquals(test.getLastName(), readpassenger.getLastName());
        assertEquals(test.getTelNumber(), readpassenger.getTelNumber());
    }

}