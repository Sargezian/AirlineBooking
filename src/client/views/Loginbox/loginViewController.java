package client.views.Loginbox;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.SaveInfo;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import shared.transferobjects.Flights;
import shared.transferobjects.Seat;

public class loginViewController implements ViewController {

    @FXML private TextField navn;
    @FXML private TextField kode;
    @FXML private Label error;

    private loginViewModel viewModel;
    private ViewHandler vh;

    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getloginViewModel();
        navn.textProperty().bindBidirectional(viewModel.navnProperty());
        kode.textProperty().bindBidirectional(viewModel.kodeProperty());
        error.textProperty().bind(viewModel.errorProperty());

    }

    public void onLogButton()
    {
        viewModel.validateAdmin();
        vh.openAdminView();
        System.out.println("åben admin");


        System.out.println("Her ser vi om Getflights bliver sat eller om den altid forbliver null:  " + SaveInfo.getInstance().getFlights());
        if (viewModel.validateLoginInfo())
        {

            if (SaveInfo.getInstance().getFlights() != null)
            {

                vh.openPaymentView();

                viewModel.createTicket();
                SaveInfo.getInstance().reset();
                viewModel.clearFields();

            }
            else
            {
                vh.openToMyFlightPlan();

            }

        }

    }


    public void onkald(ActionEvent actionEvent) {

    }

    public void OnSignIn(ActionEvent actionEvent) {
        vh.openCreateUserView();

    }










}

