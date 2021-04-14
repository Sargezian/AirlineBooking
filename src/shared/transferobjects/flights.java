package shared.transferobjects;


import java.io.Serializable;

public class flights implements Serializable {

    public String flightID;
    public String flightName;
    public String departure;

    public flights(String flightID, String flightName, String departure) {
        this.flightID = flightID;
        this.flightName = flightName;
        this.departure = departure;
    }

    public String getFlightID() {
        return flightID;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getDeparture() {
        return departure;
    }

    @Override
    public String toString() {
        return "flights{" +
                "flightID='" + flightID + '\'' +
                ", flightName='" + flightName + '\'' +
                ", depature='" + departure + '\'' +
                '}';
    }
}
