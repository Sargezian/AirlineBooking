package server.networking;

import server.model.TextManager;
import shared.networking.ClientCallBack;
import shared.networking.RMIServer;
import shared.transferobjects.InputChat;
import shared.transferobjects.InputUser;
import shared.util.utils;

import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServerImplement implements RMIServer {

    private final TextManager textManager;

    public RMIServerImplement(TextManager textManager) throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.textManager = textManager;
    }

    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(utils.PORT_NR);
        registry.bind(utils.SERVER,this);
    }

    @Override
    public String sendMsg(String str) {
        return textManager.sendMsg(str);
    }

    @Override
    public List<InputChat> getChat()  {
        return textManager.getChat();
    }

    @Override
    public String username(String txt)  {
        return textManager.username(txt);
    }

    @Override
    public List<InputUser> getUser()  {
        return textManager.getUser();
    }

    @Override
    public void registerClient(ClientCallBack client) {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
                listener = evt -> {
            try {
                client.updateChat((InputChat) evt.getNewValue());
            } catch (RemoteException e) {

                textManager.removeListener(utils.NEWCHAT, finalListener);
            }
        };
            textManager.addListener(utils.NEWCHAT, listener);
        }

    @Override
    public void registerClient2(ClientCallBack client) {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                client.updateUser((InputUser) evt.getNewValue());
            } catch (RemoteException e) {

                textManager.removeListener(utils.NEWUSER, finalListener);
            }
        };
        textManager.addListener(utils.NEWUSER, listener);
    }

    }
