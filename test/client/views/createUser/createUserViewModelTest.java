package client.views.createUser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.InputUserDao;
import server.model.database.InputUserImpl;

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

