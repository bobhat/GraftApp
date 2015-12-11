package graft.ie;

import java.rmi.server.UnicastRemoteObject;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class ServerImp extends UnicastRemoteObject implements ServerInterfaces {
	

	private ServerHomePage tester2;
	
	
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


	
		
	}
	

