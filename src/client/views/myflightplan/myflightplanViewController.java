package client.views.myflightplan;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.dashboard.dashboardViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.flightlist;
import shared.transferobjects.flights;


public class myflightplanViewController implements ViewController {

    @FXML
    public TableView<flightlist> myflighttableview;
    @FXML
    public TableColumn<String, flightlist> myflightColumn;
    @FXML
    public TableColumn<String, flightlist> myseatsColumn;

    @FXML
    private Label myName;

    private myflightplanViewModel vm;
    private ViewHandler vh;
    private dashboardViewModel dv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getmyflightplanViewModel();
        vm.loadMyFlights();
        myflightColumn.setCellValueFactory(new PropertyValueFactory<>("pla"));
        myseatsColumn.setCellValueFactory(new PropertyValueFactory<>("plb"));
        myflighttableview.setItems(vm.getMy());
    }

    public void onBackDashboard(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onChat(ActionEvent actionEvent) {
        vh.openToChatView();
    }
}
