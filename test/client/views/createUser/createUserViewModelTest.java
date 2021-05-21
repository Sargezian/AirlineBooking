package client.views.createUser;

import org.junit.jupiter.api.BeforeEach;
import server.model.database.InputUserDao;
import server.model.database.InputUserImpl;

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