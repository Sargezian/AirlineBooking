package client.views.Loginbox;

import client.core.ClientFactory;
import client.core.ModelFactory;
import client.core.ViewModelFactory;
import client.model.ClientModel;
import client.network.Client;
import client.views.createUser.createUserViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.InputUserDao;
import server.model.database.InputUserImpl;
import shared.transferobjects.InputUser;

import static org.junit.jupiter.api.Assertions.*;


class  jUnitTest{
    private loginViewModel LoginViewModel;
    private InputUserImpl loginDao;
    private InputUserDao InputUserDao;
    private createUserViewModel createUserViewModel;



    @BeforeEach
    public void setUp(){
        ClientFactory.getInstance().getClient();
        LoginViewModel = new loginViewModel(ModelFactory.getInstance().getClientText());
        //Database access Object is needed for various tests
        loginDao = InputUserImpl.getInstance();

    }

    @Test void test_validateLoginSuccess(){

        StringProperty username = new SimpleStringProperty();
        StringProperty password = new SimpleStringProperty();
        StringProperty label = new SimpleStringProperty();
        username.bindBidirectional(LoginViewModel.navnProperty());
        password.bindBidirectional(LoginViewModel.kodeProperty());
        label.bindBidirectional(LoginViewModel.errorProperty());

        username.setValue("Username");
        password.setValue("password");

        //We need a USer in the database
        InputUser test = new InputUser("username","password");
        loginDao.createUser(test.user, test.password);
        LoginViewModel.validateLoginInfo();

        assertEquals("",label.get());
    }

    @Test void test_validatefailed(){

        StringProperty username = new SimpleStringProperty();
        StringProperty password = new SimpleStringProperty();
        StringProperty label = new SimpleStringProperty();
        username.bindBidirectional(LoginViewModel.navnProperty());
        password.bindBidirectional(LoginViewModel.kodeProperty());
        label.bindBidirectional(LoginViewModel.errorProperty());

        username.setValue("Username");
        password.setValue("password");

        //We need a USer in the database
        InputUser test = new InputUser("username","password");
        loginDao.createUser(test.user, test.password);
        LoginViewModel.validateLoginInfo();

        //assertEquals(",label.get());
    }

}