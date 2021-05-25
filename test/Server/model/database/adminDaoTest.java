package Server.model.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import server.model.database.adminDao;
import server.model.database.adminImpl;
import shared.transferobjects.Arrival;
import shared.transferobjects.Depature;
import shared.transferobjects.Flights;
import shared.transferobjects.PlaneType;

import static org.junit.jupiter.api.Assertions.*;

class adminDaoTest {

    private adminDao adminDao;
    private ResetDao resetDao;


    @BeforeEach
    public void setUp()  {
        adminDao = adminImpl.getInstance();
        resetDao = new ResetImpl();
        resetDao.reset();

    }

    @Test
    public void TestIfAdminDaoIsNotEmpty(){
        assertNotNull(adminDao.getAllArrival());
        assertNotNull(adminDao.getAllDeparture());
        assertNotNull(adminDao.getAllPlaneType());
        assertNotNull(adminDao.getAllTheFLights());
    }


    @Test
    public void TestIfWeCanCreateAndReadInAdminDao(){

        Flights flights = new Flights("1", "sas","200");

        Depature depature = new Depature(1, "KBH", "2021-08-08 19:30:00");

        Arrival arrival = new Arrival(1, "AAR", "2021-09-08 19:30:00");

        PlaneType planeType = new PlaneType(1, "Airbus7");


        adminDao.CreateDeparture(depature.getDeparture(),depature.getDepartureDate());
        adminDao.CreateArrival(arrival.getArrival(),arrival.getArrivalDate());

        adminDao.CreatePlane(planeType.getPlaneType());
        adminDao.CreateFlights(flights.getFlightID(),flights.getFlightName(),flights.getPrice());

        assertEquals("KBH",adminDao.getAllDeparture().get(6).getDeparture());
        assertEquals("AAR",adminDao.getAllArrival().get(6).getArrival());
        assertEquals("Airbus7",adminDao.getAllPlaneType().get(6).getPlaneType());
        assertEquals("sas",adminDao.getAllTheFLights().get(6).getFlightName());

    }















}