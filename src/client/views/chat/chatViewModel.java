package client.views.chat;

import client.model.ClientText;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.transferobjects.Rating;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class chatViewModel {

    // TODO: 04/05/2021 lave barchart diagrammerne til chatmodellen.


    private ClientText clientText;
    private ObservableList<InputChat> chats;
    private ObservableList<InputUser> users;
    private ObservableList<Rating> ratings;
    private StringProperty totalReviews;
    private StringProperty average;
    private StringProperty error;

    private StringProperty chat;
    private String user;

    public chatViewModel(ClientText clientText) {
        this.clientText = clientText;
        this.totalReviews = new SimpleStringProperty();
        this.average = new SimpleStringProperty();
        this.error = new SimpleStringProperty();

        clientText.addListener(utils.NEWCHAT, this::onNewInputChat);
        chat = new SimpleStringProperty();
        clientText.addListener(utils.NEWUSER, this::OnNewInputUser);
    }

   public void setCounter(){

        totalReviews.setValue(String.valueOf(clientText.CountChat()));
    }

    public void setAverage() {
        average.setValue(String.valueOf(clientText.AverageStars()));
    }


    public void chatPrint(Rating rating) {

        if (chat.getValue() != null && !"".equals(chat.getValue()) && rating != null) {
            clientText.createChat(chat.getValue()+  "  Message from : " + user + " " + rating.star + " STAR ", rating.star);

            setCounter();
            setAverage();

        } else {
            error.set("please choose a rating");
            System.out.println(chat.getValue());
        }
        chat.set("");
    }

    public void loadLogs() {
        List<InputChat> chatList = clientText.getChat();
        chats = FXCollections.observableArrayList(chatList);
    }

    public void loadLogs2() {
        List<InputUser> userLists = clientText.getUser();
        users = FXCollections.observableArrayList(userLists);
    }

    public void loadRatings() {
        List<Rating> rating = clientText.getRatings();
        ratings = FXCollections.observableArrayList(rating);
    }


    ObservableList<InputChat> getChats() {
        return chats;
    }
    ObservableList<InputUser> getUsers() {
        return users;
    }

    public StringProperty getChat(){
        return chat;
    }

    public void setUser(String user) {
        this.user = user;
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

    public ObservableList<Rating> getRatings() {
        return ratings;
    }

    public String getAverage() {
        return average.get();
    }

    public StringProperty averageProperty() {
        return average;
    }

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }
}
