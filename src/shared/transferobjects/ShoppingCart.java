package shared.transferobjects;

import java.io.Serializable;
import java.sql.Timestamp;

public class ShoppingCart implements Serializable {

    public flights flights;
    public Seat seat;
    public Depature depature;
    public Arrival arrival;

    public ShoppingCart(shared.transferobjects.flights flights, Seat seat, Depature depature, Arrival arrival) {
        this.flights = flights;
        this.seat = seat;
        this.depature = depature;
        this.arrival = arrival;
    }

    public int getDepartureID() {
        return depature.departureID;
    }

    public int getArrivalID() {
        return arrival.arrivalID;
    }

    public String getDepartures() {
        return depature.departure;
    }

    public Timestamp getDepartureDate() {
        return depature.departureDate;
    }

    public String getArrivals() {
        return arrival.arrival;
    }

    public Timestamp getArrivalDate() {
        return arrival.arrivalDate;
    }

    public Depature getDepature() {
        return depature;
    }

    public Arrival getArrival() {
        return arrival;
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

    public String getSeatNumber() {
        return seat.seatNumber;
    }

    public String getClassType(){
        return seat.classType;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "flights=" + flights +
                ", seat=" + seat +
                ", depature=" + depature +
                ", arrival=" + arrival +
                '}';
    }
}
