package Server.model.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.AirportDao;
import server.model.database.AirportImpl;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import shared.transferobjects.Airport;

import static org.junit.jupiter.api.Assertions.*;

class AirportDaoTest {

    private AirportDao airportDao;
    private ResetDao resetDao;


    @BeforeEach
    public void setUp()  {
        airportDao = AirportImpl.getInstance();
        resetDao = new ResetImpl();
        resetDao.reset();
    }


    @Test
    public void TestIfAirportsAlreadyExists(){
        assertNotNull(airportDao.getAirport());

    }

    @Test
    public void TestifWeCanCreateAndReadFromDatabase(){

        Airport airport = new Airport("1","test","test1");

        airportDao.CreateAirport(airport.getAirportID(),airport.getAirportName(),airport.getAirportCity());


        assertEquals("test",airportDao.getAirport().get(6).getAirportName());

    }











}