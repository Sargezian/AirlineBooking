package Server.model.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import server.model.database.SeatDao;
import server.model.database.SeatImpl;
import shared.transferobjects.PlaneType;
import shared.transferobjects.Seat;

import static org.junit.jupiter.api.Assertions.*;

class SeatDaoTest {


    private SeatDao seatDao;
    private ResetDao resetDao;


    @BeforeEach
    public void setUp()  {
        seatDao = SeatImpl.getInstance();
        resetDao = new ResetImpl();
        resetDao.reset();

    }

    @Test
    public void TestIfSeatsAlreadyExists(){
        assertNotNull(seatDao.getSeats());
    }

    @Test
    public void TestIfWeCanCreateAndReadSeat(){

        Seat seat = new Seat(55,"b80","Economy class",new PlaneType(1,"airbus"));

        seatDao.CreateSeat(seat.getSeatNumber(),seat.getClassType());


        assertEquals("b80",seatDao.getSeat(1).get(9).getSeatNumber());


    }






}