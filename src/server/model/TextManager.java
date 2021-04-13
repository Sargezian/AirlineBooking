package server.model;

import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.transferobjects.flightlist;
import shared.transferobjects.flights;
import shared.util.Subject;

import java.sql.SQLException;
import java.util.List;

public interface TextManager extends Subject {

    InputChat sendMsg(String str);
    List<InputChat> getChat();
    InputUser username(String txt);
    List<InputUser> getUser();

    List<flights> getflights();

    List<flightlist> getflightlist();



}


