package server.model.database;

import shared.transferobjects.Airport;
import shared.transferobjects.Flights;

import java.util.List;

public interface AirportDao
{
  Airport CreateAirport(String AirportID,String AirportName, String Airportcity);
  List<Airport> getAirport();
}
