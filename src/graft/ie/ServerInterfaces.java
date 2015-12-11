package graft.ie;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterfaces extends Remote{
	public void checkUser()
			throws RemoteException;

}
