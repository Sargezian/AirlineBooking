package shared.transferobjects;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class myFlightTicket implements Serializable {

 private int ticketID;
 private int price;
 private passenger passenger;
 private flights flights;
 private seat seat;

    public myFlightTicket(int ticketID, int price, passenger passenger, flights flights, seat seat) {
        this.ticketID = ticketID;
        this.price = price;
        this.passenger = passenger;
        this.flights = flights;
        this.seat = seat;
    }

    public int getFlightID(){
        return flights.flightID;
    }

    public String getFlightName(){
        return flights.flightName;
    }

    public String getPlaneType(){
      return flights.planeType;
    }

    public Timestamp getDeparture(){
        return flights.departure;
    }

    public Timestamp getArrival(){
        return flights.arrival;
    }

    public String getTo(){
        return flights.to;
    }

    public String getFrom(){
        return flights.from;
    }

    public int getTicketID() {
        return ticketID;
    }

    public int getPrice() {
        return price;
    }

    public int getPassengerID() {
        return passenger.passengerID;
    }

    public int getSeatID() {
        return seat.seatID;
    }

    public String getFirstName() {
        return passenger.FirstName;
    }

    public String getLastName(){
      return passenger.LastName;
    }
  public String getTelNumber(){
    return passenger.TelNumber;
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




