package client.model;

import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.transferobjects.Myflightlist;
import shared.transferobjects.flights;
import shared.util.Subject;

import java.util.List;

public interface ClientText extends Subject {

    InputChat sendMsg(String text);
    List<InputChat> getChat();
    InputUser username(String txt);
    List<InputUser> getUser();

    List<flights> getflights();

    List<Myflightlist> getflightlist();
}


