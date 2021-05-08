package shared.transferobjects;

import java.io.Serializable;

public class Passenger implements Serializable
{
    public String passengerID;
    public String FirstName, LastName,TelNumber;
    public String Email;

    public Passenger(String passengerID, String firstName, String lastName, String telNumber, String email) {
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
    public String getPassengerID()
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
}