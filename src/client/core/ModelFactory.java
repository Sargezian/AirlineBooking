package client.core;

import client.model.ClientText;
import client.model.ClientTextManager;

public class ModelFactory {

    private final ClientFactory cf;
    private ClientText clientText;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
    }

    public ClientText getClientText() {
        if(clientText == null)
            clientText = new ClientTextManager(cf.getClient());
        return clientText;
    }
}


