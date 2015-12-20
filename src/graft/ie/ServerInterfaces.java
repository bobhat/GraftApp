package graft.ie;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerInterfaces extends Remote{
	public void checkUser()throws RemoteException;
	public ArrayList<PropDetailsBean> clientSearch(SearchBean clientSearchBean) throws RemoteException;
	public boolean checkAgent(AgentBean logBean) throws RemoteException;
	public ArrayList<PropDetailsBean> agentSearch(AgentBean agentSearchBean) throws RemoteException;
	public void updateNewProp(PropDetailsBean newPropBean) throws RemoteException;

}
