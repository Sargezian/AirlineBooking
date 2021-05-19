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
    private DoubleProperty progressbar;

    private StringProperty error;

    private StringProperty chat;
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

    public void setCounter() {
        totalReviews.setValue(String.valueOf(clientModel.CountChat()));
    }

    public void setAverage() {
        average.setValue(String.valueOf(clientModel.AverageStars()));
        progressbar.setValue(clientModel.AverageStars()/5);
        System.out.println("avg" + clientModel.AverageStars()/5);
    }

    public void setBarchart(Rating rating) {

        Platform.runLater(new Runnable() {
            @Override public void run() {
                series.setName("Rating");
                for (int i = 1; i <= 5; i++)
                {
                    double star_1 = clientModel.CountRatings(i);
                    series.getData().add(new XYChart.Data<String, Double>( i + " Star", star_1));

                }

/*
                if (rating.star == 1) {
                    double star_1 = clientText.CountRatings(rating.star);
                    series.getData().add(new XYChart.Data<String, Double>("1 Star", star_1));
                } else if (rating.star == 2) {
                    double star_2 = clientText.CountRatings(rating.star);
                    series.getData().add(new XYChart.Data<String, Double>("2 Star", star_2));
                } else if (rating.star == 3) {
                    double star_3 = clientText.CountRatings(rating.star);
                    series.getData().add(new XYChart.Data<String, Double>("3 Star", star_3));
                } else if (rating.star == 4) {
                    double star_4 = clientText.CountRatings(rating.star);
                    series.getData().add(new XYChart.Data<String, Double>("4 Star", star_4));
                } else if (rating.star == 5) {
                    double star_5 = clientText.CountRatings(rating.star);
                    series.getData().add(new XYChart.Data<String, Double>("5 Star", star_5));
                }*/
            }});
    }


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


    public void loadLogs() {
        List<InputChat> chatList = clientModel.getChat();
        chats = FXCollections.observableArrayList(chatList);
    }

    public void loadLogs2() {
        List<InputUser> userLists = clientModel.getUser();
        users = FXCollections.observableArrayList(userLists);
    }

    public void loadRatings() {
        List<Rating> rating = clientModel.getRatings();
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

    public XYChart.Series<String, Double> getSeries() {
        return series;
    }

    public double getProgressbar() {
        return progressbar.get();
    }

    public DoubleProperty progressbarProperty() {
        return progressbar;
    }
}
