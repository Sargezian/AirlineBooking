package client.core;

import client.model.ClientModel;
import client.model.ClientModelManager;


public class ModelFactory {


    private ClientModel clientModel;
    private static ModelFactory modelFactory;

    private ModelFactory() {

    }

    public static ModelFactory getInstance()
    {
        if (modelFactory == null)
        {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    public ClientModel getClientText() {
        if (clientModel == null)
            clientModel = new ClientModelManager(ClientFactory.getInstance().getClient());
        return clientModel;
    }


}


