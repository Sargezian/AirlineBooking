package client.views.dashboard;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.myflightplan.myflightplanViewController;
import client.views.myflightplan.myflightplanViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.flights;

public class dashboardViewController implements ViewController {

    @FXML
    public TableView<flights> tableView;
    @FXML
    public TableColumn<String, flights> flightColumn;
    @FXML
    public TableColumn<String, flights> seatColumn;

    private ViewHandler vh;
    private dashboardViewModel dv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        dv = vmf.getdashboardViewModel();
        dv.loadFlights();
        flightColumn.setCellValueFactory(new PropertyValueFactory<>("dummy"));
        seatColumn.setCellValueFactory(new PropertyValueFactory<>("seats"));
        tableView.setItems(dv.getflight());
    }

    public void OnLogin(ActionEvent actionEvent) {
        vh.openLoginView();
    }

    public void onpush(ActionEvent actionEvent) {
        dv.setSelected(tableView.getSelectionModel().getSelectedItems());
      //  dv.removeSelected();
        dv.addSelected();

    }

}
