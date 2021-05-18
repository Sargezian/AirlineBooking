package shared.transferobjects;

import java.io.Serializable;
import java.util.Objects;

public class Passenger implements Serializable
{
    public int passengerID;
    public String FirstName, LastName,TelNumber;
    public String Email;

    public Passenger(int passengerID, String firstName, String lastName, String telNumber, String email) {
        this.passengerID = passengerID;
        FirstName = firstName;
        LastName = lastName;
        TelNumber = telNumber;
        Email = email;
    }

    public Passenger(String firstName, String lastName, String telNumber, String email) {
        FirstName = firstName;
        LastName = lastName;
        TelNumber = telNumber;
        Email = email;
    }

    public Passenger(String email) {
        this.Email = email;
    }

    //passenger
    public String getEmail() {
        return Email;
    }
    public int getPassengerID()
    {
        return passengerID;
    }
    public String getTelNumber()
    {
        return TelNumber;
    }
    public String getFirstName()
    {
        return FirstName;
    }
    public String getLastName()
    {
        return LastName;
    }

    @Override
    public String toString() {
        return "passenger{" +
                "passengerID=" + passengerID +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", TelNumber='" + TelNumber + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return getPassengerID() == passenger.getPassengerID() && Objects.equals(getFirstName(), passenger.getFirstName()) && Objects.equals(getLastName(), passenger.getLastName()) && Objects.equals(getTelNumber(), passenger.getTelNumber()) && Objects.equals(getEmail(), passenger.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassengerID(), getFirstName(), getLastName(), getTelNumber(), getEmail());
    }
}