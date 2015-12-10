package graft.ie;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ServerLogDisplay extends Application{
	
	private TextArea serverLogArea = new TextArea();
	private Label serverLogLabel = new Label("Server Log Messages");
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.display();
		
		
	}
	
	public void display(){
		
		System.out.println("display working");
		//serverLogArea = new TextArea();
		
		serverLogLabel.setFont(new Font("ITC Bauhaus", 22));
		
		System.out.println("display working2");
		Button testButton = new Button();
		VBox testVboxBox = new VBox();
		testVboxBox.getChildren().add(testButton);
			
		//this.serverLogArea.setText();
		this.serverLogArea.setPrefSize(500, 500);
		//serverLogArea.setEditable(false);
		
		
		BorderPane serverLogBorderPane = new BorderPane();
		serverLogBorderPane.setCenter(this.serverLogArea);
		serverLogBorderPane.setTop(serverLogLabel);
		serverLogBorderPane.setBottom(testVboxBox);
		System.out.println("display working3");
		Scene primaryScene = new Scene(serverLogBorderPane);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Server Log Display");
		primaryStage.getIcons().add(new Image("image/blue-home-icon.png"));
		primaryStage.setScene(primaryScene);
		primaryStage.setMaxWidth(700);
		primaryStage.show();
		
		
	}
	
	public void setLogs(String tempString)
	{
		this.serverLogArea.appendText(tempString);
	}

	public void setLabel(String tempString)
	{
		this.serverLogLabel.setText(tempString);
	}

	

}
