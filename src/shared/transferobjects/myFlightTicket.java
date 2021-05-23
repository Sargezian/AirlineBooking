package shared.transferobjects;

import java.io.Serializable;

public class myFlightTicket implements Serializable {

 private String ticketID;
 private Passenger passenger;
 private Flights flights;
 private Seat seat;
 private InputUser user;


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
        return user.getId();
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
        return passenger.getEmail();
    }
    public int getPassengerID()
    {
        return passenger.getPassengerID();
    }
    public String getTelNumber()
    {
        return passenger.getTelNumber();
    }
    public String getFirstName()
    {
        return passenger.getFirstName();
    }
    public String getLastName()
    {
        return passenger.getLastName();
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
        return flights.getFlightID();
    }
    public String getFlightName() {
        return flights.getFlightName();
    }

  // TODO: 24-05-2021 Mangler at sætte price i myflightticket
    public String getPrices() {
        return flights.getPrice();
    }

    //Seat
    public Seat getSeat() {
        return seat;
    }
    public int getSeatID() {
        return seat.getSeatID();
    }
    public String getSeatNumber() {
        return seat.getSeatNumber();
    }
    public String getClassType(){
        return seat.getClassType();
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




