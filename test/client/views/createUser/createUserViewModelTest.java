package client.views.createUser;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.InputUserImpl;
import shared.transferobjects.InputUser;

import static org.junit.jupiter.api.Assertions.*;

class createUserViewModelTest
{
  private createUserViewModel vm;

  /*@BeforeEach public setup(){
    InputUserImpl model = new InputUserImpl();
    model.ValidateUser("Mark", "12345678");

  }*/

  @Test void setUser()
  {
  }

/*  @Test void userValidation()
  {
     StringProperty CreateUser = new SimpleStringProperty();
     StringProperty CreatePassword = new SimpleStringProperty();
     vm.createUserProperty().bindBidirectional(CreateUser);
     vm.createPasswordProperty().bindBidirectional(CreatePassword);

     // act
    CreateUser.setValue("Mark");
    CreatePassword.setValue("hejmeddig");
    vm.attemptCreateUser();

    // assert
    assertEquals(1,vm.attemptCreateUser());

  }*/

  @Test void clearFields()
  {
  }

  @Test void getCreateUser()
  {
  }

  @Test void createUserProperty()
  {
  }

  @Test void getCreatePassword()
  {
  }

  @Test void createPasswordProperty()
  {
  }

  @Test void getError()
  {
  }

  @Test void errorProperty()
  {
  }

  @Test void attemptCreateUser()
  {
  }

  @Test void validatePasswords()
  {
    StringProperty CreatePassword = new SimpleStringProperty();
    vm.createPasswordProperty().bindBidirectional(CreatePassword);
    //act
    CreatePassword.setValue("hejmeddig");

    //assert
    assertEquals("hejmeddig",CreatePassword);

  }

  @Test void setUser()
  {
  }

  @Test void userValidation()
  {
  }

  @Test void testClearFields()
  {
  }

  @Test void testGetCreateUser()
  {
  }

  @Test void testCreateUserProperty()
  {
  }

  @Test void testGetCreatePassword()
  {
  }

  @Test void testCreatePasswordProperty()
  {
  }

  @Test void testGetError()
  {
  }

  @Test void testErrorProperty()
  {
  }

  @Test void testAttemptCreateUser()
  {
  }

  @Test void testValidatePasswords()
  {
  }
}