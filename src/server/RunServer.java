package server;

import server.model.TextManagerImpl;
import server.networking.RMIServerImplement;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        RMIServerImplement rsi = new RMIServerImplement(new TextManagerImpl());
        rsi.startServer();
    }
}
