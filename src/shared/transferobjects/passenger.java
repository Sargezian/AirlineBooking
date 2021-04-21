package shared.transferobjects;

import java.io.Serializable;

public class passenger implements Serializable
{
    public int passengerID;
    public String FirstName, LastName,TelNumber;
    public String Email;

    public passenger(int passengerID, String firstName, String lastName, String telNumber, String email) {
        this.passengerID = passengerID;
        FirstName = firstName;
        LastName = lastName;
        TelNumber = telNumber;
        Email = email;
    }


    public passenger(String firstName, String lastName, String telNumber, String email) {
        FirstName = firstName;
        LastName = lastName;
        TelNumber = telNumber;
        Email = email;
    }


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
}