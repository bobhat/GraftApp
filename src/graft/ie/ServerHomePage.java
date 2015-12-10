package graft.ie;

import java.rmi.*;

import javafx.application.Application;
import javafx.stage.Stage;

public class ServerHomePage extends Application{

private static final String HOST = "localhost";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			System.out.println("Working 1");
			ServerImp tempImp = new ServerImp();
			System.out.println("Working 2");
			String rmiObjectName = "rmi://" + HOST + "/ServerInterfaces";
			System.out.println("Working 3");
			Naming.rebind(rmiObjectName,(Remote) tempImp);
			
			System.out.println("Binding Complete");
			tempImp.checkUser();
			
			
			
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
