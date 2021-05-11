package client.views.chat;

import org.junit.jupiter.api.Test;
import shared.transferobjects.InputChat;
import shared.transferobjects.Rating;

import static org.junit.jupiter.api.Assertions.*;

// TODO: 08/05/2021 lave test færdig (alle)

class chatViewModelTest
{

  @Test
  public void setCounter()
  {
    //  Arrange
    Rating rating = new Rating(5.0);
    //  Act
    //  Assert
    assertEquals(5.0,rating.toString());

  }

  @Test void setAverage()
  {
  }

  @Test void chatPrint()
  {
  }

  @Test void loadLogs()
  {
  }

  @Test void loadLogs2()
  {
  }

  @Test void loadRatings()
  {
  }

  @Test void getChats()
  {
  }

  @Test void getUsers()
  {
  }

  @Test void getChat()
  {
  }

  @Test void setUser()
  {
  }

  @Test void onNewInputChat()
  {
  }

  @Test void onNewInputUser()
  {
  }

  @Test void getTotalReviews()
  {
  }

  @Test void totalReviewsProperty()
  {
  }

  @Test void getRatings()
  {
  }

  @Test void getAverage()
  {
  }

  @Test void averageProperty()
  {
  }

  @Test void getError()
  {
  }

  @Test void errorProperty()
  {
  }

  @Test void getSeries()
  {
  }

  @Test void getProgressbar()
  {
  }

  @Test void progressbarProperty()
  {
  }
}