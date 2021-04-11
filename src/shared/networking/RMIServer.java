package shared.networking;

import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote {

    InputChat sendMsg(String str) throws RemoteException;
    List<InputChat> getChat() throws RemoteException;
    InputUser username(String txt) throws RemoteException;
    List<InputUser> getUser() throws RemoteException;
    void registerClient(ClientCallBack client) throws RemoteException;
    void registerClient2(ClientCallBack client) throws RemoteException;

}
