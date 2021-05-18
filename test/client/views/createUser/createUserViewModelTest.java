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
  private InputUserDao inputUserDao = InputUserImpl.getInstance();

  @BeforeEach
  public void setup(){

    inputUserDao.createUser("Mark","12345677");


  }

 @Test
  public void testCreateUser(){

       assertEquals("mark",inputUserDao.readUser());

  }
}

