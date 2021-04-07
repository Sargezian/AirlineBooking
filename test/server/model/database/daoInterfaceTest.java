package server.model.database;

import org.junit.jupiter.api.Test;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class daoInterfaceTest
{



  @Test
  public void createChar() throws SQLException
  {
    daoInterface dao = new daoImpl();
    dao.createChar("hej wdet er fint");

  }

  @org.junit.jupiter.api.Test void readChat() throws SQLException {

    daoInterface dao = new daoImpl();
    InputChat inputUser =  dao.createChar("ww");

    assertEquals("ww",inputUser.getInput());




  }

  @org.junit.jupiter.api.Test void createUser() throws SQLException {
    daoInterface dao = new daoImpl();
    dao.createUser("tim");

  }

  @org.junit.jupiter.api.Test void readUser() throws SQLException {
    daoInterface dao = new daoImpl();
    InputUser p = dao.createUser("mike");

    assertEquals("mike",p.getOutput());
   assertNotNull(p.getId());


  }


}