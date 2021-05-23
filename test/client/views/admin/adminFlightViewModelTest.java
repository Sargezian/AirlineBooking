package client.views.admin;

import client.core.ClientFactory;
import client.core.ModelFactory;
import client.model.ClientModel;
import client.views.myflightplan.myflightplanViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.*;
import shared.transferobjects.Airport;
import shared.transferobjects.Passenger;
import shared.transferobjects.PlaneType;
import shared.transferobjects.Seat;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    }






}