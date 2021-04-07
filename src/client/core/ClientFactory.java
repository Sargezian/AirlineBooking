package client.core;

import client.network.Client;
import client.network.RMIClient;

public class ClientFactory {

    private static Client client;

    public static Client getClient() {
        if (client == null) {
           client = new RMIClient();
        }
        return client;
    }
}
