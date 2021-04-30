package client.views.seat;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import shared.transferobjects.Seat;

import java.util.ArrayList;
import java.util.List;

public class seatViewModel {

    private ClientText clientText;
    private ObservableList<Seat> Seats;
    private ArrayList<Pane> selectedPane = new ArrayList<>();



    public seatViewModel(ClientText clientText) {
        this.clientText = clientText;
        //SaveInfo.getInstance().setSeat(clientText.seat(seatNumber,classType));
    }

/*
    public void loadSeat() {
        List<Pane> panes = clientText.

    }*/



    /*public void SetSeatId(MouseEvent mouseEvent)
    {
        Pane pane = (Pane) mouseEvent.getSource();
        selectedPane = new ArrayList<>();
        int id = (pane.idProperty().length().get());
        pane.setStyle("-fx-background-color:red;");
        System.out.println(id);

        SaveInfo.getInstance().setSeat(clientText.getSeatId(id,"Hej","Economy class"));

    }*/

    public void loadSeat() {
        List<Seat> seat = clientText.getSeat();
        Seats = FXCollections.observableArrayList(seat);
        //Collections.addAll(, selectedrows);
    }

    public ObservableList<Seat> getSeat() {
        return Seats;
    }


    public void getSeatInformation(Seat seat) {
        SaveInfo.getInstance().setSeat(seat);
        System.out.println("Save SeatInformation = " + SaveInfo.getInstance());
    }
}
