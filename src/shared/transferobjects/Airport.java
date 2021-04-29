package shared.transferobjects;

import java.io.Serializable;

public class Airport implements Serializable {


    public int AirportID;
    public Depature depature;

    public Airport(int airportID, Depature depature) {
        AirportID = airportID;
        this.depature = depature;
    }

    public int getDepartureID() {
        return depature.departureID;
    }

    public int getAirportID() {
        return AirportID;
    }

    public Depature getDepature() {
        return depature;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "AirportID=" + AirportID +
                ", depature=" + depature +
                '}';
    }


}
