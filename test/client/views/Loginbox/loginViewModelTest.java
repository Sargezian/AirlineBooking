package client.views.Loginbox;

import client.core.ClientFactory;
import client.core.ModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.InputUserImpl;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import server.model.database.adminImpl;
import shared.transferobjects.InputUser;
import static org.junit.jupiter.api.Assertions.*;


  class jUnitTest{
    private loginViewModel LoginViewModel;
    private InputUserImpl loginDao;
    private adminImpl adminDao;
    private ResetDao resetDao;





      @BeforeEach
    public void setUp(){
        ClientFactory.getInstance().getClient();
        LoginViewModel = new loginViewModel(ModelFactory.getInstance().getClientText());
        loginDao = InputUserImpl.getInstance();
        adminDao = adminImpl.getInstance();
        resetDao = new ResetImpl();
        resetDao.reset();

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

        assertEquals("username or password is incorrect",label.get());
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

        assertEquals("username or password is incorrect",label.get());
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

        assertEquals("username or password is incorrect",label.get());
    }

      @Test public void testLoginWithEmptyLoginDetails(){

          StringProperty username = new SimpleStringProperty();
          StringProperty password = new SimpleStringProperty();
          StringProperty label = new SimpleStringProperty();
          username.bindBidirectional(LoginViewModel.navnProperty());
          password.bindBidirectional(LoginViewModel.kodeProperty());
          label.bindBidirectional(LoginViewModel.errorProperty());

          username.setValue(null);
          password.setValue(null);


          InputUser test = new InputUser("username","password");
          loginDao.createUser(test.user, test.password);
          LoginViewModel.validateLoginInfo();

          assertEquals("ERROR field is empty",label.get());
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