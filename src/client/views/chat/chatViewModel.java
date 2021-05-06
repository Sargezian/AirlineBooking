package client.views.chat;

import client.model.ClientText;
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
import java.io.Serial;
import java.util.List;

public class chatViewModel {

    // TODO: 04/05/2021 lave barchart diagrammerne til chatmodellen.


    private ClientText clientText;
    private ObservableList<InputChat> chats;
    private ObservableList<InputUser> users;
    private ObservableList<Rating> ratings;
    private StringProperty totalReviews;
    private StringProperty average;
    private DoubleProperty progressbar;

    private StringProperty error;

    private StringProperty chat;
    private String user;

    private int sum1 = 0;
    private int sum2 = 0;

    XYChart.Series<String, Integer> series = new XYChart.Series<>();


    public chatViewModel(ClientText clientText) {
        this.clientText = clientText;
        this.chat = new SimpleStringProperty();
        this.totalReviews = new SimpleStringProperty();
        this.average = new SimpleStringProperty();
        this.error = new SimpleStringProperty();
        this.progressbar = new SimpleDoubleProperty();

        clientText.addListener(utils.NEWCHAT, this::onNewInputChat);
        clientText.addListener(utils.NEWUSER, this::OnNewInputUser);

    }

    public void setCounter() {
        totalReviews.setValue(String.valueOf(clientText.CountChat()));
    }

    public void setAverage() {
        average.setValue(String.valueOf(clientText.AverageStars()));
        progressbar.setValue(clientText.AverageStars()/5);
        System.out.println("avg" + clientText.AverageStars()/5);
    }


    public void chatPrint(Rating rating) {

        if (chat.getValue() != null && !"".equals(chat.getValue()) && rating != null) {
            clientText.createChat(chat.getValue() + "  Message from : " + user + " " + rating.star + " STAR ", rating.star);

            series.setName("Rating");
            setCounter();
            setAverage();
        } else {
            error.set("please choose a rating");
            System.out.println(chat.getValue());
        }

            /*if (rating.star == 5) {
                sum1++;
                series.getData().add(new XYChart.Data<String, Integer>("5 Star", sum1));
            } else if (rating.star == 4) {
                sum2++;
                series.getData().add(new XYChart.Data<String, Integer>("4 Star", sum2));
            }  else {
                error.set("please choose a rating");
                System.out.println(chat.getValue());
            }*/


            /*Platform.runLater(new Runnable() {
                @Override public void run() {

                }});*/

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

    public XYChart.Series<String, Integer> getSeries() {
        return series;
    }

    public double getProgressbar() {
        return progressbar.get();
    }

    public DoubleProperty progressbarProperty() {
        return progressbar;
    }
}
