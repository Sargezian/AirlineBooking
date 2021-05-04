package client.views.createUser;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.ClientText;
import client.model.SaveInfo;
import client.views.ViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.InputUser;
import shared.transferobjects.flights;

import java.beans.PropertyChangeListener;

public class createUserViewModel  {

   private ClientText clientText;
    private StringProperty CreateUser;
    private StringProperty CreatePassword;
    private StringProperty Error;

    
    public createUserViewModel(ClientText clientText) {
        this.clientText = clientText;
        CreateUser = new SimpleStringProperty();
        CreatePassword = new SimpleStringProperty();
        Error = new SimpleStringProperty();

    }

    public void SetUser() {
        String CreateUser = this.CreateUser.getValue();
        String CreatePassword = this.CreatePassword.getValue();



        if (CreateUser != null && !"".equals(CreateUser) && CreatePassword != null && !"".equals(CreatePassword)  ) {
            InputUser username = clientText.username(CreateUser, CreatePassword);
            SaveInfo.getInstance().setUser(username);

            Error.set("korrekt oprettet");
        } else {
            Error.set("Feltet kan ikke være tomt");
        }
        this.Error.set("");
    }

    public boolean userValidation(){
      SaveInfo.getInstance().setUser(clientText.readUsername(this.CreateUser.getValue()));
      InputUser user = SaveInfo.getInstance().getUser();
      if (user != null){

        if (CreateUser.getValue().equals(user.getOutput())){

            Error.set("Username already exist");
            return false;
        }
      }
        return true;
    }

    public void clearFields() {
        CreateUser.setValue("");
        CreatePassword.setValue("");
        Error.setValue("");

    }


    public String getCreateUser() {
        return CreateUser.get();
    }

    public StringProperty createUserProperty() {
        return CreateUser;
    }

    public String getCreatePassword() {
        return CreatePassword.get();
    }

    public StringProperty createPasswordProperty() {
        return CreatePassword;
    }

    public String getError() {
        return Error.get();
    }

    public StringProperty errorProperty() {
        return Error;
    }

    public boolean attemptCreateUser() {

        if(CreateUser.getValue() == null) {
            Error.set("Username cannot be empty");
            return false;

        }
        if(CreateUser.getValue().contains("#")) {
           Error.set("Username cannot contain #");
            return false;
        }
        if(CreateUser.getValue().length() < 4) {
            Error.set("Username must contain more than 3 characters");
            return false;
        }
        if(CreateUser.getValue().length() > 14) {
          Error.set("Username must contain less than 15 characters");
            return false;
        } else {
            return true;
        }

    }

    public boolean validatePasswords() {

        if (CreatePassword.getValue() == null) {
            Error.set("Password cannot be empty");
            return false;
        }
        if (CreatePassword.getValue().length() < 8) {
            Error.set("Password length must be 8 or more");
            return false;
        }
        if (CreatePassword.getValue().length() > 14) {
            Error.set("Password length must be 14 or less");
            return false;
        }

        if (CreatePassword.getValue().contains("#")) {
            Error.set("Password cannot contain #");
            return false;
        }

        if (!CreatePassword.getValue().matches(".*\\d.*")) {
            Error.set("Password must contain at least one number");
            return false;
        } else {

            return true;

        }


    }


    /*public void addListener(String name, PropertyChangeListener listener) {
        support.addPropertyChangeListener(name, listener);
    }*/



    /*@Override
    public void createUser(String username, String pw, String pwAgain) {
        String result = attemptCreateUser(username, pw, pwAgain);

        if("OK".equals(result)) {
            // adding the new user
            users.add(new User(username, pw));
        }

        support.firePropertyChange("CreateUserResult", "", result);
    }

    */


   /* private String attemptCreateUser(String username, String pw, String pwAgain) {
        if(username == null) {
            return "Username cannot be empty";
        }
        if(username.contains("#")) {
            return "Username cannot contain #";
        }
        if(username.length() < 4) {
            return "Username must contain more than 3 characters";
        }
        if(username.length() > 14) {
            return "Username must contain less than 15 characters";
        }
        if(findUser(username) != null) {
            return "Username already exists";
        }

        // checking the passwords
        return validatePasswords(pw, pwAgain); // returning result of checking passwords
    }*/



}
