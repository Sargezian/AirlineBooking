package client.model;

import shared.transferobjects.flights;
import shared.transferobjects.Passenger;
import shared.transferobjects.Seat;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaveInfo {

    private static SaveInfo instance;
    private static Lock lock = new ReentrantLock();
    private flights flights;
    private Seat seat;
    private Passenger passenger;

    public static SaveInfo getInstance() {

        if (instance == null) {
            synchronized (lock) {
               if (instance == null)
                   instance = new SaveInfo();
            }
        }
        return instance;
    }

    public flights getFlights() {
        return flights;
    }

    public void setFlights(flights flights) {
        this.flights = flights;
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

    @Override
    public String toString() {
        return "SaveInfo{" +
                "flights=" + flights +
                ", seat=" + seat +
                ", passenger=" + passenger +
                '}';
    }


}
