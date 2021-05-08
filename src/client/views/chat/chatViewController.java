package client.views.chat;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.SaveInfo;
import client.views.ViewController;
import client.views.createUser.createUserViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.InputChat;
import shared.transferobjects.Rating;

public class chatViewController implements ViewController {

    //barChart
    @FXML private BarChart<String, Double> barChart;
    /*private XYChart.Data<String, Integer> x = new XYChart.Data<String, Integer>("X", 0);*/

    //total reviews
    @FXML public Label TotalReviews;

    //starList
    @FXML public ComboBox starList;

    //averageReviews
    @FXML public Label AverageReviews;
    @FXML public ProgressBar ProgressAvgBar;

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

        ProgressAvgBar.progressProperty().bind(vm.progressbarProperty());

        requestField.textProperty().bindBidirectional(vm.getChat());

        errorRating.textProperty().bind(vm.errorProperty());

        barChart.getData().add(vm.getSeries());

        vm.setUser(vmf.getloginViewModel().getNavn());
        vm.setCounter();
        vm.setAverage();
        visible();

        starList.setItems(vm.getRatings());

    }

    private void visible() {
        if(SaveInfo.getInstance().getUser() == null) {
            requestField.setVisible(false);
            errorRating.setVisible(false);
            starList.setVisible(false);
        } else {
            requestField.setVisible(true);
            errorRating.setVisible(true);
            starList.setVisible(true);
        }
    }


    @FXML
    private void onSubmitButton() {

        vm.chatPrint((Rating) starList.getSelectionModel().getSelectedItem());

        vm.setBarchart((Rating) starList.getSelectionModel().getSelectedItem());


    }



    public void onFlights(ActionEvent actionEvent) {
        vh.openToMyFlightPlan();
    }





    public void onBackDashboard(ActionEvent actionEvent) {
        vh.openToDashView();
    }
}