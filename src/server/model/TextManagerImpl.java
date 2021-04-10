package server.model;

import server.model.database.daoImpl;
import server.model.database.daoInterface;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.util.utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TextManagerImpl implements TextManager{

    private PropertyChangeSupport support;
    private List<InputChat> chatListe;
    private List<InputUser> userNameList;
    private daoInterface dao;


    public TextManagerImpl() {
        support = new PropertyChangeSupport(this);
        chatListe = new ArrayList<>();
        userNameList = new ArrayList<>();
        dao = new daoImpl();
    }

    @Override
    public String sendMsg(String str) {
      System.out.println("Her starter send msg");
        //InputChat inputChat = new InputChat(str);
        InputChat inputChat = dao.createChar(str);
        chatListe.add(inputChat);//Denne skal laves om til at den gemmer i databasen
        support.firePropertyChange(utils.NEWCHAT, null, inputChat);
        System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
      System.out.println("Her slutter msg");
        return str;
    }

    @Override
    public List<InputChat> getChat() {
      System.out.println("Her prøver vi at return read chat");
        return dao.readChat();
        //return new ArrayList<>(chatListe);
    }

    @Override
    public String username(String txt) {
      System.out.println("Her starter username");
        //InputUser inputUser = new InputUser(txt);
        InputUser inputUser = dao.createUser(txt);
        userNameList.add(inputUser);
        support.firePropertyChange(utils.NEWUSER, null, inputUser);
        System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
      System.out.println("Her slutter Username ");
        return txt;
    }

    @Override
    public List<InputUser> getUser() {

      System.out.println("Her bliver der lavet et return på readuser");
      return dao.readUser();
      //return new ArrayList<>(userNameList);
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
