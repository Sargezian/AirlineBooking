package shared.transferobjects;

import java.io.Serializable;

public class Myflightlist implements Serializable {

 private String ticketID;
 private String price;
 private passenger passenger;
 private flights flights;
 private seat seat;

    public Myflightlist(String ticketID, String price, passenger passenger, flights flights, seat seat) {
        this.ticketID = ticketID;
        this.price = price;
        this.passenger = passenger;
        this.flights = flights;
        this.seat = seat;
    }

    public String getFlightID(){
        return flights.flightID;
    }

    public String getFlightName(){
        return flights.flightName;
    }

    public String getDeparture(){
        return flights.departure;
    }

    public String getArrival(){
        return flights.arrival;
    }

    public String getTo(){
        return flights.to;
    }

    public String getFrom(){
        return flights.from;
    }

    public String getTicketID() {
        return ticketID;
    }

    public String getPrice() {
        return price;
    }

    public String getPassengerID() {
        return passenger.passengerID;
    }

    public String getSeatID() {
        return seat.seatID;
    }

    public String getName() {
        return passenger.name;
    }

    public String getSeatNumber() {
        return seat.seatNumber;
    }

    public String getClassType(){
        return seat.classType;
     }


    public shared.transferobjects.passenger getPassenger() {
        return passenger;
    }

    public shared.transferobjects.flights getFlights() {
        return flights;
    }

    public shared.transferobjects.seat getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Myflightlist{" +
                "ticketID='" + ticketID + '\'' +
                ", price='" + price + '\'' +
                ", passenger=" + passenger +
                ", flights=" + flights +
                ", seat=" + seat +
                '}';
    }

}




