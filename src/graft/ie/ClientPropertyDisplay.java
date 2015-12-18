package graft.ie;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientPropertyDisplay extends Application {
	
	private Stage primaryStage;
	private ClientDisplayGrid propGridPane1;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("ClientPropertyDisplay -> start()");
		this.primaryStage = primaryStage;
				
		//Testing: passing a Arraylist of Bean(PropDetailsBean) all static details
		
		ArrayList<PropDetailsBean> testArray = new ArrayList<PropDetailsBean>();
		Image tempImage = new Image("image/House1.png");
		
		PropDetailsBean testBean1 = new PropDetailsBean(tempImage, 100.00);
		testArray.add(testBean1);
		PropDetailsBean testBean2 = new PropDetailsBean(tempImage, 200.00);
		testArray.add(testBean2);
		PropDetailsBean testBean3 = new PropDetailsBean(tempImage, 300.00);
		testArray.add(testBean3);
		
		//not sure if need to do this
		
		this.propGridPane1 = new ClientDisplayGrid(testArray);
					
		BorderPane propDetailsBorderPane = new BorderPane();
		propDetailsBorderPane.setCenter(propGridPane1.getDisplay());
		propDetailsBorderPane.setTop(propGridPane1.getWelcomeLabel());
		propDetailsBorderPane.setPadding(new Insets(20,20,20,20));
		Scene primaryScene = new Scene(propDetailsBorderPane);
		
		primaryStage.setTitle("Property List");
		primaryStage.getIcons().add(new Image("image/blue-home-icon.png"));
		primaryStage.setScene(primaryScene);
		primaryStage.setMaxWidth(700);
		primaryStage.show();
	}
	
	public void display(ArrayList<PropDetailsBean> propDetails){
		System.out.println("ClientPropertyDisplay -> display()");
		this.propGridPane1 = new ClientDisplayGrid(propDetails);
		
		System.out.println("ClientPropertyDisplay -> out of Grid");
		BorderPane propDetailsBorderPane = new BorderPane();
		propDetailsBorderPane.setCenter(propGridPane1.getDisplay());
		
		
		
		propDetailsBorderPane.setTop(propGridPane1.getWelcomeLabel());
		
		propDetailsBorderPane.setPadding(new Insets(20,20,20,20));
		Scene primaryScene1 = new Scene(propDetailsBorderPane);
		System.out.println("ClientPropertyDisplay -> before::primaryStage");
		
		this.primaryStage = new Stage();
		this.primaryStage.setTitle("Property List");
		System.out.println("ClientPropertyDisplay -> before :new image added");
		this.primaryStage.getIcons().add(new Image("image/blue-home-icon.png"));
		System.out.println("ClientPropertyDisplay -> new image added");
		this.primaryStage.setScene(primaryScene1);
		this.primaryStage.setMaxWidth(700);
		System.out.println("ClientPropertyDisplay -> about to show()");
		this.primaryStage.show();
			
	}
}
