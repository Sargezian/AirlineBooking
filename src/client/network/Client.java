package client.network;

import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.util.Subject;

import java.util.List;

public interface Client extends Subject {

    String sendMsg(String str);
    List<InputChat> getChat();
    String username(String txt);
    List<InputUser> getUser();
    void startClient();
}
