package server.model.database;

import shared.transferobjects.Passenger;

import java.util.List;

public interface PassengerDao {

    Passenger CreatePassengers(String Firstname, String LastName, String TelNumber, String Email);
    Passenger ReadPassenger(String Firstname, String LastName, String TelNumber, String Email);
    List<Passenger> ReadAllThePassengers(); // bruges i passengerDaotest

}
