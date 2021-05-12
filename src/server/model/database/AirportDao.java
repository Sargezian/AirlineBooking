package server.model.database;

import shared.transferobjects.Airport;
import shared.transferobjects.Flights;

public interface AirportDao
{
  Airport CreateAirport(String AirportID,String AirportName, String Airportcity);
}
