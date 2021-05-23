package client.views.chat;

import client.core.ClientFactory;
import client.core.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import shared.transferobjects.Rating;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: 08/05/2021 lave test færdig (alle)

public class chatViewModelTest
{
    private chatViewModel chatViewModel;
    private ResetDao resetDao;



    @BeforeEach
    public void setUp(){
      ClientFactory.getInstance().getClient();
      chatViewModel = new chatViewModel(ModelFactory.getInstance().getClientText());
      //Database access Object is needed for various tests
      chatViewModel.loadLogs();
      chatViewModel.loadLogs2();
      chatViewModel.loadRatings();
      resetDao = new ResetImpl();
      resetDao.reset();

    }

    @Test void test_IfWeCanGetAverageStars(){
      //Her tester vi om vores Average stars virker på feedback siden.

      chatViewModel.getChat().setValue("hej");
      chatViewModel.chatPrint(new Rating(1));
      chatViewModel.getChat().setValue("hej");
      chatViewModel.chatPrint(new Rating(5));
      chatViewModel.setAverage();

      assertEquals("3.0",chatViewModel.getAverage());
    }


    @Test void test_ValidFeedback(){
        chatViewModel.getChat().setValue("Det er en test");
        chatViewModel.setUser("user");
        chatViewModel.chatPrint(new Rating(5));
        assertEquals("",chatViewModel.errorProperty().get());


    }
  @Test void test_InvalidFeedbackIfNoComments(){
      chatViewModel.getChat().setValue(null);
      chatViewModel.setUser("");
      chatViewModel.chatPrint(new Rating(5));

    assertEquals("Please choose a rating", chatViewModel.errorProperty().get());


  }
  @Test void test_InvalidFeedbackIfRatingOver5(){
    chatViewModel.getChat().setValue("Mega fed rejse");
    chatViewModel.setUser("Mark");
    chatViewModel.chatPrint(new Rating(6));

    assertEquals("Please choose a rating", chatViewModel.errorProperty().get());


  }
  @Test void test_InvalidFeedbackIfRatingUnder0(){
    chatViewModel.getChat().setValue("Mega fed rejse");
    chatViewModel.setUser("Mark");
    chatViewModel.chatPrint(new Rating(-1));
    assertEquals("Please choose a rating", chatViewModel.errorProperty().get());
  }

}













