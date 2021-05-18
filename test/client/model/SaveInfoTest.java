package client.model;

import org.junit.Test;
import shared.transferobjects.*;


import static org.junit.jupiter.api.Assertions.*;

public class SaveInfoTest {


    @Test // vi har testet singleton//
    public void testSingletonIfNull(){

        SaveInfo saveInfo1 = SaveInfo.getInstance();
        SaveInfo saveInfo2 = SaveInfo.getInstance();
        System.out.println("saveInfo1" + saveInfo1);
        System.out.println("saveInfo2" + saveInfo2);


        assertEquals(saveInfo1.toString(), saveInfo2.toString());

    }


    @Test
    public void TestSingletonIfNotNull(){

        SaveInfo.getInstance().setFlights(new Flights("flightID", "flightName", new Depature(1,"departure","depatureDate"),new Arrival(1,"arrival","arrivaldate"),new PlaneType(1,"planeType"),"price"));
        Flights flights = SaveInfo.getInstance().getFlights();
        Flights flight = new Flights("flightID", "flightName", new Depature(1,"departure","depatureDate"),new Arrival(1,"arrival","arrivaldate"),new PlaneType(1,"planeType"),"price");

        assertEquals(flights.toString(),flight.toString());


    }

@Test
    public void TestSingletonException(){

      //  SaveInfo.getInstance().setFlights(new Flights("flightID", "flightName","200"));
        //Flights flights = SaveInfo.getInstance().getFlights();
      //  Flights flight = new Flights("flightID", "flightName","200");

        assertThrows(NullPointerException.class,() -> SaveInfo.getInstance().getFlights());



    }




}