package shared.networking;

import org.junit.jupiter.api.BeforeEach;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class RMIServerTest {

/*
    @BeforeEach
    public static void setup() throws RemoteException, AlreadyBoundException {
        CalculatorImpl calculator = new CalculatorImpl();
        RemoteCalculator stub = (RemoteCalculator) UnicastRemoteObject.exportObject(calculator, 0);

        Registry registry = LocateRegistry.createRegistry(36973);
        registry.bind("calculator", stub);
    }

    @Test
    public void somarTest() throws RemoteException, AlreadyBoundException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(36973);
        RemoteCalculator remoteCalculator = (RemoteCalculator) registry.lookup("calculator");
        Cliente cliente = new Cliente(remoteCalculator);
        Assert.assertEquals(12, cliente.calculate(5, 7, Operador.SOMA));
    }*/



}