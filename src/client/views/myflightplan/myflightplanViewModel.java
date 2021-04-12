package client.views.myflightplan;

import client.model.ClientText;
import client.views.dashboard.dashboardViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.flights;

import java.util.ArrayList;
import java.util.List;

public class myflightplanViewModel {

    private dashboardViewModel dv;
    private ClientText clientText;

    //private ObservableList<String> myflight = new ArrayList<>();

    public myflightplanViewModel(ClientText clientText) {
        this.clientText = clientText;
    }

    public void loadMyFlights() {

         myflight = FXCollections.observableArrayList();
    }

    public ObservableList<flights> getMyflight() {
        return myflight;
    }
}
