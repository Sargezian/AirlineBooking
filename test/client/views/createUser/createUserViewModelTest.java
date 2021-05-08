package client.views.createUser;

import client.model.ClientText;
import client.model.ClientTextManager;
import client.network.RMIClient;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.InputUserDao;
import server.model.database.InputUserImpl;
import shared.transferobjects.InputUser;

import static org.junit.jupiter.api.Assertions.*;

class createUserViewModelTest
{
  private createUserViewModel vm;
  private InputUserDao inputUserDao;

  @BeforeEach
  public void setup(){
    InputUserImpl model = InputUserImpl.getInstance();
    model.createUser("Mark","12345677");
   // vm = new createUserViewModel(new ClientTextManager(new RMIClient()));

  }

/*  @Test
  public void testCreateUser(){
//Det vi vil teste her er om vi kan add en user til vores database
InputUser user = null;
InputUserDao userDao = new InputUserImpl();
userDao.createUser("Mark","12345678");

assertEquals("mark",userDao.readUser(testCreateUser()));

  }*/
}