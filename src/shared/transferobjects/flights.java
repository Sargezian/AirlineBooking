package shared.transferobjects;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class flights implements Serializable {

    private SimpleStringProperty dummy;
    private SimpleStringProperty seats;

    public flights(String dummy, String seats) {
        this.dummy = new SimpleStringProperty(dummy);
        this.seats = new SimpleStringProperty(seats);
    }

    public String getDummy() {
        return dummy.get();
    }

    public SimpleStringProperty dummyProperty() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy.set(dummy);
    }

    public String getSeats() {
        return seats.get();
    }

    public SimpleStringProperty seatsProperty() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats.set(seats);
    }

    @Override
    public boolean equals(Object o) {
       // System.out.println(o.getClass().getName());
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        flights flights = (flights) o;
        return dummy.equals(flights.dummy) && seats.equals(flights.seats);
    }

    @Override
    public String toString() {
        return "flights{" +
                "dummy='" + dummy + '\'' +
                '}';
    }

}
