package graft.ie;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImp extends UnicastRemoteObject implements ServerInterfaces  {
	
	protected ServerImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean checkUser()	{
		System.out.println("IMP working");
		return true;
	}

}
