package shared.transferobjects;

import java.io.Serializable;

public class ShoppingCart implements Serializable {

    private flights flights;
    private Seat seat;

    public ShoppingCart(flights flights, Seat seat) {
        this.flights = flights;
        this.seat = seat;
    }

    public flights getFlights() {
        return flights;
    }

    public Seat getSeat() {
        return seat;
    }

    public int getFlightID(){
        return flights.flightID;
    }

    public String getFrom(){
        return flights.from;
    }

    public String getTo(){
        return flights.to;
    }

    public String getSeatNumber() {
        return seat.seatNumber;
    }

    public String getClassType(){
        return seat.classType;
    }

    public int getPrice() {
        return flights.price;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "flights=" + flights +
                ", seat=" + seat +
                '}';
    }
}
