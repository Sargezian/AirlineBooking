package shared.transferobjects;

import java.io.Serializable;

public class Airport implements Serializable {

    // TODO: 08/05/2021 fjerne metoder vi ikke bruger og ændre metodenavne til det rigtige (alle)

    public int AirportID;
    public Depature depature;

    public Airport(int airportID, Depature depature) {
        AirportID = airportID;
        this.depature = depature;
    }

    //airport
    public int getAirportID() {
        return AirportID;
    }

    //departure
    public int getDepartureID() {
        return depature.departureID;
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
