package server.model.database;

import shared.transferobjects.*;

import java.util.List;


public interface FlightDao
{

  List<flights> getflights();

  List<flights> readByName(String searchString);

}
