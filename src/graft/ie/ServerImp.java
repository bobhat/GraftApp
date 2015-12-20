package graft.ie;

import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class ServerImp extends UnicastRemoteObject implements ServerInterfaces {
	

	private ServerHomePage tester2;
	String clientIP;
	private AgentBean agentSearchBean;
	private PropDetailsBean checkingBean;
	
	protected ServerImp(ServerHomePage tempTester) throws Exception {
		super();
		System.out.println("in ServerImp Constructor");
		this.tester2 = tempTester;
	}
	
	protected ServerImp() throws Exception {
		super();
		System.out.println("in ServerImp Constructor");
	}

	private static final long serialVersionUID = 1L;
	
	public void updateNewProp(PropDetailsBean newPropBean)	{
		checkingBean = newPropBean;
		
		System.out.println("IMP working");
		try {
			clientIP = getClientHost();
		} catch (ServerNotActiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Platform.runLater(new Runnable() {
			  public void run() {
				  tester2.setTestArea("Client: " + clientIP + " Add new Property type:: " + checkingBean.getPropTypeString());
				  
			  }
			  });
		
		DBQuery clientSearchResult = new DBQuery();
		
		clientSearchResult.updateNewProp(newPropBean);
		
	}
	
	
	public void checkUser()	{
		System.out.println("IMP working");
		
		Platform.runLater(new Runnable() {
			  public void run() {
				  tester2.setTestArea("All working!!!!ALL WORKING!!!!");
				  
			  }
			  });
	}
	
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}

	public ArrayList<PropDetailsBean> clientSearch(SearchBean clientSearchBean) {
			// TODO Auto-generated method stub
		ArrayList<PropDetailsBean> resultArrayList = new ArrayList<PropDetailsBean>();
		
		try {
			clientIP = getClientHost();
		} catch (ServerNotActiveException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Platform.runLater(new Runnable() {
			  public void run() {
				
			tester2.setTestArea("Client IP: " + clientIP + " requesting a Property Search!!!!");	  
				 
			} 
	  });
		
		DBQuery clientSearchResult = new DBQuery();
		
		resultArrayList = clientSearchResult.clientSearch(clientSearchBean);
		
		updateServerDisplay("Return Query result");
		
		return resultArrayList;
			
	}
	
	public ArrayList<PropDetailsBean> agentSearch(AgentBean agentSearchBean) {
		// TODO Auto-generated method stub
	ArrayList<PropDetailsBean> resultArrayList = new ArrayList<PropDetailsBean>();
	try {
		clientIP = getClientHost();
	} catch (ServerNotActiveException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Platform.runLater(new Runnable() {
		  public void run() {
			
		tester2.setTestArea("Client IP: " + clientIP + " requesting a Property Search!!!!");	  
			 
		} 
  });
	
	DBQuery clientSearchResult = new DBQuery();
	
	resultArrayList = clientSearchResult.agentSearch(agentSearchBean);
	
	updateServerDisplay("Return Query result");
	
	return resultArrayList;
		
}

	public void updateServerDisplay(final String updateString)
    {
	
    	Platform.runLater(new Runnable() {
			  public void run() {
				
			tester2.setTestArea("\n" + updateString);	  
				 
			} 
	  });
		
	}
    
    public boolean checkAgent(AgentBean agentDetails)
    {
    	updateServerDisplay("Agent trying to login");
    	DBQuery clientSearchResult = new DBQuery();
    	boolean resutlBoolean = false;
    	resutlBoolean = clientSearchResult.checkAgent(agentDetails);
    	return resutlBoolean;
    }
    
    public AgentBean getAgentBean(){
    	return agentSearchBean;
    }
}

