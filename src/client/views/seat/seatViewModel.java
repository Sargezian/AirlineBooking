package client.views.seat;

import client.model.ClientModel;
import client.model.SaveInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Seat;
import shared.transferobjects.Flights;
import shared.util.utils;
import java.beans.PropertyChangeEvent;
import java.util.List;

public class seatViewModel {


    private ClientModel clientModel;
    private ObservableList<Seat> Seats;

    private StringProperty error;
    private seatViewController svc;

    public seatViewModel(ClientModel clientModel) {
        this.clientModel = clientModel;
        this.error = new SimpleStringProperty();
        clientModel.addListener(utils.NEWSEAT,this::Onnewseats);
        clientModel.addListener(utils.NEWFLIGHT,this::Onnewseats);
    }

    private void Onnewseats(PropertyChangeEvent propertyChangeEvent) {
        loadSeat();
    }

    public void loadSeat() {
        Flights flights = SaveInfo.getInstance().getFlights();
        List<Seat> seat = clientModel.getSeat(flights.getPlaneId());
        Seats = FXCollections.observableArrayList(seat);
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

    public void deleteSeat(Seat Seat) {
        clientModel.deleteSeat(Seat);
    }

    public String getError() {
        return error.get();
    }
    public StringProperty errorProperty() {
        return error;
    }
}
