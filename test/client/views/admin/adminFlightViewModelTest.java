package client.views.admin;

import client.core.ClientFactory;
import client.core.ModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import server.model.database.adminDao;
import server.model.database.adminImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class adminFlightViewModelTest {

    private adminDao adminDao;
    private adminFlightViewModel adminFlightViewModel;
    private ResetDao resetDao;

    //flight
    private StringProperty flightId;
    private StringProperty flightName;
    private StringProperty price;

    //arrival
    private StringProperty Arrivals;
    private StringProperty ArrivalDate;

    //departure
    private StringProperty Departures;
    private StringProperty DepartureDate;

    //planetype
    private StringProperty PlaneTypes;

    //seat
    private StringProperty seatNumber;
    private StringProperty classType;

    //airport
    private StringProperty airportId;
    private StringProperty airportName;
    private StringProperty airportCity;

    //error label
    private StringProperty error;

    @BeforeEach public void setup() {
        ClientFactory.getInstance().getClient();

        adminFlightViewModel = new adminFlightViewModel(ModelFactory.getInstance().getClientText());
        adminDao = adminImpl.getInstance();
        resetDao = new ResetImpl();
        resetDao.reset();

        //flight
        flightId = new SimpleStringProperty();
        flightName = new SimpleStringProperty();
        price = new SimpleStringProperty();

        //arrival
        Arrivals = new SimpleStringProperty();
        ArrivalDate = new SimpleStringProperty();

        //departure
        Departures = new SimpleStringProperty();
        DepartureDate = new SimpleStringProperty();

        //planetype
        PlaneTypes = new SimpleStringProperty();

        //seat
        seatNumber = new SimpleStringProperty();
        classType = new SimpleStringProperty();

        //airport
        airportId = new SimpleStringProperty();
        airportName = new SimpleStringProperty();
        airportCity = new SimpleStringProperty();

        //error label
        error = new SimpleStringProperty();

        //flight
        flightName.bindBidirectional(adminFlightViewModel.flightNameProperty());
        flightId.bindBidirectional(adminFlightViewModel.flightIdProperty());
        price.bindBidirectional(adminFlightViewModel.priceProperty());

        //planetype
        PlaneTypes.bindBidirectional(adminFlightViewModel.planeTypesProperty());

        //departure
        Departures.bindBidirectional(adminFlightViewModel.departuresProperty());
        DepartureDate.bindBidirectional(adminFlightViewModel.departureDateProperty());

        //arrival
        Arrivals.bindBidirectional(adminFlightViewModel.arrivalsProperty());
        ArrivalDate.bindBidirectional(adminFlightViewModel.arrivalDateProperty());

        //seat
        seatNumber.bindBidirectional(adminFlightViewModel.seatNumberProperty());
        classType.bindBidirectional(adminFlightViewModel.classTypeProperty());

        //airport
        airportId.bindBidirectional(adminFlightViewModel.airportIdProperty());
        airportName.bindBidirectional(adminFlightViewModel.airportNameProperty());
        airportCity.bindBidirectional(adminFlightViewModel.airportCityProperty());

        //error label
        error.bind(adminFlightViewModel.errorProperty());

        flightId.setValue(null);
        flightName.setValue(null);
        price.setValue(null);
        ArrivalDate.setValue(null);
        Arrivals.setValue(null);
        DepartureDate.setValue(null);
        Departures.setValue(null);
        PlaneTypes.setValue(null);
        classType.setValue(null);
        seatNumber.setValue(null);
        airportCity.setValue(null);
        airportId.setValue(null);
        airportName.setValue(null);

    }

@Test void testIfWeCanAddAemptyFlightInformation(){
    adminFlightViewModel.validate();
        assertEquals("flightID cannot be empty",error.get());
}


@Test void testInvalidClasstype(){
        classType.setValue("TEST Class");
        adminFlightViewModel.validateSeatInformation();
        assertEquals("classType must be either; Economy class, Business class or First class ",error.get());
}
    //  On boundary
@Test void testAirportIdMustbe3(){
        airportName.setValue("A6");
        airportCity.setValue("TESTBY");
        airportId.setValue("123");
        adminFlightViewModel.validateAirportInformation();
        assertNull(error.get());
}
    //  1 after boundary
    @Test void testAirportIdMustHigherThen3(){
        airportName.setValue("A6");
        airportCity.setValue("TESTBY");
        airportId.setValue("1234");
        adminFlightViewModel.validateAirportInformation();
        assertEquals("airportID must be under 3 characters",error.get());
    }

    //  On boundary
    @Test void testIfAllFeildsAreValid(){

        flightId.setValue("1");
        flightName.setValue("TestFlightName");
        price.setValue("400");
        ArrivalDate.setValue("2021-06-06 17:30:00");
        Arrivals.setValue("BIL");
        DepartureDate.setValue("2021-06-06 17:30:00");
        Departures.setValue("AAR");
        PlaneTypes.setValue("TestPlaneType");
        classType.setValue("First class");
        seatNumber.setValue("Testseatnumber");
        airportCity.setValue("testAirportCity");
        airportId.setValue("LMK");
        airportName.setValue("TestairportName");
        adminFlightViewModel.validate();
        assertNull(error.get());
    }



}