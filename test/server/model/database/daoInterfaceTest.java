package server.model.database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class daoInterfaceTest
{
  private daoInterface dao;

@BeforeEach
 public void createDao() throws SQLException {
  dao = new daoImpl();
  }

  @Test
  public void createChar() throws SQLException
  {
    dao.createChar("hej wdet er fint");
  }

  @Test public void readChat() throws SQLException {
    //dao.readChat();
    InputChat c =  dao.createChar("ww");
    assertEquals("ww",c.getInput());
  }

  @Test public void createUser() throws SQLException {
     dao.createUser("tim");
  }

  @Test public void readUser() throws SQLException {
    InputUser u = dao.createUser("mike");
    assertEquals("mike",u.getOutput());
  }
}