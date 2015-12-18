package graft.ie;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerInterfaces extends Remote{
	public void checkUser()throws RemoteException;
	public ArrayList<PropDetailsBean> clientSearch(PropDetailsBean clientSearchBean) throws RemoteException;

}
