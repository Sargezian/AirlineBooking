package shared.transferobjects;

import java.io.Serializable;
import java.sql.Timestamp;

public class myFlightTicket implements Serializable {

 public int ticketID;
 public Passenger passenger;
 public flights flights;
 public Seat seat;
 public PlaneType planeType;
 public Depature depature;
 public Arrival arrival;

    public myFlightTicket(int ticketID, Passenger passenger, flights flights, Seat seat, PlaneType planeType, Depature depature, Arrival arrival) {
        this.ticketID = ticketID;
        this.passenger = passenger;
        this.flights = flights;
        this.seat = seat;
        this.planeType = planeType;
        this.depature = depature;
        this.arrival = arrival;
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

    public Depature getDepature() {
        return depature;
    }

    public Depature getDeparture() {
        return depature;
    }

    public int getDepartureID() {
        return depature.departureID;
    }

    public String getDepartures() {
        return depature.departure;
    }

    public Timestamp getDepartureDate() {
        return depature.departureDate;
    }

    // TODO: 29/04/2021 Arrival

    public Arrival getArrival() {
        return arrival;
    }

    public int getArrivalID() {
        return arrival.arrivalID;
    }

    public String getArrivals() {
        return arrival.arrival;
    }

    public Timestamp getArrivalDate() {
        return arrival.arrivalDate;
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

    public PlaneType getPlaneType() {
        return planeType;
    }

    public int getPlaneId() {
        return planeType.planeId;
    }

    public String getPlaneTypes() {
        return planeType.planeType;
    }


}




