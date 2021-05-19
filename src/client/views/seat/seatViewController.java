package client.views.seat;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.SaveInfo;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.Seat;

public class seatViewController implements ViewController {


    //seat
    @FXML public TableView<Seat> tableView;
    @FXML public TableColumn<String, Seat> seatIDColumn;
    @FXML public TableColumn<String, Seat> seatNumberColumn;
    @FXML public TableColumn<String, Seat> classTypeColumn;

    //error label
    @FXML public Label errorlabel;

    private seatViewModel sv;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {

       this.vh = vh;
        sv = vmf.getseatViewModel();
        seatIDColumn.setCellValueFactory(new PropertyValueFactory<>("seatID"));
        seatNumberColumn.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        classTypeColumn.setCellValueFactory(new PropertyValueFactory<>("classType"));
        errorlabel.textProperty().bind(sv.errorProperty());

    }



    public void onBack(ActionEvent actionEvent) {
        SaveInfo.getInstance().reset();
        tableView.refresh();

        vh.openToDashView();
    }

    public void onNext(ActionEvent actionEvent) {
        if (sv.getSeatInformation(tableView.getSelectionModel().getSelectedItem())) {
            vh.openPassengerView();

        }

    }

    public void openLogin(ActionEvent actionEvent) {
        vh.openLoginView();
    }

  public void reloadSeats()
  {
    sv.loadSeat();
    tableView.setItems(sv.getSeat());
  }

}

