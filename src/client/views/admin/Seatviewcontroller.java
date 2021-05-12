package client.views.admin;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;

public class Seatviewcontroller implements ViewController
{



  @FXML
  public TextField seatNumber;
  @FXML
  public TextField classType;


private ViewHandler vh;
private Seatviewmodel av;

@Override
public void init(ViewHandler vh, ViewModelFactory vmf) {
    this.vh = vh;
    av = vmf.getSeatViewModel();
    seatNumber.textProperty().bindBidirectional(av.seatNumberProperty());
    classType.textProperty().bindBidirectional(av.classTypeProperty());

    }


public void onDelete(ActionEvent actionEvent) {


    }

public void onBack(ActionEvent actionEvent) {
    vh.openToDashView();
    }

public void onLogOff(ActionEvent actionEvent) {
    }

public void onAdd(ActionEvent actionEvent) throws RemoteException
    {
    av.InsertSeatInfomation();
    System.out.println(av.seatIdProperty());
    System.out.println(av.seatNumberProperty());
    System.out.println(av.classTypeProperty());
    }

}


