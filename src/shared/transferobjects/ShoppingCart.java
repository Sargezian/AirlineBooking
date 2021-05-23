package shared.transferobjects;

import java.io.Serializable;

public class ShoppingCart implements Serializable {

    private Flights flights;
    private Seat seat;
    private Depature depature;
    private Arrival arrival;

    public ShoppingCart(Flights flights, Seat seat, Depature depature, Arrival arrival) {
        this.flights = flights;
        this.seat = seat;
        this.depature = depature;
        this.arrival = arrival;
    }

    //departure
    public int getDepartureID() {
        return depature.getDepartureID();
    }
    public String getDepartures() {
        return depature.getDeparture();
    }
    public String getDepartureDate() {
        return depature.getDepartureDate();
    }
    public Depature getDepature() {
        return depature;
    }

    //arrival
    public int getArrivalID() {
        return arrival.getArrivalID();
    }
    public String getArrivals() {
        return arrival.getArrival();
    }
    public String getArrivalDate() {
        return arrival.getArrivalDate();
    }
    public Arrival getArrival() {
        return arrival;
    }

    //flight
    public Flights getFlights() {
        return flights;
    }
    public String getFlightID(){
        return flights.getFlightID();
    }

    //seat
    public Seat getSeat() {
        return seat;
    }
    public String getSeatNumber() {
        return seat.getSeatNumber();
    }
    public String getClassType(){
        return seat.getClassType();
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
