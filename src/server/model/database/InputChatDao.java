package server.model.database;

import shared.transferobjects.InputChat;

import java.util.List;

public interface InputChatDao {

    InputChat createChar(String str);
    List<InputChat> readChat();

    int CountChat();

}
