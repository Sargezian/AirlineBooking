
package client.views.admin;

import client.model.ClientText;
import client.model.SaveInfo;
import client.network.Client;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;

public class AirportViewmodel {

  private ClientText clientText;
  private StringProperty airportId;
  private StringProperty airportName;
  private StringProperty airportCity;
  private StringProperty error;



  public AirportViewmodel(ClientText clientText){
    this.clientText = clientText;
    airportId = new SimpleStringProperty();
    airportName = new SimpleStringProperty();
    airportCity = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }



  public void InsertAirportInfomation() throws RemoteException
  {

    if (airportId.getValue() != null && !"".equals(airportId.getValue()) && airportCity.getValue() != null && !"".equals(airportCity.getValue()) && airportName.getValue() != null && !"".equals(airportName.getValue()))  {

      String AirportID = this.airportId.getValue();
      String AirportName = this.airportName.getValue();
      String AirportCity = this.airportCity.getValue();
      clientText.CreateAirport(AirportID,AirportName,AirportCity);

    }

  }

  public String getAirportId()
  {
    return airportId.get();
  }

  public StringProperty airportIdProperty()
  {
    return airportId;
  }

  public void setAirportId(String airportId)
  {
    this.airportId.set(airportId);
  }

  public String getAirportName()
  {
    return airportName.get();
  }

  public StringProperty airportNameProperty()
  {
    return airportName;
  }

  public void setAirportName(String airportName)
  {
    this.airportName.set(airportName);
  }

  public String getAirportCity()
  {
    return airportCity.get();
  }

  public StringProperty airportCityProperty()
  {
    return airportCity;
  }

  public void setAirportCity(String airportCity)
  {
    this.airportCity.set(airportCity);
  }

  public String getError()
  {
    return error.get();
  }

  public StringProperty errorProperty()
  {
    return error;
  }

  public void setError(String error)
  {
    this.error.set(error);
  }

  public boolean validateAirportInformation()
  {

    if (airportId.getValue() == null)
    {
      error.set("ID cannot be empty");
      return false;
    }
    if (airportName.getValue() == null)
    {
      error.set("Airport Name cannot be empty");
      return false;
    }
    if (airportCity.getValue() == null)
    {
      error.set("Airport City cannot be empty");
      return false;
    }
    else
    {

      return true;
    }
  }

}

