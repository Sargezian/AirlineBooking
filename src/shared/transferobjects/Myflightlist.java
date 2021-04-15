package shared.transferobjects;

import java.io.Serializable;

public class Myflightlist implements Serializable {

 private String ticketID;
 private String price;
 private passenger passenger;
 public flights flights;
 private seat seat;

    public Myflightlist(String ticketID, String price, shared.transferobjects.passenger passenger, shared.transferobjects.flights flights, shared.transferobjects.seat seat) {
        this.ticketID = ticketID;
        this.price = price;
        this.passenger = passenger;
        this.flights = flights;
        this.seat = seat;
    }

     public String getFlightId(){

        return flights.flightID;

     }


     public String getclassType(){

        return seat.classType;


     }



   public String getTicketID() {
       System.out.println("ticket" + ticketID);
        return ticketID;
    }

    public String getPrice() {
        return price;
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




