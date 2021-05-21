package client.core;

import client.network.Client;
import client.network.RMIClient;

public class ClientFactory {

    private Client client;
    private static ClientFactory clientFactory;

    private ClientFactory() {

    }

    public static ClientFactory getInstance(){
        if (clientFactory == null){
            clientFactory = new ClientFactory();
        }
        return clientFactory;
    }

    public  Client getClient() {
        if (client == null) {
            client = new RMIClient();
        }
        return client;
    }

}
