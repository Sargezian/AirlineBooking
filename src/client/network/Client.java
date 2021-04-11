package client.network;

import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.util.Subject;

import java.util.List;

public interface Client extends Subject {

    InputChat sendMsg(String str);
    List<InputChat> getChat();
    InputUser username(String txt);
    List<InputUser> getUser();
    void startClient();
}
