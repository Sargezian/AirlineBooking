package client.views.myflightplan;

import client.model.ClientText;
import client.views.dashboard.dashboardViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.flightlist;
import java.util.List;

public class myflightplanViewModel {

    private dashboardViewModel dv;
    private ClientText clientText;
    private ObservableList<shared.transferobjects.flightlist> my;

    public myflightplanViewModel(ClientText clientText) {
        this.clientText = clientText;
    }

    public void loadMyFlights() {
        List<shared.transferobjects.flightlist> flight = clientText.getflightlist();

        my = FXCollections.observableArrayList();


        //Collections.addAll(, selectedrows);
    }

    public ObservableList<flightlist> getMy() {
        return my;
    }
}
