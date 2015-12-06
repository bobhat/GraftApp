package graft.ie;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PropertyListPage extends Application {
	
	private Stage primaryStage;
	private DisplayPropDetails propGridPane1;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
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
		
		this.propGridPane1 = new DisplayPropDetails(testArray);
		
		
				
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
}	


