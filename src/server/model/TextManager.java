package server.model;

import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {

    String sendMsg(String str);
    List<InputChat> getChat();
    String username(String txt);
    List<InputUser> getUser();

}


