package server.model.database;

import shared.transferobjects.InputChat;
import shared.transferobjects.Rating;

import java.util.List;

public interface InputChatDao {

    InputChat createChat(String chat, double star);
    List<InputChat> readChat();

    List<Rating> getRatings();

    double AverageStars();

    int CountRatings(double star);

    int CountChat();

}
