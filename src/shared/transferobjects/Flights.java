package shared.transferobjects;


import java.io.Serializable;

public class Flights implements Serializable {

    public String flightID;
    public String flightName;
    public Depature departure;
    public Arrival arrival;
    public PlaneType planeType;
    public String price;

    public Flights(String flightID, String flightName, Depature departure, Arrival arrival, PlaneType planeType, String price) {
        this.flightID = flightID;
        this.flightName = flightName;
        this.departure = departure;
        this.arrival = arrival;
        this.planeType = planeType;
        this.price = price;
    }

    public Flights(String flightID, String flightName,String price) {
        this.flightID = flightID;
        this.flightName = flightName;
        this.price = price;
    }

    public Flights(String price)
    {
        this.price = price;
    }



    //departure
    public int getDepartureID() {
        return departure.departureID;
    }
    public String getDepartures() {
        return departure.departure;

    }
    public String getDepartureDate() {
        return departure.departureDate;
    }
    public Depature getDeparture() {
        return departure;
    }

    //arrival
    public String getArrivals() {
        return arrival.arrival;
    }
    public String getArrivalDate() {
        return arrival.arrivalDate;
    }
    public int getArrivalID() {
        return arrival.arrivalID;
    }
    public Arrival getArrival() {
        return arrival;
    }

    //flight
    public String getFlightID() {
        return flightID;
    }
    public String getFlightName() {
        return flightName;
    }
    public String getPrice() {
        return price;
    }

    //planetype
    public PlaneType getPlaneType() {
        return planeType;
    }
    public int getPlaneId() {
        return planeType.planeId;
    }
    public String getPlaneTypes() {
        return planeType.planeType;
    }

    @Override
    public String toString() {
        return "flights{" +
                "flightID=" + flightID +
                ", flightName='" + flightName + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", planeType=" + planeType +
                ", price=" + price +
                '}';
    }
}
