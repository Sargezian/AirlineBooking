package client.views.myflightplan;

import client.model.ClientText;
import client.views.dashboard.dashboardViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Myflightlist;
import shared.transferobjects.flights;

import java.util.List;

public class myflightplanViewModel {

    private dashboardViewModel dv;
    private ClientText clientText;
    private ObservableList<Myflightlist> my;

    public myflightplanViewModel(ClientText clientText) {
        this.clientText = clientText;
    }

    public void loadMyFlights() {
        List<Myflightlist> flight = clientText.getflightlist();

        //my = FXCollections.observableArrayList(flight);
        //Collections.addAll(, selectedrows);
    }

    public ObservableList<Myflightlist> getMy() {
        return my;
    }
}
