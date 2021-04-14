package server.model.database;

import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.transferobjects.flights;

import java.sql.SQLException;
import java.util.List;

public interface daoInterface
{
  InputChat createChar(String str);
  List<InputChat> readChat();
  InputUser createUser(String txt) ;
  List<InputUser> readUser();
  List<flights> getflights();

  void update(InputChat inputchat) ;
  void update(InputUser inputuser) ;
  void remove(InputChat inputChat) ;
  void remove(InputUser inputUser);
}