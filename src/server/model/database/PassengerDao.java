package server.model.database;

import shared.transferobjects.Passenger;

public interface PassengerDao {

    Passenger CreatePassengers(String Firstname, String LastName, String TelNumber, String Email);

    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);

}
