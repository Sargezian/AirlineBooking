package client.model;

import org.junit.Test;
import shared.transferobjects.*;
import static org.junit.jupiter.api.Assertions.*;

public class SaveInfoTest
{

    @Test // vi har testet singleton//
    public void testSingletonIfNull()
    {

        SaveInfo.getInstance().setFlights(null);

        Flights flights = SaveInfo.getInstance().getFlights();

        assertNull(flights);

    }
    //  On boundary
    @Test public void TestSingletonIfNotNull()
    {

        SaveInfo.getInstance().setFlights(new Flights("flightID", "flightName",
            new Depature(1, "departure", "depatureDate"),
            new Arrival(1, "arrival", "arrivaldate"),
            new PlaneType(1, "planeType"), "price"));
        Flights flights = SaveInfo.getInstance().getFlights();
        Flights flight = new Flights("flightID", "flightName",
            new Depature(1, "departure", "depatureDate"),
            new Arrival(1, "arrival", "arrivaldate"),
            new PlaneType(1, "planeType"), "price");

        assertEquals(flights.toString(), flight.toString());
    }
}