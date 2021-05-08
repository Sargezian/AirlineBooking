package shared.transferobjects;

import java.io.Serializable;

public class myFlightTicket implements Serializable {

 public String ticketID;
 public Passenger passenger;
 public Flights flights;
 public Seat seat;
 public InputUser user;


    public myFlightTicket(String ticketID, Passenger passenger, Flights flights, Seat seat) {
        this.ticketID = ticketID;
        this.passenger = passenger;
        this.flights = flights;
        this.seat = seat;
    }

    public myFlightTicket(String ticketID, Passenger passenger, Flights flights, Seat seat, InputUser user) {
        this.ticketID = ticketID;
        this.passenger = passenger;
        this.flights = flights;
        this.seat = seat;
        this.user = user;

    }


    //Inputuser


    public InputUser getUser() {
        return user;
    }


    public int getId() {
        return user.id;
    }


    //myflightTicket
    public String getTicketID() {
        return ticketID;
    }

    // Passenger
    public Passenger getPassenger() {
        return passenger;
    }
    public String getEmail() {
        return passenger.Email;
    }
    public int getPassengerID()
    {
        return passenger.passengerID;
    }
    public String getTelNumber()
    {
        return passenger.TelNumber;
    }
    public String getFirstName()
    {
        return passenger.FirstName;
    }
    public String getLastName()
    {
        return passenger.LastName;
    }

    //Departue
    public String getDeparture(){
        return flights.getDepartures();
      }
    public String getDepartureDate() {
        return flights.getDepartureDate();
    }

    //Arrival
    public String getArrivals() {
        return flights.getArrivals();
    }
    public String getArrivalDate() {
        return flights.getArrivalDate();
    }

    //Flight
    public Flights getFlights() {
        return flights;
    }
    public String getFlightID() {
        return flights.flightID;
    }
    public String getFlightName() {
        return flights.flightName;
    }
    public int getPrices() {
        return flights.price;
    }

    //Seat
    public Seat getSeat() {
        return seat;
    }
    public int getSeatID() {
        return seat.seatID;
    }
    public String getSeatNumber() {
        return seat.seatNumber;
    }
    public String getClassType(){
        return seat.classType;
    }

    //PlaneType
    public int getPlaneId() {
        return flights.getPlaneId();
    }
    public String getPlaneTypes() {
        return flights.getPlaneTypes();
    }


    @Override
    public String toString() {
        return "myFlightTicket{" +
                "ticketID=" + ticketID +
                ", passenger=" + passenger +
                ", flights=" + flights +
                ", seat=" + seat +
                ", user=" + user +
                '}';
    }
}




