package server.model.database;

import shared.transferobjects.*;

import java.util.List;


public interface FlightDao
{

  List<Flights> getflights();

  List<Flights> readByName(String searchString);

  List<Flights> updateFlight(Flights flights);



}
