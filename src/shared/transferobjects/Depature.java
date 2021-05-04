package shared.transferobjects;

import java.io.Serializable;
import java.sql.Timestamp;

public class Depature implements Serializable {

    public int departureID;
    public String departure;
    public Timestamp departureDate;
    public Airport airport;

    public Depature(int departureID, String departure, Timestamp departureDate) {
        this.departureID = departureID;
        this.departure = departure;
        this.departureDate = departureDate;

    }

    public Depature(String departure)
    {
        this.departure = departure;
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
    public Timestamp getDepartureDate() {
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
