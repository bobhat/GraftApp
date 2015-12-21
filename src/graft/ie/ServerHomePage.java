package graft.ie;

import java.awt.event.ActionListener;
import java.rmi.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ServerHomePage extends Application implements EventHandler<javafx.event.ActionEvent>, ActionListener{

	private TextArea serverLogArea = new TextArea();
	private static ServerImp tempImp;
	
private static final String HOST = "localhost";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			System.out.println("Working 1");
			launch(args);
			System.out.println("After laubnch");
			
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		tempImp = new ServerImp(this);
		String rmiObjectName = "rmi://" + HOST + "/ServerInterfaces";
		Naming.rebind(rmiObjectName,tempImp);
		
		System.out.println("Binding Complete");
		
		System.out.println("display working");
		serverLogArea = new TextArea();
		Label serverLogLabel = new Label("Server Log Messages");
		serverLogLabel.setFont(new Font("ITC Bauhaus", 22));
		
		System.out.println("display working2");
		Button testButton = new Button();
		testButton.setOnAction(this);
		VBox testVboxBox = new VBox();
		testVboxBox.getChildren().add(testButton);
			
		this.serverLogArea.setText("Hello World");
		this.serverLogArea.setPrefSize(500, 500);
		serverLogArea.setEditable(false);
		
		
		BorderPane serverLogBorderPane = new BorderPane();
		serverLogBorderPane.setCenter(this.serverLogArea);
		serverLogBorderPane.setTop(serverLogLabel);
		serverLogBorderPane.setBottom(testVboxBox);
		System.out.println("display working3");
		Scene primaryScene = new Scene(serverLogBorderPane);
		//Stage primaryStage = new Stage();
		primaryStage.setTitle("Server Log Display");
		primaryStage.getIcons().add(new Image("image/blue-home-icon.png"));
		primaryStage.setScene(primaryScene);
		primaryStage.setMaxWidth(700);
		primaryStage.show();
		System.out.println("Step 1 homepage");
			
		System.out.println("Step 2 homepage");
		
	}

	public void handle(ActionEvent event) {
		//tempImp.checkUser();
		
	}

	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void setTestArea(String tempString){
		this.serverLogArea.appendText(tempString + "\n");
	}
		
	}
	

