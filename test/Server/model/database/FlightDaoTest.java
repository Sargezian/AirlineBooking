package Server.model.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.transferobjects.Arrival;
import shared.transferobjects.Depature;
import shared.transferobjects.Flights;
import shared.transferobjects.PlaneType;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import server.model.database.adminDao;
import server.model.database.adminImpl;
import server.model.database.FlightDao;
import server.model.database.FlightImpl;



import static org.junit.jupiter.api.Assertions.*;

class FlightDaoTest {


    private FlightDao flightDao;
    private ResetDao resetDao;


    @BeforeEach
    public void setUp()  {
        flightDao = FlightImpl.getInstance();
        resetDao = new ResetImpl();
        resetDao.reset();

    }

    @Test
    public void TestIfFlightsAlreadyExistsInFlightDao(){
      assertNotNull(flightDao.getflights());

    }


    @Test
    public void TestIfWeCanCreateANewFlightInFlightDao(){

        Flights flights = new Flights("te1","test",new Depature(1,"KBH","2021-08-08 19:30:00"),new Arrival(1,"AAR","2021-09-08 19:30:00")
                ,new PlaneType(1,"Airbus7"),"200");

        flightDao.CreateFlights(flights.getFlightID(),flights.getFlightName(),flights.getPrice(),flights.getArrivalID(),flights.getDepartureID(),flights.getPlaneId());


        assertEquals("te1",flightDao.getflights().get(6).getFlightID());


    }


    @Test
    public void TestReadBySeachStringInFlightDao(){
        Flights flights = new Flights("te1","test",new Depature(1,"KBH","2021-08-08 19:30:00"),new Arrival(1,"AAR","2021-09-08 19:30:00")
                ,new PlaneType(1,"Airbus7"),"200");


        flightDao.CreateFlights(flights.getFlightID(),flights.getFlightName(),flights.getPrice(),flights.getArrivalID(),flights.getDepartureID(),flights.getPlaneId());
        assertEquals("te1",flightDao.readByName("test").get(0).getFlightID());


    }







}