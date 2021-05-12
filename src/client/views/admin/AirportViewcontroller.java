package client.views.admin;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import java.rmi.RemoteException;

public class AirportViewcontroller implements ViewController
{

  @FXML
  public TextField airportId;
  @FXML
  public TextField airportName;
  @FXML
  public TextField airportCity;


  private ViewHandler vh;
  private AirportViewmodel av;

  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf) {
    this.vh = vh;
    av = vmf.getAirportviewmodel();
    airportId.textProperty().bindBidirectional(av.airportIdProperty());
    airportName.textProperty().bindBidirectional(av.airportNameProperty());
    airportCity.textProperty().bindBidirectional(av.airportCityProperty());


  }


  public void onDelete(ActionEvent actionEvent) {
vh.openAdminSeat();

  }

  public void onBack(ActionEvent actionEvent) {
    vh.openAdminSeat();
  }

  public void onLogOff(ActionEvent actionEvent) {
  }

  public void onAdd(ActionEvent actionEvent) throws RemoteException
  {
    av.InsertAirportInfomation();
    av.validateAirportInformation();

    System.out.println(av.airportCityProperty());
    System.out.println(av.airportNameProperty());
    System.out.println(av.airportIdProperty());
  }
}







