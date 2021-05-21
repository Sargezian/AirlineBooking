package shared.transferobjects;

import java.io.Serializable;

public class Airport implements Serializable {

    // TODO: 08/05/2021 fjerne metoder vi ikke bruger og ændre metodenavne til det rigtige (alle)

    private String AirportID;
    private String AirportName;
    private String AirportCity;

    public Airport(String AirportID, String AirportName, String AirportCity) {
        this.AirportID = AirportID;
        this.AirportName = AirportName;
        this.AirportCity = AirportCity;
    }

  @Override public String toString()
  {
    return "Airport{" + "AirportID='" + AirportID + '\'' + ", AirportName='"
        + AirportName + '\'' + ", AirportCity='" + AirportCity + '\'' + '}';
  }

  public String getAirportID()
  {
    return AirportID;
  }

  public void setAirportID(String airportID)
  {
    AirportID = airportID;
  }

  public String getAirportName()
  {
    return AirportName;
  }

  public void setAirportName(String airportName)
  {
    AirportName = airportName;
  }

  public String getAirportCity()
  {
    return AirportCity;
  }

  public void setAirportCity(String airportCity)
  {
    AirportCity = airportCity;
  }
}
