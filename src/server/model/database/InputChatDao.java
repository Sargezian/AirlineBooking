package server.model.database;

import shared.transferobjects.InputChat;
import shared.transferobjects.Rating;

import java.util.List;

public interface InputChatDao {

    InputChat createChat(String chat, int star);
    List<InputChat> readChat();

    List<Rating> getRatings();

    int AverageStars();


    int CountChat();

}
