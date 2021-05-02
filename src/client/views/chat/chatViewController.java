package client.views.chat;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.Loginbox.loginViewModel;
import client.views.ViewController;
import client.views.createUser.createUserViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;

public class chatViewController implements ViewController {

    //barChart
    @FXML public BarChart barChart;

    //ChatTabellen
    @FXML private TableView<InputChat> tableView;
    @FXML private TextField requestField;
    @FXML public TableColumn<String, InputChat> inputColumn;

    private XYChart.Data<String, Integer> STAR_1 = new XYChart.Data<String, Integer>("STAR_1", 0);
    private XYChart.Data<String, Integer> STAR_2 = new XYChart.Data<String, Integer>("STAR_2", 0);
    private XYChart.Data<String, Integer> STAR_3 = new XYChart.Data<String, Integer>("STAR_3", 0);
    private XYChart.Data<String, Integer> STAR_4 = new XYChart.Data<String, Integer>("STAR_4", 0);
    private XYChart.Data<String, Integer> STAR_5 = new XYChart.Data<String, Integer>("STAR_5", 0);


    private chatViewModel vm;
    private createUserViewModel cuv;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;

        STAR_1.YValueProperty().bind(vm.STAR_1Property());
        STAR_2.YValueProperty().bind(vm.STAR_2Property());
        STAR_3.YValueProperty().bind(vm.STAR_3Property());
        STAR_4.YValueProperty().bind(vm.STAR_4Property());
        STAR_5.YValueProperty().bind(vm.STAR_5Property());

        cuv = vmf.getcreateUserViewModel();
        vm = vmf.getchatViewModel();
        vm.loadLogs();
        vm.loadLogs2();
        tableView.setItems(vm.getChats());
        inputColumn.setCellValueFactory(new PropertyValueFactory<>("input"));
        requestField.textProperty().bindBidirectional(vm.getRequest());
        vm.setNavn(vmf.getcreateUserViewModel().createUserProperty().getValue());
    }

    @FXML
    private void onSubmitButton() {
        vm.chatPrint();
    }

    public void onBackButton() {
        vh.openToMyFlightPlan();
    }

    public void OnLogin(ActionEvent actionEvent) {
       //
    }
}