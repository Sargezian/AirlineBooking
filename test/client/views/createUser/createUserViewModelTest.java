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

  @Test
  public void testuser(){

    InputUser user = new InputUser(1,"A9","First Class");
    inputUserDao.readUsername(user.password);
    System.out.println(user);

    assertEquals(user,inputUserDao.readUser());
  }
}