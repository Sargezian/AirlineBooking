package client.views.createUser;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.ClientText;
import client.views.ViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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

        if (CreateUser != null && !"".equals(CreateUser) && CreatePassword != null && !"".equals(CreatePassword)) {
            clientText.username(CreateUser, CreatePassword);
            Error.set("korrekt oprettet");
        } else {
            Error.set("Feltet kan ikke være tomt");
        }
        this.Error.set("");
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


// TODO: 25/04/2021 = CREATE USER INSERT INTO SKAL VÆRE HER ISTEDET FOR LOGIN VIEWET

// TODO: 25/04/2021 = Login funktion skal virke her kopi'er fra troels eksempel og vis kun specifik min side.
}
