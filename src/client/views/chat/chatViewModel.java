package client.views.chat;

import client.model.ClientText;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class chatViewModel {

    private client.views.Loginbox.loginViewModel vm;
    private ClientText clientText;

    private ObservableList<InputChat> chats;
    private ObservableList<InputUser> users;

    private StringProperty request;
    public StringProperty getRequest(){
        return request;
    }
    private String navn;

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public chatViewModel(ClientText clientText) {
        this.clientText = clientText;
        clientText.addListener(utils.NEWCHAT, this::onNewInputChat);
        request = new SimpleStringProperty();
        clientText.addListener(utils.NEWUSER, this::OnNewInputUser);
    }

    void chatPrint() {
        if (request.getValue() != null && !"".equals(request.getValue())) {
            clientText.sendMsg(request.getValue());
            clientText.sendMsg("Besked fra: " + navn);
        } else {
            System.out.println(request.getValue());
        }
        request.set("");
    }

    public void onNewInputChat(PropertyChangeEvent evt) {
      chats.add((InputChat) evt.getNewValue());
    }

    public void OnNewInputUser(PropertyChangeEvent evt){
        users.add((InputUser) evt.getNewValue());
    }

    void loadLogs() {
        List<InputChat> chatList = clientText.getChat();
        chats = FXCollections.observableArrayList(chatList);
    }

    ObservableList<InputChat> getChats() {
        return chats;
    }
    ObservableList<InputUser> getUsers() {
        return users;
    }

    public void loadLogs2() {
        List<InputUser> userLists = clientText.getUser();
        users = FXCollections.observableArrayList(userLists);
    }

}
