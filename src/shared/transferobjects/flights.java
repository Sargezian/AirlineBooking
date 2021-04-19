package shared.transferobjects;


import java.io.Serializable;

public class flights implements Serializable {

    public String flightID;
    public String flightName;
    public String departure;
    public String arrival;
    public String from;
    public String to;
    public String price;

    public flights(String flightID, String flightName, String departure, String arrival, String from, String to, String price) {
        this.flightID = flightID;
        this.flightName = flightName;
        this.departure = departure;
        this.arrival = arrival;
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public String getPrice() {
        return price;
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

    public String getArrival()
    {
        return arrival;
    }

    public String getFrom()
    {
        return from;
    }

    public String getTo()
    {
        return to;
    }

    @Override public String toString()
    {
        return "flights{" + "flightID='" + flightID + '\'' + ", flightName='"
            + flightName + '\'' + ", departure='" + departure + '\''
            + ", arrival='" + arrival + '\'' + ", from='" + from + '\''
            + ", to='" + to + '\'' + '}';
    }
}
