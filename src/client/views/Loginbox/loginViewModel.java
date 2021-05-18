package client.views.Loginbox;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.*;


public class loginViewModel {
    private ClientText clientText;
    private StringProperty navn;
    private StringProperty kode;
    private StringProperty error;


    public loginViewModel(ClientText clientText) {
        this.clientText = clientText;
        navn = new SimpleStringProperty();
        kode = new SimpleStringProperty();
        error =  new SimpleStringProperty();

    }



    public void clearFields() {
        navn.setValue("");
        kode.setValue("");
        error.setValue("");
    }

    public boolean validateLoginInfo() {

        if (clientText.ValidateUser(navn.getValue(), kode.getValue())) {
            InputUser user = clientText.readUser(navn.getValue(), kode.getValue());
            SaveInfo.getInstance().setUser(user);

            return true;
        } else {
            error.setValue("ERROR field is empty");
            return false;
        }
    }

    public void validateAdmin() {

        if (navn.equals("Admin123@") && kode.equals("Admin")) {
            System.out.println("virker");
        }
    }

    public String getNavn() {
        return navn.get();
    }

    public StringProperty navnProperty() {
        return navn;
    }

    public String getKode() {
        return kode.get();
    }

    public StringProperty kodeProperty() {
        return kode;
    }

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }
}
