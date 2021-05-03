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
import shared.transferobjects.Rating;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class chatViewModel {

    private ClientText clientText;
    private ObservableList<InputChat> chats;
    private ObservableList<InputUser> users;
    private ObservableList<Rating> ratings;
    private StringProperty totalReviews;

    private StringProperty request;
    private String navn;

    public chatViewModel(ClientText clientText) {
        this.clientText = clientText;
        this.totalReviews = new SimpleStringProperty();

        clientText.addListener(utils.NEWCHAT, this::onNewInputChat);
        request = new SimpleStringProperty();
        clientText.addListener(utils.NEWUSER, this::OnNewInputUser);
    }

   public void setCounter(){

        totalReviews.setValue(String.valueOf(clientText.CountChat()));
    }

    public void chatPrint(Rating rating) {

        if (request.getValue() != null && !"".equals(request.getValue())) {
            clientText.createChat(request.getValue()+  "  Message from : " + navn + " " + rating.star + "STAR", rating.star);

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

    public void loadRatings() {
        List<Rating> rating = clientText.getRatings();
        ratings = FXCollections.observableArrayList(rating);
    }


    public ObservableList<Rating> getRatings() {
        return ratings;
    }
}
