package client.views.Loginbox;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.SaveInfo;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class loginViewController implements ViewController {

    //login
    @FXML
    private TextField navn;
    @FXML
    private TextField kode;

    //error label
    @FXML
    private Label error;

    private loginViewModel viewModel;
    private ViewHandler vh;

    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getloginViewModel();

        //login
        navn.textProperty().bindBidirectional(viewModel.navnProperty());
        kode.textProperty().bindBidirectional(viewModel.kodeProperty());

        //error label
        error.textProperty().bind(viewModel.errorProperty());

    }

    public void onLogButton() {
        if (navn.getText().equals("Admin") && kode.getText().equals("Admin123")) {
            System.out.println("Tester om vi kommer i åben admin if statement");
            viewModel.validateAdmin();
            vh.openAdminView();
            viewModel.clearFields();
        } else {
            System.out.println(
                    "Her ser vi om Getflights bliver sat eller om den altid forbliver null:  "
                            + SaveInfo.getInstance().getFlights());
            if (viewModel.validateLoginInfo()) {
                if (SaveInfo.getInstance().getFlights() != null) {

                    vh.openPaymentView();

                    viewModel.clearFields();

                } else {
                    vh.openToMyFlightPlan();
                    viewModel.clearFields();

                }

            }
        }

    }

    public void OnSignIn(ActionEvent actionEvent) {
        viewModel.clearFields();
        vh.openCreateUserView();

    }

}

