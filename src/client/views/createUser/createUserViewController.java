package client.views.createUser;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class createUserViewController implements ViewController {


    @FXML public TextField CreateUser;
    @FXML public PasswordField CreatePassword;
    @FXML public Label Error;

    private ViewHandler vh;
    private createUserViewModel cuv;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.cuv = vmf.getcreateUserViewModel();
        CreateUser.textProperty().bindBidirectional(cuv.createUserProperty());
        CreatePassword.textProperty().bindBidirectional(cuv.createPasswordProperty());
        Error.textProperty().bind(cuv.errorProperty());

    }

    public void onCreateLogin(ActionEvent actionEvent) {

        if (cuv.attemptCreateUser() && cuv.validatePasswords()){
            cuv.SetUser();
            vh.openLoginView();
        }



    }

    public void onCancel(ActionEvent actionEvent) {
    }


}
