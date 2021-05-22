package shared.transferobjects;

import java.io.Serializable;

public class Depature implements Serializable {

    public int departureID;
    public String departure;
    public String departureDate;
    public Airport airport;

    public Depature(int departureID, String departure, String departureDate) {
        this.departureID = departureID;
        this.departure = departure;
        this.departureDate = departureDate;

    }

    public Depature(String departure)
    {
        this.departure = departure;
    }

    public Depature(String departure, String departureDate) {
        this.departure = departure;
        this.departureDate = departureDate;

    }

    //airport
    public Airport getAirport() {
        return airport;
    }

    //departure
    public int getDepartureID() {
        return departureID;
    }
    public String getDeparture() {
        return departure;
    }
    public String getDepartureDate() {
        return departureDate;
    }

    @Override
    public String toString() {
        return "Depature{" +
                "departureID=" + departureID +
                ", departure='" + departure + '\'' +
                ", departureDate=" + departureDate +
                '}';
    }


}
