package shared.transferobjects;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class flights implements Serializable {

    public int flightID;
    public String flightName;
    public Depature departure;
    public Arrival arrival;
    public PlaneType planeType;
    public int price;

    public flights(int flightID, String flightName, Depature departure, Arrival arrival, PlaneType planeType, int price) {
        this.flightID = flightID;
        this.flightName = flightName;
        this.departure = departure;
        this.arrival = arrival;
        this.planeType = planeType;
        this.price = price;
    }

    public int getDepartureID() {
        return departure.departureID;
    }

    public int getArrivalID() {
        return arrival.arrivalID;
    }

    public String getDepartures() {
        return departure.departure;

    }

    public Timestamp getDepartureDate() {
        return departure.departureDate;
    }

    public String getArrivals() {
        return arrival.arrival;
    }

    public Timestamp getArrivalDate() {
        return arrival.arrivalDate;
    }

    public int getFlightID() {
        return flightID;
    }

    public String getFlightName() {
        return flightName;
    }

    public Depature getDeparture() {
        return departure;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public int getPlaneId() {
        return planeType.planeId;
    }

    public String getPlaneTypes() {
        return planeType.planeType;
    }

    public int getPrice() {
        return price;
    }
}
