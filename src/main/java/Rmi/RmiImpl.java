package Rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiImpl extends UnicastRemoteObject implements RmiTest{
    private static final long serialVersionUID = 123456789;
    public RmiImpl() throws RemoteException {
        super();
    }
    @Override
    public String say(String some) throws RemoteException {
        return "hello" + some;
    }
}
