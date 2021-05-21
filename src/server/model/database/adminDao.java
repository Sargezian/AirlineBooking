package server.model.database;

import shared.transferobjects.Arrival;
import shared.transferobjects.Depature;
import shared.transferobjects.Flights;
import shared.transferobjects.PlaneType;
import java.util.List;

public interface adminDao {

    Flights CreateFlights(String flightID, String flightName, String price );
    Arrival CreateArrival(String Arrival, String Arrivaldate);
    Depature CreateDeparture(String Departure, String DepartureDate);
    PlaneType CreatePlane(String PlaneTypes);

    List<Flights> getAllTheFLights();
    List<PlaneType> getAllPlaneType();
    List<Depature> getAllDeparture();
    List<Arrival> getAllArrival();

}
