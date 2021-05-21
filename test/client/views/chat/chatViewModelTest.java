package client.views.chat;

import client.core.ClientFactory;
import client.core.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.*;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.transferobjects.Rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

// TODO: 08/05/2021 lave test færdig (alle)

public class chatViewModelTest
{
    private chatViewModel chatViewModel;
    private InputChatImpl Chatimpl;
    private InputChatDao InputChatDao;
    private ResetDao resetDao;



    @BeforeEach
    public void setUp(){
      ClientFactory.getInstance().getClient();
      chatViewModel = new chatViewModel(ModelFactory.getInstance().getClientText());
      //Database access Object is needed for various tests
      chatViewModel.loadLogs();
      chatViewModel.loadLogs2();
      chatViewModel.loadRatings();
      Chatimpl = InputChatImpl.getInstance();
      resetDao = new ResetImpl();
      resetDao.reset();
      chatViewModel.getChat().setValue("Det er en test");
      chatViewModel.setUser("password");
      chatViewModel.chatPrint(new Rating(1));
    }

    @Test void test_IfWeCanGetAverageStars(){
      //Her tester vi om vores Average stars virker på feedback siden.

      chatViewModel.getChat().setValue("hej");
      chatViewModel.chatPrint(new Rating(5));
      chatViewModel.setAverage();
      assertEquals(3.0,chatViewModel.getAverage());
    }


    @Test void test_ValidFeedback(){

      assertNull(chatViewModel.errorProperty().get());


    }
  @Test void test_InvalidFeedback(){

    chatViewModel.getChat().setValue(null);
    assertEquals("Please choose a rating", chatViewModel.errorProperty().get());


  }




}













