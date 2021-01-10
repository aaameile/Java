package Rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiTest extends Remote {
    String say(String some) throws RemoteException;
}
