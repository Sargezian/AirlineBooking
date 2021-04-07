package client.views.dashboard;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;

public class dashboardViewController implements ViewController {

    private ViewHandler vh;
    private dashboardViewModel dv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        dv = vmf.getdashboardViewModel();
    }

    public void OnLogin(ActionEvent actionEvent) {
        vh.openLoginView();
    }
}
