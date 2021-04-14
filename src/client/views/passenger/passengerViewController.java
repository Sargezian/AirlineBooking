package client.views.passenger;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.passenger;

public class passengerViewController implements ViewController {

    @FXML
    public TableView<passenger> tableView;
    @FXML
    public TableColumn<String, passenger> passengerIDColumn;
    @FXML
    public TableColumn<String, passenger> nameColumn;

    private ViewHandler vh;
    private passengerViewModel pv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        pv = vmf.getPassengerViewModel();
        pv.loadPassenger();
        passengerIDColumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableView.setItems(pv.getPassengers());
    }

    public void onBack(ActionEvent actionEvent) {
        vh.openSeat();
    }

}
