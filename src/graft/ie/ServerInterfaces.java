package graft.ie;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterfaces extends Remote{
	public void checkUser()
	
			throws RemoteException;
			public void clientSearch(PropDetailsBean clientSearchBean) throws RemoteException;
	
	
	
	
	

}
