package client.views.chat;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.createUser.createUserViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.InputChat;
import shared.transferobjects.Rating;

public class chatViewController implements ViewController {

    //barChart
    @FXML public BarChart barChart;

    //total reviews
    @FXML public Label TotalReviews;

    //starList
    @FXML public ComboBox starList;

    @FXML public Label AverageReviews;

    //errorlabel
    @FXML public Label errorRating;

    //ChatTabellen
    @FXML private TableView<InputChat> tableView;
    @FXML private TextField requestField;
    @FXML public TableColumn<String, InputChat> inputColumn;


    private chatViewModel vm;
    private createUserViewModel cuv;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;

        cuv = vmf.getcreateUserViewModel();
        vm = vmf.getchatViewModel();
        vm.loadLogs();
        vm.loadLogs2();
        vm.loadRatings();

        tableView.setItems(vm.getChats());
        inputColumn.setCellValueFactory(new PropertyValueFactory<>("chat"));

        TotalReviews.textProperty().bind(vm.totalReviewsProperty());
        AverageReviews.textProperty().bind(vm.averageProperty());

        requestField.textProperty().bindBidirectional(vm.getChat());
        errorRating.textProperty().bind(vm.errorProperty());

        vm.setUser(vmf.getcreateUserViewModel().createUserProperty().getValue());
        vm.setCounter();
        vm.setAverage();

        starList.setItems(vm.getRatings());

    }

    @FXML
    private void onSubmitButton() {

        vm.chatPrint((Rating) starList.getSelectionModel().getSelectedItem());

    }

    public void OnLogin(ActionEvent actionEvent) {
       //
    }

    public void onFlights(ActionEvent actionEvent) {
        vh.openToMyFlightPlan();
    }





    public void onBackDashboard(ActionEvent actionEvent) {
    }
}