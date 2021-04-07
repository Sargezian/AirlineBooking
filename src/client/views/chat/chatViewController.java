package client.views.chat;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.Loginbox.loginViewModel;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;

public class chatViewController implements ViewController {

    private chatViewModel vm;
    private loginViewModel lv;
    private ViewHandler vh;

    @FXML
    private TableView<InputChat> tableView;
    @FXML
    private TableView<InputUser> tableView1;
    @FXML
    private TextField requestField;

    public TableColumn<String, InputChat> inputColumn; // username
    public TableColumn<String, InputChat> chatcolumn; // chat

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        lv = vmf.getloginViewModel();
        vm = vmf.getchatViewModel();
        vm.loadLogs();
        vm.loadLogs2();
        tableView.setItems(vm.getChats());
        tableView1.setItems(vm.getUsers());
        inputColumn.setCellValueFactory(new PropertyValueFactory<>("input"));
        chatcolumn.setCellValueFactory(new PropertyValueFactory<>("output"));
        requestField.textProperty().bindBidirectional(vm.getRequest());
        vm.setNavn(vmf.getloginViewModel().navnProperty().getValue());
    }

    @FXML
    private void onSubmitButton() {
        vm.chatPrint();
    }

    public void onBackButton() {
        vh.openToMyFlightPlan();
    }
}