package server.model.database;

import shared.transferobjects.*;

import java.util.List;


public interface daoInterface
{

  List<myFlightTicket> ReadFlightList();

  void createTicket(myFlightTicket myFlightTicket);


  List<flights> getflights();
  List<seat> getSeat();
  Passenger CreatePassengers(String Firstname, String LastName, String TelNumber, String Email);

  Passenger Readpassenger(int passengerID);


  InputChat createChar(String str);
  List<InputChat> readChat();


  InputUser createUser(String txt) ;
  List<InputUser> readUser();










}
