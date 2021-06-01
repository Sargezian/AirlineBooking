package shared.networking;

import client.network.RMIClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.ServerManagerImpl;
import server.networking.RMIServerImplement;


import java.rmi.AlreadyBoundException;

import java.rmi.RemoteException;


import static org.junit.jupiter.api.Assertions.*;

class RMIServerTest {

    private RMIClient rmiClient;


    @BeforeEach
    public void setup() throws RemoteException, AlreadyBoundException {

         rmiClient = new RMIClient();
         rmiClient.startClient();
    }

    @Test
    public void TestIfWeCanGetFlightsFromServer() {

        assertEquals(6,rmiClient.getflights().size());

    }




}