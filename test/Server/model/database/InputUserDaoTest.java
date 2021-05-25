package Server.model.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.InputUserDao;
import server.model.database.InputUserImpl;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import shared.transferobjects.InputUser;

import static org.junit.jupiter.api.Assertions.*;

class InputUserDaoTest {

    private InputUserDao inputUserDao;
    private ResetDao resetDao;


    @BeforeEach
    public void setUp()  {
        inputUserDao = InputUserImpl.getInstance();
        resetDao = new ResetImpl();
        resetDao.reset();

    }

    @Test
    public void TestIfWeHaveNoUsersInInputUserdao(){
        assertTrue(inputUserDao.readUser().isEmpty());

    }



    @Test
    public void TestIfWeCanCreateAUserInInputUserdao(){

        InputUser inputUser = new InputUser(1,"bob","bob1234");

        inputUserDao.createUser(inputUser.getOutput(), inputUser.getPassword());


        assertEquals("bob",inputUserDao.readUser().get(0).getOutput());

    }


    @Test

    public void TestIfWeCanReadFromInputUserDao(){

        InputUser inputUser1 = new InputUser(1,"bob","bob1234");

        inputUserDao.createUser(inputUser1.getOutput(), inputUser1.getPassword());

        assertTrue(inputUserDao.readUser().toString().contains("bob"));



    }












}