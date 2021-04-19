package shared.transferobjects;

import java.io.Serializable;

public class passenger implements Serializable
{
    public int passengerID;
    public String FirstName, LastName,TelNumber;

    public passenger(int passengerID, String telNumber, String firstName,
        String lastName ){
        this.passengerID = passengerID;
        TelNumber = telNumber;
        FirstName = firstName;
        LastName = lastName;
    }
    public passenger( String telNumber, String firstName,
        String lastName)
    {
        TelNumber = telNumber;
        FirstName = firstName;
        LastName = lastName;
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

    @Override public String toString()
    {
        return "passenger{" + "passengerID=" + passengerID + ", FirstName='"
            + FirstName + '\'' + ", LastName='" + LastName + '\''
            + ", TelNumber='" + TelNumber + '\'' + '}';
    }
}