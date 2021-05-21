package client.views.Loginbox;

import client.core.ModelFactory;
import client.model.ClientModel;
import client.model.ClientModelManager;
import client.model.SaveInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.*;

public class loginViewModel {
    private ClientModel clientModel ;
    private StringProperty navn;
    private StringProperty kode;
    private StringProperty error;

    //constructor
    public loginViewModel(ClientModel clientModel) {
        this.clientModel = clientModel;
        navn = new SimpleStringProperty();
        kode = new SimpleStringProperty();
        error =  new SimpleStringProperty();

    }


    //clearfields
    public void clearFields() {
        navn.setValue("");
        kode.setValue("");
        error.setValue("");
    }

    //validate
    public boolean validateLoginInfo() {

        if (clientModel.ValidateUser(navn.getValue(), kode.getValue())) {
            InputUser user = clientModel.readUser(navn.getValue(), kode.getValue());
            SaveInfo.getInstance().setUser(user);
            error.setValue("successful");

            return true;
        } else {
            error.setValue("ERROR field is empty");
            return false;
        }
    }

    //validate
    public void validateAdmin() {

        if (navn.equals("Admin123@") && kode.equals("Admin")) {
            System.out.println("virker");
        }
    }


    public StringProperty navnProperty() {
        return navn;
    }
    public StringProperty kodeProperty() {
        return kode;
    }
    public StringProperty errorProperty() {
        return error;
    }
}
