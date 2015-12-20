package graft.ie;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ClientImp {
	private static final String HOST = "localhost";
	
	
	public  ArrayList<PropDetailsBean> clientSearch(SearchBean clientSearchBean){
		ArrayList<PropDetailsBean> clientSearchBeans = new ArrayList<PropDetailsBean>();
		
		try {
			ServerInterfaces serverInt = (ServerInterfaces)Naming.lookup("rmi://" + HOST + "/ServerInterfaces");
			
			clientSearchBeans = serverInt.clientSearch(clientSearchBean);
			System.out.println("Leaving Search::Server");
			System.out.println(clientSearchBeans.size());
			
													
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientSearchBeans;	
	}
	
	public boolean checkAgent(AgentBean agentRequestBean){
		boolean resultBoolean = false;
		
		try {
			ServerInterfaces serverInt = (ServerInterfaces)Naming.lookup("rmi://" + HOST + "/ServerInterfaces");
			
			resultBoolean = serverInt.checkAgent(agentRequestBean);
			System.out.println("Leaving Search::Server" + resultBoolean );
															
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultBoolean;
	}
	public  ArrayList<PropDetailsBean> agentSearch(AgentBean agentSearchBean){
		ArrayList<PropDetailsBean> agentSearchBeans = new ArrayList<PropDetailsBean>();
		
		try {
			ServerInterfaces serverInt = (ServerInterfaces)Naming.lookup("rmi://" + HOST + "/ServerInterfaces");
			
			agentSearchBeans = serverInt.agentSearch(agentSearchBean);
			System.out.println("Leaving Search::Server");
			System.out.println(agentSearchBeans.size());
			
													
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return agentSearchBeans;	
	}
	
	
	public  void updateNewProp(PropDetailsBean newPropBean){
			
		try {
			ServerInterfaces serverInt = (ServerInterfaces)Naming.lookup("rmi://" + HOST + "/ServerInterfaces");
			
			serverInt.updateNewProp(newPropBean);
			System.out.println("Leaving Search::Server");
			
			
													
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
