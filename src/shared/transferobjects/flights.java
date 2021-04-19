package shared.transferobjects;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class flights implements Serializable {

    public int flightID;
    public String flightName;
    public String planeType;
    public Timestamp departure;
    public Timestamp arrival;
    public String from;
    public String to;
    public int price;

    public flights(int flightID, String flightName,  String planeType, Timestamp departure,
        Timestamp arrival, String from, String to, int price)
    {
        this.flightID = flightID;
        this.flightName = flightName;
        this.departure = departure;
        this.arrival = arrival;
        this.from = from;
        this.to = to;
        this.price = price;
        this.planeType = planeType;
    }

    public String getPlaneType()
    {
        return planeType;
    }

    public int getFlightID()
    {
        return flightID;
    }

    public String getFlightName()
    {
        return flightName;
    }

    public Timestamp getDeparture()
    {
        return departure;
    }

    public Timestamp getArrival()
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

    public int getPrice()
    {
        return price;
    }

    @Override public String toString()
    {
        return "flights{" + "flightID=" + flightID + ", flightName='"
            + flightName + '\'' + ", departure=" + departure + ", arrival="
            + arrival + ", from='" + from + '\'' + ", to='" + to + '\''
            + ", price=" + price + '}';
    }
}
