package client.views.seat;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import shared.transferobjects.Seat;
import shared.transferobjects.flights;

import java.util.ArrayList;
import java.util.List;

public class seatViewModel {

    // TODO: 04/05/2021 fjerne seats når man bestiller


    private ClientText clientText;
    private ObservableList<Seat> Seats;
    private ArrayList<Pane> selectedPane = new ArrayList<>();
    private StringProperty error;


    public seatViewModel(ClientText clientText) {
        this.clientText = clientText;
        this.error = new SimpleStringProperty();
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
        flights flights = SaveInfo.getInstance().getFlights();
        List<Seat> seat = clientText.getSeat(flights.getPlaneId());
        Seats = FXCollections.observableArrayList(seat);
        //Collections.addAll(, selectedrows);
    }

    public ObservableList<Seat> getSeat() {
        return Seats;
    }


    public boolean getSeatInformation(Seat seat) {

        if (seat != null) {
            SaveInfo.getInstance().setSeat(seat);
            System.out.println("Save SeatInformation = " + SaveInfo.getInstance());
            return true;
        } else {
            error.set("Please select seat for continue");
            return false;
        }

    }

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }
}
