package client.views.chat;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.Loginbox.loginViewModel;
import client.views.ViewController;
import client.views.createUser.createUserViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;

public class chatViewController implements ViewController {

    @FXML private TableView<InputChat> tableView;
    @FXML private TableView<InputUser> tableView1;
    @FXML private TextField requestField;
    @FXML public TableColumn<String, InputChat> inputColumn;
    @FXML public TableColumn<String, InputChat> chatcolumn;

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
        tableView.setItems(vm.getChats());
        tableView1.setItems(vm.getUsers());
        inputColumn.setCellValueFactory(new PropertyValueFactory<>("input"));
        chatcolumn.setCellValueFactory(new PropertyValueFactory<>("output"));
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
}