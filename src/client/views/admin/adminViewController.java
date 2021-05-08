package client.views.admin;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class adminViewController implements ViewController {


    @FXML public TableView FlightTableview;

    private ViewHandler vh;
    private adminViewModel av;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        av = vmf.getadminViewModel();



    }


    public void onDelete(ActionEvent actionEvent) {
    }

    public void onBack(ActionEvent actionEvent) {
    }

    public void onLogOff(ActionEvent actionEvent) {
    }
}
