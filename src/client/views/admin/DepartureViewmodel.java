/*
package client.views.admin;

import client.model.ClientText;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DepartureViewmodel {

  private ClientText clientText;
  private IntegerProperty DepartureId;
  private StringProperty departures;
  private StringProperty Departuredate;
  private StringProperty error;



  public DepartureViewmodel(ClientText clientText){
    this.clientText = clientText;
    DepartureId = new SimpleIntegerProperty();
    departures = new SimpleStringProperty();
    Departuredate = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }



  public void getGetAirportInformation() {

    if (DepartureId.getValue() != null && !"".equals(DepartureId.getValue()) && departures
        .getValue() != null && !"".equals(departures.getValue()) && Departuredate
        .getValue() != null && !"".equals(Departuredate.getValue()))  {

      int DepartureID = this.DepartureId.getValue();
      String Departures = this.departures.getValue();
      String Departuredate = this.Departuredate.getValue();
      clientText.CreateSeat(Departures,Departuredate);

    }

  }

  public boolean validateDepatureInformation()
  {

    if (DepartureId.getValue() == null)
    {
      error.set("ID cannot be empty");
      return false;
    }
    if (departures.getValue() == null)
    {
      error.set("Airport Name cannot be empty");
      return false;
    }
    if (Departuredate.getValue() == null)
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
*/
