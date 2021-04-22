package client.views.Payment;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;

public class paymentViewController implements ViewController {

    private ViewHandler vh;
    private paymentViewModel pv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        pv = vmf.getPaymentViewModel();

    }

    public void OnCheckOut(ActionEvent actionEvent) {
        vh.openToMyFlightPlan();

    }

}
