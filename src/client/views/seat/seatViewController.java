package client.views.seat;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import shared.transferobjects.Seat;

import java.util.ArrayList;

public class seatViewController implements ViewController {


    @FXML public TableView<Seat> tableView;
    @FXML public TableColumn<String, Seat> seatIDColumn;
    @FXML public TableColumn<String, Seat> seatNumberColumn;
    @FXML public TableColumn<String, Seat> classTypeColumn;

    @FXML public Pane paneTest;
    @FXML public Label errorlabel;


    private ArrayList<Pane> paneArrayList = new ArrayList<>();
    private ArrayList<Seat> seatArrayList;

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
        errorlabel.textProperty().bind(sv.errorProperty());
        tableView.setItems(sv.getSeat());
    }

   /* public Pane getPane(int id)
    {
        for (Pane pane : paneArrayList)
        {
            if (pane.idProperty().get().equals(id))
            {
                return pane;
            }
        }
        return null;

    }
*/




    public void onBack(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onNext(ActionEvent actionEvent) {
        if (sv.getSeatInformation(tableView.getSelectionModel().getSelectedItem())) {
            /*sv.deleteSeat(tableView.getSelectionModel().getSelectedItem());*/
            vh.openPassengerView();
            //fjerne select
        }

    }

    public void openLogin(ActionEvent actionEvent) {
        vh.openLoginView();
    }

   /* public void Setcolor(MouseEvent mouseEvent)
    {
        //sv.SetSeatId(mouseEvent);
    }
*/
}

