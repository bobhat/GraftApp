package graft.ie;

import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class WelcomePage extends Application{

	private Stage primaryStage;
	private Label welcomeLabel;
	

	public static void main(String[] args) {
		
		launch(args);

	}

	public void start(Stage arg0) throws Exception {
		this.primaryStage = arg0;
		primaryStage.setTitle("Welcome to Graft");
		
		
		welcomeLabel = new Label("graft.ie");
		welcomeLabel.setFont(new Font("ITC Bauhaus", 40));
		Image welcomeImage = new Image("image/blue-home-icon.png");
		welcomeLabel.setGraphic(new ImageView(welcomeImage));
		welcomeLabel.setTextFill(Color.web("#0076a3"));
		
		//Property type list
		ComboBox<String> propTypeComboBox = new ComboBox<String>(getPropTypeList());
		Label protTypeLabel = new Label("Property Type");
		protTypeLabel.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 12));
		
		//Location List(counties of Ireland)
		ComboBox<String> locationComboBox = new ComboBox<String>(getLocationList());
		Label locationLabel = new Label("Location");
		locationLabel.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 12));
		
		//Agency Names
		ComboBox<String> agencyComboBox = new ComboBox<String>(getAgencyList());
		Label agencyLabel = new Label("Agency");
		agencyLabel.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 12));
		
		//Agency Names
		ComboBox<String> priceRangeComboBox = new ComboBox<String>(getPriceRangeList());
		Label priceRangeLabel = new Label("Price Range");
		priceRangeLabel.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 12));
		
		GridPane welcomeGridPane = new GridPane();
		welcomeGridPane.setHgap(10);
		welcomeGridPane.setPadding(new Insets(10,10,10,10));
				
		//add Type combobox & Label
		welcomeGridPane.setConstraints(protTypeLabel, 1, 1);
		welcomeGridPane.setHalignment(protTypeLabel, HPos.CENTER);
		welcomeGridPane.setConstraints(propTypeComboBox,1,2);
		
		//add Location combobox & Label
		welcomeGridPane.setConstraints(locationLabel, 2, 1);
		welcomeGridPane.setHalignment(locationLabel, HPos.CENTER);
		welcomeGridPane.setConstraints(locationComboBox, 2, 2);
		
		//add Agency combobox & Label
		welcomeGridPane.setConstraints(agencyLabel, 3, 1);
		welcomeGridPane.setHalignment(agencyLabel, HPos.CENTER);
		welcomeGridPane.setConstraints(agencyComboBox, 3, 2);
		
		//add Price range combobox & Label
		welcomeGridPane.setConstraints(priceRangeLabel, 4, 1);
		welcomeGridPane.setHalignment(priceRangeLabel, HPos.CENTER);
		welcomeGridPane.setConstraints(priceRangeComboBox, 4, 2);
		
		//
		
		//Search Button
		Button searchButton = new Button("Search");
		searchButton.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 20));
		
				
				
		HBox bottomHBox = new HBox();
		bottomHBox.setAlignment(Pos.CENTER);
		bottomHBox.setPadding(new Insets(0, 10, 10, 10));
		bottomHBox.setSpacing(10);
		bottomHBox.getChildren().addAll(searchButton);
		
		
		
		welcomeGridPane.getChildren().addAll(priceRangeLabel, priceRangeComboBox, protTypeLabel, propTypeComboBox,locationLabel,locationComboBox, agencyLabel,agencyComboBox );
		
		
		BorderPane borderPane = new BorderPane();
		
		borderPane.setAlignment(welcomeLabel, Pos.CENTER_LEFT);
		borderPane.setTop(welcomeLabel);
		borderPane.setAlignment(welcomeGridPane, Pos.CENTER);
		borderPane.setCenter(welcomeGridPane);
		
		borderPane.setBottom(bottomHBox);
		
		Scene primaryScene = new Scene(borderPane);
		
		primaryStage.getIcons().add(new Image("image/blue-home-icon.png"));
		primaryStage.setScene(primaryScene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Ooops, there was an error!");

				alert.showAndWait();
				
				System.out.println("Search button clicked");
				 setLabel();
				
				
			}
		});
		
		
	}
	
	public ObservableList<String> getPropTypeList()
	{
		
		ObservableList<String> propTypeList = 
			    FXCollections.observableArrayList(
			        "Option 1",
			        "Option 2",
			        "Option 3"
			    );
		return propTypeList;
		
		
	}
	
	public ObservableList<String> getLocationList()
	{
		
		ObservableList<String> propLocationList = 
			    FXCollections.observableArrayList(
			        "Option 1",
			        "Option 2",
			        "Option 3"
			    );
		return propLocationList;
		
		
	}
	
	public ObservableList<String> getAgencyList()
	{
		
		ObservableList<String> propAgencyList = 
			    FXCollections.observableArrayList(
			        "Agency Option 1",
			        "Agency Option 2",
			        "Agency Option 3"
			    );
		return propAgencyList;
		
		
	}
	
	public ObservableList<String> getPriceRangeList()
	{
		
		ObservableList<String> propPriceRangeList = 
			    FXCollections.observableArrayList(
			        "Agency Option 100 - 200",
			        "Agency Option 200 - 400",
			        "Agency Option 400 - 800"
			    );
		return propPriceRangeList;
	
	}
	public void setLabel()
	{
		welcomeLabel.setText("hellooooooo");
	}
}
