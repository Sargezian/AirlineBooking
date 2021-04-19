package server.model.database;

import shared.transferobjects.*;

import java.util.List;


public interface daoInterface
{
  InputChat createChar(String str);
  List<InputChat> readChat();
  InputUser createUser(String txt) ;
  List<InputUser> readUser();
  List<flights> getflights();

  List<seat> getSeat();

  List<passenger> getPassenger();
  List<Myflightlist> ReadFlightList();


/*  void getUpdate(flights flights);*/

  void createTicket(Myflightlist myflightlist);



  //admins metoder
 /* void update(InputChat inputchat);
  void update(InputUser inputuser);
  void remove(InputChat inputChat);
  void remove(InputUser inputUser);*/



}
