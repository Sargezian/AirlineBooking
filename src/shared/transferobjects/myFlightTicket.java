package shared.transferobjects;

import java.io.Serializable;
import java.sql.Timestamp;

public class myFlightTicket implements Serializable {

 public int ticketID;
 public Passenger passenger;
 public flights flights;
 public Seat seat;


    public myFlightTicket(int ticketID, Passenger passenger, flights flights, Seat seat) {
        this.ticketID = ticketID;
        this.passenger = passenger;
        this.flights = flights;
        this.seat = seat;

    }

    public int getTicketID() {
        return ticketID;
    }

    // TODO: 29/04/2021 PASSENGER

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

    // TODO: 29/04/2021 Departue
      public String getDeparture(){
        return flights.getDepartures();
      }

    public Timestamp getDepartureDate() {
        return flights.getDepartureDate();
    }
    public String getArrivals() {
        return flights.getArrivals();
    }

    public Timestamp getArrivalDate() {
        return flights.getArrivalDate();
    }


    // TODO: 29/04/2021  Flight

    public flights getFlights() {
        return flights;
    }

    public int getFlightID() {
        return flights.flightID;
    }

    public String getFlightName() {
        return flights.flightName;
    }

    public int getPrices() {
        return flights.price;
    }

    // TODO: 29/04/2021 seat

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

    // TODO: 29/04/2021 PlaneType

    public int getPlaneId() {
        return flights.getPlaneId();
    }

    public String getPlaneTypes() {
        return flights.getPlaneTypes();
    }




}




