package client.views.admin;

import client.model.ClientText;
import client.model.SaveInfo;

public class AirportViewmodel {

  ClientText clientText;



  public void getGetAirportInformation() {

    if (FirstName.getValue() != null && !"".equals(FirstName.getValue()) && LastName.getValue() != null && !"".equals(LastName.getValue()) && TelNumber.getValue() != null && !"".equals(TelNumber.getValue())  && Email.getValue() != null && !"".equals(Email.getValue()) && Email.getValue().contains("@")) {

      String FirstName = this.FirstName.getValue();
      String LastName = this.LastName.getValue();
      String TelNumber = this.TelNumber.getValue();
      String Email = this.Email.getValue();
      SaveInfo.getInstance().setAirport(clientText.CreateAirport());

    }

  }
}
