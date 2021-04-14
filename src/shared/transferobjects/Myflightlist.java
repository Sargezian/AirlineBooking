package shared.transferobjects;

import java.io.Serializable;

public class Myflightlist implements Serializable {

    private String flight;
    private String seats;

    public Myflightlist(String flight, String seats) {
        this.flight = flight;
        this.seats = seats;
    }

    public String getFlight() {
        return flight;
    }

    public String getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "flightlist{" +
                "pla='" + flight + '\'' +
                ", plb='" + seats + '\'' +
                '}';
    }
}
