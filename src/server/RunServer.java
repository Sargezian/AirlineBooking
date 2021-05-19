package server;

import server.model.ServerManagerImpl;
import server.networking.RMIServerImplement;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        RMIServerImplement rsi = new RMIServerImplement(new ServerManagerImpl());
        rsi.startServer();


    }


}


