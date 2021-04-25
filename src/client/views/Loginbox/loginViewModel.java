package client.views.Loginbox;

import client.model.ClientText;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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



     public boolean validateLoginInfo(){

     if (clientText.ValidateUser(navn.getValue(),kode.getValue())){
         return true;
     } else {
         error.setValue("det viker ikke ");
         return false;
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
