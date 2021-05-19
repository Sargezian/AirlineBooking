package client.core;

import client.model.ClientModel;
import client.model.ClientModelManager;

public class ModelFactory {

    private final ClientFactory cf;
    private ClientModel clientModel;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
    }

    public ClientModel getClientText() {
        if (clientModel == null)
            clientModel = new ClientModelManager(cf.getClient());
        return clientModel;
    }
}


