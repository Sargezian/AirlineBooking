package client.views.myflightplan;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.dashboard.dashboardViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.flights;

public class myflightplanViewController implements ViewController {

    @FXML
    public TableView<flights> myflighttableview;
    @FXML
    public TableColumn<String, flights> myflightColumn;
    @FXML
    public TableColumn<String, flights> myseatsColumn;

    @FXML
    private Label myName;

    private myflightplanViewModel vm;
    private ViewHandler vh;
    private dashboardViewModel dv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getmyflightplanViewModel();
        dv = vmf.getdashboardViewModel();
        vm.loadMyFlights();
        myflightColumn.setCellValueFactory(new PropertyValueFactory<>("dummy"));
        myseatsColumn.setCellValueFactory(new PropertyValueFactory<>("seats"));
        myflighttableview.setItems(dv.getflight());

    }

    public void onBackDashboard(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onChat(ActionEvent actionEvent) {
        vh.openToChatView();
    }
}
