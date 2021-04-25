package client.views.Loginbox;

import client.core.ViewHandler;
import client.model.ClientText;
import client.views.chat.chatViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class loginViewModel {
    private ClientText clientText;
    private StringProperty navn;
    private StringProperty kode;
    private StringProperty error;


    public loginViewModel(ClientText clientText) {
        this.clientText = clientText;

    }



}
