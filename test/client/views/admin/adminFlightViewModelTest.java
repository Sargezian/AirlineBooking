package client.views.admin;

import client.model.ClientModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.AirportDao;
import server.model.database.AirportImpl;
import server.model.database.adminDao;
import server.model.database.adminImpl;
import shared.transferobjects.Airport;
import shared.transferobjects.Passenger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class adminFlightViewModelTest {

    private adminFlightViewController adminFlightViewController;
    private adminFlightViewModel afv;
    private adminDao ad;
    private AirportDao airportDao;
    static ClientModel clientModel;


    @BeforeEach public void setup() {
      ad = adminImpl.getInstance();
      airportDao = AirportImpl.getInstance();

    }

    @Test
    void validateFlightInformation() {
    }

    @Test
    void validateArrivalInformation() {
    }

    @Test
    void validateDepartureInformation() {
    }

    @Test
    void validatePlanetypeInformation() {
    }

    @Test
    void validateSeatInformation() {
    }

    @Test
    void validateAirportInformation() {

        Airport airport = new Airport("dd","nsu","nssa");
        //Airport createAirport = airportDao.CreateAirport(airport.getAirportID(),airport.getAirportName(),airport.getAirportCity());
        //assertEquals(airport.toString(),createAirport.toString());

        List<Airport> getAirport = airportDao.getAirport();

        assertEquals(airport.toString(), getAirport.toString());

    }
}