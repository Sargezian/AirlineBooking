package client.views.seat;

import client.model.ClientModel;
import client.model.SaveInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import shared.transferobjects.Seat;
import shared.transferobjects.Flights;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class seatViewModel {


    private ClientModel clientModel;
    private ObservableList<Seat> Seats;
    private ArrayList<Pane> selectedPane = new ArrayList<>();
    private StringProperty error;
    private seatViewController svc;

    public seatViewModel(ClientModel clientModel) {
        this.clientModel = clientModel;
        this.error = new SimpleStringProperty();
        clientModel.addListener(utils.NEWSEAT,this::Onnewseats);
        clientModel.addListener(utils.NEWFLIGHT,this::Onnewseats);
        //SaveInfo.getInstance().setSeat(clientText.seat(seatNumber,classType));
    }

    private void Onnewseats(PropertyChangeEvent propertyChangeEvent) {
        loadSeat();
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
        Flights flights = SaveInfo.getInstance().getFlights();
        List<Seat> seat = clientModel.getSeat(flights.getPlaneId());
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


    public void deleteSeat(Seat Seat) {
        clientModel.deleteSeat(Seat);

    }
}
