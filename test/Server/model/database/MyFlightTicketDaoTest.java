package Server.model.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.FlightDao;
import server.model.database.InputUserDao;
import server.model.database.MyFlightTicketDao;
import server.model.database.MyFlightTicketImpl;
import server.model.database.PassengerDao;
import server.model.database.SeatDao;
import server.model.database.ResetDao;
import server.model.database.InputUserImpl;
import server.model.database.FlightImpl;
import server.model.database.PassengerImpl;
import server.model.database.SeatImpl;
import server.model.database.ResetImpl;




import shared.transferobjects.*;

import static org.junit.jupiter.api.Assertions.*;

class MyFlightTicketDaoTest {

    private MyFlightTicketDao myFlightTicketDao;
    private InputUserDao loginDao;
    private FlightDao flightDao;
    private PassengerDao passengerDao;
    private SeatDao seatDao;
    private ResetDao resetDao;


    @BeforeEach
    public void setUp()  {
        myFlightTicketDao = MyFlightTicketImpl.getInstance();
        loginDao = InputUserImpl.getInstance();
        flightDao = FlightImpl.getInstance();
        passengerDao = PassengerImpl.getInstance();
        seatDao = SeatImpl.getInstance();
        resetDao = new ResetImpl();
        resetDao.reset();

    }


    @Test
    public void TestIfMyFlightTicketIsEmpty(){
        assertTrue(myFlightTicketDao.ReadFlightList(1).isEmpty());
    }


    @Test
    public void TestIfWeCanCreateAndReadMyFlightTicket(){

        InputUser inputuser = new InputUser(1,"Username", "password");

        Flights flights = new Flights("1", "sas", new Depature(1, "KBH", "2021-08-08 19:30:00"), new Arrival(1, "AAR", "2021-09-08 19:30:00")
                , new PlaneType(1, "Airbus7"), "200");

        Passenger passenger = new Passenger(1, "bob", "bib", "3232323", "bobbib@gmail.com");

        Seat seat = new Seat(1, "22", "Business class");

        myFlightTicket myFlightTicket1 = new myFlightTicket(String.valueOf(1), new Passenger(passenger.getPassengerID(), passenger.getFirstName(), passenger.getLastName(), passenger.getTelNumber(), passenger.getEmail()),
                new Flights(flights.getFlightID(), flights.getFlightName(), new Depature(flights.getDepartureID(), flights.getDepartures(), flights.getDepartureDate()), new Arrival(flights.getArrivalID(), flights.getArrivals(), flights.getArrivalDate()),
                        new PlaneType(flights.getPlaneId(), flights.getPlaneTypes()), flights.getPrice()), new Seat(seat.getSeatID(), seat.getSeatNumber(), seat.getClassType()), new InputUser(inputuser.getId(), inputuser.getOutput(), inputuser.getPassword()));


        loginDao.createUser(inputuser.getOutput(),inputuser.getPassword());
        passengerDao.CreatePassengers(passenger.getFirstName(),passenger.getLastName(),passenger.getTelNumber(),passenger.getEmail());
        seatDao.CreateSeat(seat.getSeatNumber(),seat.getClassType());
        flightDao.CreateFlights(flights.getFlightID(),flights.getFlightName(),flights.getPrice(),flights.getArrivalID(),flights.getDepartureID(),flights.getPlaneId());


        myFlightTicketDao.createTicket(myFlightTicket1);


        assertEquals("Username",myFlightTicketDao.ReadFlightList(1).get(0).getUser().getOutput());


    }




}