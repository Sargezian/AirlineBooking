package client.views.Loginbox;

import client.core.ClientFactory;
import client.core.ModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.InputUserImpl;
import shared.transferobjects.InputUser;
import static org.junit.jupiter.api.Assertions.*;


  class jUnitTest{
    private loginViewModel LoginViewModel;
    private InputUserImpl loginDao;




    @BeforeEach
    public void setUp(){
        ClientFactory.getInstance().getClient();
        LoginViewModel = new loginViewModel(ModelFactory.getInstance().getClientText());
        loginDao = InputUserImpl.getInstance();

    }

    @Test public void testLoginWithCorrectLoginDetails(){

        StringProperty username = new SimpleStringProperty();
        StringProperty password = new SimpleStringProperty();
        StringProperty label = new SimpleStringProperty();
        username.bindBidirectional(LoginViewModel.navnProperty());
        password.bindBidirectional(LoginViewModel.kodeProperty());
        label.bindBidirectional(LoginViewModel.errorProperty());

        username.setValue("Username");
        password.setValue("password");


        InputUser test = new InputUser("Username","password");
        loginDao.createUser(test.user, test.password);
        LoginViewModel.validateLoginInfo();

        assertEquals("successful",label.get());
    }

    @Test public void testLoginWithWrongLoginDetails(){

        StringProperty username = new SimpleStringProperty();
        StringProperty password = new SimpleStringProperty();
        StringProperty label = new SimpleStringProperty();
        username.bindBidirectional(LoginViewModel.navnProperty());
        password.bindBidirectional(LoginViewModel.kodeProperty());
        label.bindBidirectional(LoginViewModel.errorProperty());

        username.setValue("user11");
        password.setValue("pass11");


        InputUser test = new InputUser("username","password");
        loginDao.createUser(test.user, test.password);
        LoginViewModel.validateLoginInfo();

        assertEquals("ERROR field is empty or username and password is incorrect",label.get());
    }

    @Test public void testLoginWithWrongPassword(){

        StringProperty username = new SimpleStringProperty();
        StringProperty password = new SimpleStringProperty();
        StringProperty label = new SimpleStringProperty();
        username.bindBidirectional(LoginViewModel.navnProperty());
        password.bindBidirectional(LoginViewModel.kodeProperty());
        label.bindBidirectional(LoginViewModel.errorProperty());

        username.setValue("username");
        password.setValue("password123");


        InputUser test = new InputUser("username","password");
        loginDao.createUser(test.user, test.password);
        LoginViewModel.validateLoginInfo();

        assertEquals("ERROR field is empty or username and password is incorrect",label.get());
    }



    @Test public void testLoginWithWrongUsername(){

        StringProperty username = new SimpleStringProperty();
        StringProperty password = new SimpleStringProperty();
        StringProperty label = new SimpleStringProperty();
        username.bindBidirectional(LoginViewModel.navnProperty());
        password.bindBidirectional(LoginViewModel.kodeProperty());
        label.bindBidirectional(LoginViewModel.errorProperty());

        username.setValue("user123");
        password.setValue("password");


        InputUser test = new InputUser("username","password");
        loginDao.createUser(test.user, test.password);
        LoginViewModel.validateLoginInfo();

        assertEquals("ERROR field is empty or username and password is incorrect",label.get());
    }

      @Test public void testAdminLoginWithCorrectLoginDetails(){

          StringProperty username = new SimpleStringProperty();
          StringProperty password = new SimpleStringProperty();
          StringProperty label = new SimpleStringProperty();
          username.bindBidirectional(LoginViewModel.navnProperty());
          password.bindBidirectional(LoginViewModel.kodeProperty());
          label.bindBidirectional(LoginViewModel.errorProperty());

          username.setValue("Admin");
          password.setValue("Admin123");


          InputUser test = new InputUser("Admin","Admin123");
          loginDao.createUser(test.user, test.password);
          LoginViewModel.validateAdmin();

          assertEquals("successful",label.get());
      }






}