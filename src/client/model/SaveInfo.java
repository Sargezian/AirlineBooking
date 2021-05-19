package client.model;

import shared.transferobjects.*;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaveInfo {

    private Flights flights;
    private Seat seat;
    private Airport airport;
    private Arrival arrival;
    private Depature depature;
    private Passenger passenger;
    private InputUser user;


    private static SaveInfo instance;
    private static Lock lock = new ReentrantLock();

    private SaveInfo() {}

    public static SaveInfo getInstance() {
        // if one doesn't already exist, create it
        if (instance == null) {
            synchronized (lock) {
               if (instance == null)
                   instance = new SaveInfo();
            }
        }
        return instance;
    }

    public Flights getFlights() {
        return flights;
    }

    public void setFlights(Flights flights) {
        this.flights = flights;
    }

    public InputUser getUser() {
        return user;
    }

    public void setUser(InputUser user) {
        this.user = user;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Airport getAirport()
    {
        return airport;
    }

    public void setAirport(Airport airport)
    {
        this.airport = airport;
    }

    public Arrival getArrival()
    {
        return arrival;
    }

    public void setArrival(Arrival arrival)
    {
        this.arrival = arrival;
    }

    public Depature getDepature()
    {
        return depature;
    }

    public void setDepature(Depature depature)
    {
        this.depature = depature;
    }

    public void reset(){
        System.out.println("Her sætter vi flights til null");
        setFlights(null);
        setSeat(null);
        setPassenger(null);
        setUser(null);
        System.out.println("Her getter vi en user " + getUser());
    }

    @Override
    public String toString() {
        return "SaveInfo{" +
                "flights=" + flights +
                ", seat=" + seat +
                ", airport=" + airport +
                ", arrival=" + arrival +
                ", depature=" + depature +
                ", passenger=" + passenger +
                ", user=" + user +
                '}';
    }
}
