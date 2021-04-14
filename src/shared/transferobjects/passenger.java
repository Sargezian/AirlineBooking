package shared.transferobjects;

public class passenger {

    public String passengerID;
    public String name;

    public passenger(String passengerID, String name) {
        this.passengerID = passengerID;
        this.name = name;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "passenger{" +
                "passengerID='" + passengerID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
