package client.views.chat;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.transferobjects.Passenger;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class chatViewModel {

    private ClientText clientText;
    private ObservableList<InputChat> chats;
    private ObservableList<InputUser> users;
    private StringProperty totalReviews;



/*  private DoubleProperty STAR_1;
    private DoubleProperty STAR_2;
    private DoubleProperty STAR_3;
    private DoubleProperty STAR_4;
    private DoubleProperty STAR_5;*/

    private StringProperty request;
    private String navn;

    public chatViewModel(ClientText clientText) {
        this.clientText = clientText;
        this.totalReviews = new SimpleStringProperty();
/*
        STAR_1 = new SimpleDoubleProperty();
        STAR_2 = new SimpleDoubleProperty();
        STAR_3 = new SimpleDoubleProperty();
        STAR_4 = new SimpleDoubleProperty();
        STAR_5 = new SimpleDoubleProperty();
*/
        clientText.addListener(utils.NEWCHAT, this::onNewInputChat);
        request = new SimpleStringProperty();
        clientText.addListener(utils.NEWUSER, this::OnNewInputUser);
    }


   public void setCounter(){

        totalReviews.setValue(String.valueOf(clientText.CountChat()));
    }


    public void chatPrint() {

        if (request.getValue() != null && !"".equals(request.getValue())) {
            clientText.sendMsg(request.getValue()+  "  Message from : " + navn);
            setCounter();

        } else {
            System.out.println(request.getValue());
        }
        request.set("");
    }

    public void loadLogs() {
        List<InputChat> chatList = clientText.getChat();
        chats = FXCollections.observableArrayList(chatList);
    }

    public void loadLogs2() {
        List<InputUser> userLists = clientText.getUser();
        users = FXCollections.observableArrayList(userLists);
    }

    ObservableList<InputChat> getChats() {
        return chats;
    }
    ObservableList<InputUser> getUsers() {
        return users;
    }

    public StringProperty getRequest(){
        return request;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void onNewInputChat(PropertyChangeEvent evt) {
        chats.add((InputChat) evt.getNewValue());
    }
    public void OnNewInputUser(PropertyChangeEvent evt){
        users.add((InputUser) evt.getNewValue());
    }

    public String getTotalReviews() {
        return totalReviews.get();
    }

    public StringProperty totalReviewsProperty() {
        return totalReviews;
    }

  /*   public DoubleProperty STAR_1Property() {
        return STAR_1;
    }
    public DoubleProperty STAR_2Property() {
        return STAR_2;
    }
    public DoubleProperty STAR_3Property() {
        return STAR_3;
    }
    public DoubleProperty STAR_4Property() {
        return STAR_4;
    }
    public DoubleProperty STAR_5Property() {
        return STAR_5;
    }*/
}
