package server.model;

import server.model.database.daoImpl;
import server.model.database.daoInterface;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.transferobjects.flights;
import shared.util.utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TextManagerImpl implements TextManager{

    private PropertyChangeSupport support;
    private List<InputChat> chatListe;
    private List<InputUser> userNameList;
    private List<flights> flightList;
    private daoInterface dao;


    public TextManagerImpl() {
        support = new PropertyChangeSupport(this);
        chatListe = new ArrayList<>();
        userNameList = new ArrayList<>();
        flightList = new ArrayList<>();
        dao = daoImpl.getInstance();
    }

    @Override
    public InputChat sendMsg(String str) {
      System.out.println("Her starter send msg");
        InputChat inputChat = new InputChat(str);
       // dao.createChar(str);
       chatListe.add(dao.createChar(str));//Denne skal laves om til at den gemmer i databasen
        support.firePropertyChange(utils.NEWCHAT, null, inputChat);
        System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
        System.out.println("Her slutter msg");
        return inputChat;
    }

    @Override
    public List<InputChat> getChat() {
      System.out.println("Her prøver vi at return read chat");
       //return dao.readChat();
       return new ArrayList<>(dao.readChat());
    }

    @Override
    public InputUser username(String txt) {
      System.out.println("Her starter username");
        InputUser inputUser = new InputUser(txt);
        userNameList.add(dao.createUser(txt));
        support.firePropertyChange(utils.NEWUSER, null, inputUser);
        System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
      System.out.println("Her slutter Username ");
        return inputUser;
    }

    @Override
    public List<InputUser> getUser() {

      System.out.println("Her bliver der lavet et return på readuser");
     // return dao.readUser();
      return new ArrayList<>(dao.readUser());
    }

    @Override
    public List<flights> getflights() {
        return new ArrayList<>(flightList);
    }


    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
