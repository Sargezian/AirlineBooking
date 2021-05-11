package server.model.database;

import shared.transferobjects.*;

import java.util.List;


public interface FlightDao
{

  List<Flights> getflights();

  List<Flights> readByName(String searchString);

  Flights CreateFlights(String flightID, String flightName, String price );

  void deleteFlight(Flights flights);

  List<Flights> getAllTheFLights();

}
