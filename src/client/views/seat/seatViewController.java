package client.views.seat;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.seat;

public class seatViewController implements ViewController {

    @FXML
    public TableView<seat> tableView;
    @FXML
    public TableColumn<String, seat> seatIDColumn;
    @FXML
    public TableColumn<String, seat> seatNumberColumn;
    @FXML
    public TableColumn<String, seat> classTypeColumn;

    private seatViewModel sv;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        sv = vmf.getseatViewModel();
        sv.loadSeat();
        seatIDColumn.setCellValueFactory(new PropertyValueFactory<>("seatID"));
        seatNumberColumn.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        classTypeColumn.setCellValueFactory(new PropertyValueFactory<>("classType"));
        tableView.setItems(sv.getSeat());
    }

    public void onBack(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onNext(ActionEvent actionEvent) {
        sv.getSeatInformation(tableView.getSelectionModel().getSelectedItem());
        vh.openPassengerView();

    }
}
