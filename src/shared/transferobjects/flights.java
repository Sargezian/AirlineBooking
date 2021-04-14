package shared.transferobjects;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class flights implements Serializable {

    public String dummy;
    public String seats;

    public flights(String dummy, String seats) {
        this.dummy = dummy;
        this.seats = seats;
    }

    public String getDummy() {
        return dummy;
    }

    public String getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "flights{" +
                "dummy='" + dummy + '\'' +
                ", seats='" + seats + '\'' +
                '}';
    }
}
