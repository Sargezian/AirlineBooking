package shared.transferobjects;

import java.io.Serializable;
import java.sql.Timestamp;

public class ShoppingCart implements Serializable {

    public Flights flights;
    public Seat seat;
    public Depature depature;
    public Arrival arrival;

    public ShoppingCart(Flights flights, Seat seat, Depature depature, Arrival arrival) {
        this.flights = flights;
        this.seat = seat;
        this.depature = depature;
        this.arrival = arrival;
    }

    //departure
    public int getDepartureID() {
        return depature.departureID;
    }
    public String getDepartures() {
        return depature.departure;
    }
    public Timestamp getDepartureDate() {
        return depature.departureDate;
    }
    public Depature getDepature() {
        return depature;
    }

    //arrival
    public int getArrivalID() {
        return arrival.arrivalID;
    }
    public String getArrivals() {
        return arrival.arrival;
    }
    public Timestamp getArrivalDate() {
        return arrival.arrivalDate;
    }
    public Arrival getArrival() {
        return arrival;
    }

    //flight
    public Flights getFlights() {
        return flights;
    }
    public String getFlightID(){
        return flights.flightID;
    }

    //seat
    public Seat getSeat() {
        return seat;
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
