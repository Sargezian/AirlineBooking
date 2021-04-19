package client.views.passenger;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.Myflightlist;
import shared.transferobjects.flights;
import shared.transferobjects.passenger;
import shared.transferobjects.seat;

public class passengerViewController implements ViewController {
    @FXML
    public TextField FirstName;
    @FXML
    public TextField LastName;
    @FXML
    public TextField TelNumber;


  private ViewHandler vh;
    private passengerViewModel pv;
    private Myflightlist myflightlist;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        pv = vmf.getPassengerViewModel();
      FirstName.textProperty().bindBidirectional(pv.firstNameProperty());
      LastName.textProperty().bindBidirectional(pv.lastNameProperty());
      TelNumber.textProperty().bindBidirectional(pv.telNumberProperty());
        /*pv.loadPassenger();
        *//*passengerIDColumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));*//*

        tableView.setItems(pv.getPassengers());*/
    }

    public void onBack(ActionEvent actionEvent) {
        vh.openSeat();

    }

    public void onOrder(ActionEvent actionEvent) {
        pv.getPassengerInformation();
      System.out.println();
        pv.finish();

    }


}
