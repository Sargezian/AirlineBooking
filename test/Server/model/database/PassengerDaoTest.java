package Server.model.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.PassengerDao;
import server.model.database.PassengerImpl;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import shared.transferobjects.Passenger;

import static org.junit.jupiter.api.Assertions.*;

class PassengerDaoTest {


    private PassengerDao passengerDao;
    private ResetDao resetDao;


    @BeforeEach
    public void setUp()  {
        passengerDao = PassengerImpl.getInstance();
        resetDao = new ResetImpl();
        resetDao.reset();

    }


    @Test
    public void TestIfPassengerIsEmpty() {
        assertTrue(passengerDao.ReadAllThePassengers().isEmpty());
    }

    @Test
    public void TestIfWeCanCreateAndReadAPassenger(){

        Passenger passenger = new Passenger(1,"bob","bib","87465362","bob123@gmail.com");

        passengerDao.CreatePassengers(passenger.getFirstName(),passenger.getLastName(),passenger.getTelNumber(),passenger.getEmail());

        assertEquals("bob",passengerDao.ReadAllThePassengers().get(0).getFirstName());


    }




}