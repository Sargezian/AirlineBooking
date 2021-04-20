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
  private InputChatDao inputChatDao;
  private InputUserDao inputUserDao;
  private InputChatDao daoq;

@BeforeEach
 public void createDao() throws SQLException {
  dao = daoImpl.getInstance();
  daoq = (InputChatDao) InputChatImpl.getInstance();
  }

  @Test
  public void createChar() throws SQLException
  {
    daoq.createChar("hej wdet er fint");
    //daoq.createChar("hej wdet er fint");
    //dao.CreatePassengers("BOB","BOBO","123");
  }

  @Test public void readChat() throws SQLException {
    //dao.readChat();
    InputChat c =  inputChatDao.createChar("ww");
    assertEquals("ww",c.getInput());
  }

  @Test public void createUser() throws SQLException {
 dao.getflights();
  }

  @Test public void readUser() throws SQLException {
    InputUser u = inputUserDao.createUser("mike");
    assertEquals("mike",u.getOutput());
  }

    @Test public void getSeat() throws SQLException {
        dao.getSeat();
    }

}