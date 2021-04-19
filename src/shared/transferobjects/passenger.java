package shared.transferobjects;

import java.io.Serializable;

public class passenger implements Serializable {

    public int passengerID;
    public String name;

    public passenger(int passengerID, String name) {
        this.passengerID = passengerID;
        this.name = name;
    }

    public int getPassengerID() {
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
