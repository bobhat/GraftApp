package graft.ie;

import java.awt.event.ActionEvent;

import javafx.application.Application;
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

public class test extends Application implements EventHandler<javafx.event.ActionEvent>{

	//private TextArea serverLogArea = new TextArea();
	private ServerLogDisplay testServerLogDisplay = new ServerLogDisplay();
	
public static void main(String[] args) {
		
	launch(args);
	

	}

@Override
public void start(Stage primaryStage) throws Exception {
	
	/*System.out.println("display working");
	serverLogArea = new TextArea();*/
	Label serverLogLabel = new Label("Server Log Messages");
	serverLogLabel.setFont(new Font("ITC Bauhaus", 22));
	
	System.out.println("display working2");
	Button testButton = new Button();
	testButton.setOnAction(this);
	VBox testVboxBox = new VBox();
	testVboxBox.getChildren().add(testButton);
		
	/*this.serverLogArea.setText("Hello World");
	this.serverLogArea.setPrefSize(500, 500);
	//serverLogArea.setEditable(false);*/
	
	
	BorderPane serverLogBorderPane = new BorderPane();
	//serverLogBorderPane.setCenter(this.serverLogArea);
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
	System.out.println("Step 1");
	
	
	System.out.println("Step 2");
	testServerLogDisplay.display();
	
	
	String temp = "me and you in trouble";
	
	testServerLogDisplay.setLogs(temp);
	
	
	
}

public void handle(ActionEvent event) {
	
	
	
}

public void handle(javafx.event.ActionEvent event) {
	this.testServerLogDisplay.setLogs("Happy Birthday Olivia!!!\n");
	this.testServerLogDisplay.setLabel("John");
	
}

	
}
