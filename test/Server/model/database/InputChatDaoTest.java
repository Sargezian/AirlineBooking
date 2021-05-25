package Server.model.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.InputChatDao;
import server.model.database.InputChatImpl;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import shared.transferobjects.InputChat;
import shared.transferobjects.Rating;

import static org.junit.jupiter.api.Assertions.*;

class InputChatDaoTest {

    private InputChatDao inputChatDao;
    private ResetDao resetDao;


    @BeforeEach
    public void setUp()  {
        inputChatDao = InputChatImpl.getInstance();
        resetDao = new ResetImpl();
        resetDao.reset();

    }


    @Test
    public void testIfInputChatIsEmpty(){
        assertTrue(inputChatDao.readChat().isEmpty());
    }


    @Test
    public void TestIfWeCanCreateAChatWithARatingInInputChat(){

        InputChat inputChat = new InputChat("test test",new Rating(5));

      inputChatDao.createChat(inputChat.getChat(), inputChat.getStar());

        assertEquals("test test",inputChatDao.readChat().get(0).getChat());

    }


    @Test
    public void TestAVGFromInputChat(){

        InputChat inputChat = new InputChat("test1 test1",new Rating(3));
        InputChat inputChat1 = new InputChat("test2 test2",new Rating(2));
        InputChat inputChat2 = new InputChat("test3 test3",new Rating(5));

        inputChatDao.createChat(inputChat.getChat(), inputChat.getStar());
        inputChatDao.createChat(inputChat1.getChat(), inputChat1.getStar());
        inputChatDao.createChat(inputChat2.getChat(), inputChat2.getStar());

        double AVG= inputChatDao.AverageStars();

        assertEquals(3.3333333333333335,AVG);
    }


    @Test
    public void TestIfWeCanCountChat(){
        InputChat inputChat = new InputChat("test1 test1",new Rating(3));
        InputChat inputChat1 = new InputChat("test2 test2",new Rating(2));
        InputChat inputChat2 = new InputChat("test3 test3",new Rating(5));

        inputChatDao.createChat(inputChat.getChat(), inputChat.getStar());
        inputChatDao.createChat(inputChat1.getChat(), inputChat1.getStar());
        inputChatDao.createChat(inputChat2.getChat(), inputChat2.getStar());

        int countChat = inputChatDao.CountChat();


        assertEquals(3,countChat);

    }


    @Test
    public void TestIfWeCanCountRating(){
        InputChat inputChat = new InputChat("test1 test1",new Rating(3));


        inputChatDao.createChat(inputChat.getChat(), inputChat.getStar());


        double countRatings = inputChatDao.CountRatings(inputChat.getStar());


        assertEquals(1.0,countRatings);

    }



}