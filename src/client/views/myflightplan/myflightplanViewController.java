package client.views.myflightplan;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.Loginbox.loginViewModel;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class myflightplanViewController implements ViewController {

    private Label myName;

    private myflightplanViewModel viewModel;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        viewModel = vmf.getmyflightplanViewModel();
    }

    public void onBackDashboard(ActionEvent actionEvent) {
        vh.openToDashView();

    }

    public void onChat(ActionEvent actionEvent) {
        vh.openToChatView();

    }
}
