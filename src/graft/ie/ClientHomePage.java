package graft.ie;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ClientHomePage extends Application{
	
	private Stage primaryStage;
	private Label welcomeLabel;
	private static final String HOST = "localhost";
	ComboBox<String> propTypeComboBox;
	ComboBox<String> locationComboBox;
	//Agency Names
	ComboBox<String> agencyComboBox;	
	ComboBox<String> priceRangeComboBox;

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
		propTypeComboBox = new ComboBox<String>(getPropTypeList());
		Label protTypeLabel = new Label("Property Type");
		protTypeLabel.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 12));
		
		//Location List(counties of Ireland)
		locationComboBox = new ComboBox<String>(getLocationList());
		Label locationLabel = new Label("Location");
		locationLabel.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 12));
		
		//Agency Names
		agencyComboBox = new ComboBox<String>(getAgencyList());
		Label agencyLabel = new Label("Agency");
		agencyLabel.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 12));
		
		//Price Range
		priceRangeComboBox = new ComboBox<String>(getPriceRangeList());
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
				
				
				System.out.println("SearchOption: " + "Type: " +  getPropTypeComboBox()+  " Location: " + getLocationComboBox());
				PropDetailsBean clientSearchBean = new PropDetailsBean(getPropTypeComboBox(), getLocationComboBox(), getAgencyComboBox(), getPriceRangeComboBox());
				
				setLabel();
				
				//PropDetailsBean clientSearchDetails = new PropDetailsBean()
				
				try {
					ServerInterfaces checkPWD = (ServerInterfaces)Naming.lookup("rmi://" + HOST + "/ServerInterfaces");
					//checkPWD.checkUser();
					checkPWD.clientSearch(clientSearchBean);
					
					
					
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
		});
		
		
	}
	
	public ObservableList<String> getPropTypeList()
	{
		
		ObservableList<String> propTypeList = 
			    FXCollections.observableArrayList(
			        "House for Sale",
			        "Apartment for Sale",
			        "Duplex for Sale"
			    );
		return propTypeList;
		
		
	}
	
	public ObservableList<String> getLocationList()
	{
		
		ObservableList<String> propLocationList = 
			    FXCollections.observableArrayList(
			        "Dublin",
			        "Sligo",
			        "Galway"
			    );
		return propLocationList;
		
		
	}
	
	public ObservableList<String> getAgencyList()
	{
		
		ObservableList<String> propAgencyList = 
			    FXCollections.observableArrayList(
			        "Sherry FitzGerald",
			        "Oates Breheny",
			        "Elite Estate Agents"
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
		this.welcomeLabel.setText("hellooooooo");
	}

	public String getPropTypeComboBox() {
		return propTypeComboBox.getValue();
	}

	public void setPropTypeComboBox(ComboBox<String> propTypeComboBox) {
		this.propTypeComboBox = propTypeComboBox;
	}

	public String getLocationComboBox() {
		return locationComboBox.getValue();
	}

	public void setLocationComboBox(ComboBox<String> locationComboBox) {
		this.locationComboBox = locationComboBox;
	}

	public String getAgencyComboBox() {
		return agencyComboBox.getValue();
	}

	public void setAgencyComboBox(ComboBox<String> agencyComboBox) {
		this.agencyComboBox = agencyComboBox;
	}

	public String getPriceRangeComboBox() {
		return priceRangeComboBox.getValue();
	}

	public void setPriceRangeComboBox(ComboBox<String> priceRangeComboBox) {
		this.priceRangeComboBox = priceRangeComboBox;
	}	
	
	

}
