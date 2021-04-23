package client.views.seat;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Seat;

import java.util.List;

public class seatViewModel {

    private ClientText clientText;
    private ObservableList<Seat> Seats;

    public seatViewModel(ClientText clientText) {
        this.clientText = clientText;
        //SaveInfo.getInstance().setSeat(clientText.seat(seatNumber,classType));
    }

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
