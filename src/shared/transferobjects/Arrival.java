package shared.transferobjects;

import java.io.Serializable;

public class Arrival implements Serializable {

    private int arrivalID;
    private String arrival;
    private String arrivalDate;
    private Airport airport;

    public Arrival(int arrivalID, String arrival, String arrivalDate) {
        this.arrivalID = arrivalID;
        this.arrival = arrival;
        this.arrivalDate = arrivalDate;
    }

    public Arrival(String arrival, String arrivalDate) {
        this.arrival = arrival;
        this.arrivalDate = arrivalDate;
    }

    public Arrival(String arrival)
    {
        this.arrival = arrival;
    }

    //airport
    public Airport getAirport() {
        return airport;
    }

    //arrival
    public int getArrivalID() {
        return arrivalID;
    }
    public String getArrival() {
        return arrival;
    }
    public String getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return "Arrival{" +
                "arrivalID=" + arrivalID +
                ", arrival='" + arrival + '\'' +
                ", arrivalDate=" + arrivalDate +
                '}';
    }

}
