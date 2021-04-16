package client.views.seat;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.seat;

import java.util.List;

public class seatViewModel {

    private ClientText clientText;
    private ObservableList<seat> seats;

    public seatViewModel(ClientText clientText) {
        this.clientText = clientText;
    }

    public void loadSeat() {
        List<seat> seat = clientText.getSeat();
        seats = FXCollections.observableArrayList(seat);
        //Collections.addAll(, selectedrows);
    }

    public ObservableList<seat> getSeat() {
        return seats;
    }

    public void getSeatInformation(seat seat) {
        SaveInfo.getInstance().setSeat(seat);
        System.out.println("Save SeatInformation = " + SaveInfo.getInstance());
    }
}
