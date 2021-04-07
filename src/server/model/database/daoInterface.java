package server.model.database;

import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;

import java.sql.SQLException;
import java.util.List;

public interface daoInterface
{
  InputChat createChar(String str) throws SQLException;
  List<InputChat> readChat() throws SQLException;
InputUser createUser(String txt) throws SQLException;
 List<InputUser> readUser( )throws SQLException;
}
