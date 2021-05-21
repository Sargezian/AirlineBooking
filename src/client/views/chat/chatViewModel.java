package client.views.chat;

import client.model.ClientModel;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.transferobjects.Rating;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class chatViewModel {

    private ClientModel clientModel;

    private ObservableList<InputChat> chats;
    private ObservableList<InputUser> users;
    private ObservableList<Rating> ratings;

    private StringProperty totalReviews;
    private StringProperty average;
    private StringProperty error;
    private StringProperty chat;

    private DoubleProperty progressbar;

    private String user;

    XYChart.Series<String, Double> series = new XYChart.Series<>();

    public chatViewModel(ClientModel clientModel) {
        this.clientModel = clientModel;
        this.chat = new SimpleStringProperty();
        this.totalReviews = new SimpleStringProperty();
        this.average = new SimpleStringProperty();
        this.error = new SimpleStringProperty();
        this.progressbar = new SimpleDoubleProperty();

        clientModel.addListener(utils.NEWCHAT, this::onNewInputChat);
        clientModel.addListener(utils.NEWUSER, this::OnNewInputUser);

    }

    //Countmetode der tæller antal reviews givet.
    public void setCounter() {
        totalReviews.setValue(String.valueOf(clientModel.CountChat()));
    }

    //average ratings givet
    public void setAverage() {
        average.setValue(String.valueOf(clientModel.AverageStars()));
        progressbar.setValue(clientModel.AverageStars()/5);
        System.out.println("avg" + clientModel.AverageStars()/5);
    }

    //tæller barchart op, alt efter hvilken rating givet
    public void setBarchart(Rating rating) {
        Platform.runLater(new Runnable() {
            @Override public void run() {
                series.setName("Rating");
                for (int i = 1; i <= 5; i++)
                {
                    double star_1 = clientModel.CountRatings(i);
                    series.getData().add(new XYChart.Data<String, Double>( i + " Star", star_1));
                }
            }});
    }

    //vores chat
    public void chatPrint(Rating rating) {

        if (chat.getValue() != null && !"".equals(chat.getValue()) && rating != null) {
            clientModel.createChat(chat.getValue() + "  Message from : " + user + "   " + rating.star + " STAR ", rating.star);
            System.out.println("user;=" + user);

            setCounter();
            setAverage();
        } else {
            error.set("please choose a rating");
            System.out.println(chat.getValue());
        }
            chat.set("");
    }

    //loadChat
    public void loadLogs() {
        List<InputChat> chatList = clientModel.getChat();
        chats = FXCollections.observableArrayList(chatList);
    }

    //loadUser
    public void loadLogs2() {
        List<InputUser> userLists = clientModel.getUser();
        users = FXCollections.observableArrayList(userLists);
    }

    //loadRatings
    public void loadRatings() {
        List<Rating> rating = clientModel.getRatings();
        ratings = FXCollections.observableArrayList(rating);
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

    ObservableList<InputChat> getChats() {
        return chats;
    }
    ObservableList<Rating> getRatings() {
        return ratings;
    }

    public StringProperty totalReviewsProperty() {
        return totalReviews;
    }
    public StringProperty averageProperty() {
        return average;
    }
    public StringProperty getChat(){
        return chat;
    }
    public StringProperty errorProperty() {
        return error;
    }
    public DoubleProperty progressbarProperty() {
        return progressbar;
    }

    public XYChart.Series<String, Double> getSeries() {
        return series;
    }

}
