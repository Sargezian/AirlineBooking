package client.views.dashboard;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
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
    public TableColumn<String, flights> flightIDColumn;
    @FXML
    public TableColumn<String, flights> flightNameColumn;
    @FXML
    public TableColumn<String, flights> departureColumn;
    @FXML
    public TableColumn <String, flights> arrivalColumn;
    @FXML
    public TableColumn <String, flights> fromColumn;
    @FXML
    public TableColumn <String, flights> toColumn;

    private ViewHandler vh;
    private dashboardViewModel dv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        dv = vmf.getdashboardViewModel();
        dv.loadFlights();
        flightIDColumn.setCellValueFactory(new PropertyValueFactory<>("flightID"));
        flightNameColumn.setCellValueFactory(new PropertyValueFactory<>("flightName"));
        departureColumn.setCellValueFactory(new PropertyValueFactory<>("departure"));
        arrivalColumn.setCellValueFactory(new PropertyValueFactory<>("Arrival"));
        fromColumn.setCellValueFactory(new PropertyValueFactory<>("From"));
        toColumn.setCellValueFactory(new PropertyValueFactory<>("To"));
        tableView.setItems(dv.getflight());
    }

    public void OnLogin(ActionEvent actionEvent) {
        vh.openLoginView();
    }

    public void onpush(ActionEvent actionEvent) {
        dv.setSelected(tableView.getSelectionModel().getSelectedItems());
        dv.removeSelected();
       // dv.addSelected();
    }

    public void onNext(ActionEvent actionEvent) {
       vh.openSeat();
        System.out.println("next"+dv.getSelectedrows());
    }
}
