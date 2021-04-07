package client.model;

import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.util.Subject;

import java.util.List;

public interface ClientText extends Subject {

    String sendMsg(String text);
    List<InputChat> getChat();
    String username(String txt);
    List<InputUser> getUser();
}


