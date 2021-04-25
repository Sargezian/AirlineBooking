package client.views.Loginbox;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class loginViewController implements ViewController {

    @FXML private TextField navn;
    @FXML private TextField kode;
    @FXML private Label error;

    private loginViewModel viewModel;
    private ViewHandler vh;

    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getloginViewModel();
    }

    public void onLogButton() {
        vh.openPaymentView();

    }

    public void onkald(ActionEvent actionEvent) {
        System.exit(1);
    }

    public void OnSignIn(ActionEvent actionEvent) {
        vh.openCreateUserView();
    }
}

