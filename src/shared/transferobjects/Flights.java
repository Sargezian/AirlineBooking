package shared.transferobjects;


import java.io.Serializable;

public class Flights implements Serializable {

    private String flightID;
    private String flightName;
    private Depature departure;
    private Arrival arrival;
    private PlaneType planeType;
    private String price;

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
        Flights flights = new Flights("1","sas",new Depature(1,"KBH","2021-08-08 19:30:00"),new Arrival(1,"AAR","2021-09-08 19:30:00")
                ,new PlaneType(1,"Airbus7"),"200");
        this.price = price;
    }

    public Flights(Arrival arrival) {
        this.arrival = arrival;
    }

    public Flights(Depature departure) {
        this.departure = departure;
    }

    public Flights(PlaneType planeType) {
        this.planeType = planeType;
    }

    //departure
    public int getDepartureID() {
        return departure.getDepartureID();
    }
    public String getDepartures() {
        return departure.getDeparture();

    }
    public String getDepartureDate() {
        return departure.getDepartureDate();
    }
    public Depature getDeparture() {
        return departure;
    }

    //arrival
    public String getArrivals() {
        return arrival.getArrival();
    }
    public String getArrivalDate() {
        return arrival.getArrivalDate();
    }
    public int getArrivalID() {
        return arrival.getArrivalID();
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
        return planeType.getPlaneId();
    }
    public String getPlaneTypes() {
        return planeType.getPlaneType();
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
