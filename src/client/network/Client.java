package client.network;

import shared.transferobjects.*;
import shared.util.Subject;

import java.util.List;

public interface Client extends Subject {

    InputChat sendMsg(String str);
    List<InputChat> getChat();
    InputUser username(String txt);
    List<InputUser> getUser();

    List<flights> getflights();

    List<seat> getSeat();

    List<Myflightlist> getflightlist();

    void startClient();



}
