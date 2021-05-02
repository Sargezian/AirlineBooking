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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;

public class chatViewController implements ViewController {

    //barChart
    @FXML public BarChart barChart;

    @FXML public Label TotalReviews;

    //ChatTabellen
    @FXML private TableView<InputChat> tableView;
    @FXML private TextField requestField;
    @FXML public TableColumn<String, InputChat> inputColumn;

/*  private XYChart.Data<String, Integer> STAR_1 = new XYChart.Data<String, Integer>("STAR_1", 0);
    private XYChart.Data<String, Integer> STAR_2 = new XYChart.Data<String, Integer>("STAR_2", 0);
    private XYChart.Data<String, Integer> STAR_3 = new XYChart.Data<String, Integer>("STAR_3", 0);
    private XYChart.Data<String, Integer> STAR_4 = new XYChart.Data<String, Integer>("STAR_4", 0);
    private XYChart.Data<String, Integer> STAR_5 = new XYChart.Data<String, Integer>("STAR_5", 0);*/

    private chatViewModel vm;
    private createUserViewModel cuv;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;

/*        STAR_1.YValueProperty().bind(vm.STAR_1Property());
        STAR_2.YValueProperty().bind(vm.STAR_2Property());
        STAR_3.YValueProperty().bind(vm.STAR_3Property());
        STAR_4.YValueProperty().bind(vm.STAR_4Property());
        STAR_5.YValueProperty().bind(vm.STAR_5Property());

        XYChart.Series yellowSeries = new XYChart.Series();
        yellowSeries.setName("STAR_1");
        yellowSeries.getData().add(STAR_1);
        barChart.getData().add(yellowSeries);

        XYChart.Series greenSeries = new XYChart.Series();
        greenSeries.setName("STAR_2");
        greenSeries.getData().add(STAR_2);
        barChart.getData().add(greenSeries);

        XYChart.Series redSeries = new XYChart.Series();
        redSeries.setName("STAR_3");
        redSeries.getData().add(STAR_3);
        barChart.getData().add(redSeries);

        XYChart.Series blueSeries = new XYChart.Series();
        blueSeries.setName("STAR_4");
        blueSeries.getData().add(STAR_4);
        barChart.getData().add(blueSeries);

        XYChart.Series purpleSeries = new XYChart.Series();
        purpleSeries.setName("STAR_5");
        purpleSeries.getData().add(STAR_5);
        barChart.getData().add(purpleSeries);*/

        cuv = vmf.getcreateUserViewModel();
        vm = vmf.getchatViewModel();
        vm.loadLogs();
        vm.loadLogs2();
        tableView.setItems(vm.getChats());
        inputColumn.setCellValueFactory(new PropertyValueFactory<>("input"));
        TotalReviews.textProperty().bind(vm.totalReviewsProperty());
        requestField.textProperty().bindBidirectional(vm.getRequest());
        vm.setNavn(vmf.getcreateUserViewModel().createUserProperty().getValue());
        vm.setCounter();
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