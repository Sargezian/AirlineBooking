package client.views.admin;

import client.model.ClientText;
import client.model.SaveInfo;

public class Arrivalviewmodel {


  ClientText clientText;

  public void getGetArrivalInformation() {

    if (FirstName.getValue() != null && !"".equals(FirstName.getValue()) && LastName.getValue() != null && !"".equals(LastName.getValue()) && TelNumber.getValue() != null && !"".equals(TelNumber.getValue())  && Email.getValue() != null && !"".equals(Email.getValue()) && Email.getValue().contains("@")) {

      String FirstName = this.FirstName.getValue();
      String LastName = this.LastName.getValue();
      String TelNumber = this.TelNumber.getValue();
      SaveInfo.getInstance().setArrival(clientText.CreateArrival());

    }

  }
}
