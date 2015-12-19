package graft.ie;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ClientComboGrid{
	
	private Stage primaryStage;
	private Label welcomeLabel;
	private static final String HOST = "localhost";
	ComboBox<String> propTypeComboBox;
	ComboBox<String> locationComboBox;
	ComboBox<String> agencyComboBox;	
	ComboBox<String> priceRangeComboBox;

	public GridPane getComboGridPane(){
		
	
	
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
	
	GridPane comboGridPane = new GridPane();
	comboGridPane.setHgap(10);
	comboGridPane.setPadding(new Insets(10,10,10,10));
			
	//add Type combobox & Label
	comboGridPane.setConstraints(protTypeLabel, 1, 1);
	comboGridPane.setHalignment(protTypeLabel, HPos.CENTER);
	comboGridPane.setConstraints(propTypeComboBox,1,2);
	
	//add Location combobox & Label
	comboGridPane.setConstraints(locationLabel, 2, 1);
	comboGridPane.setHalignment(locationLabel, HPos.CENTER);
	comboGridPane.setConstraints(locationComboBox, 2, 2);
	
	//add Agency combobox & Label
	comboGridPane.setConstraints(agencyLabel, 3, 1);
	comboGridPane.setHalignment(agencyLabel, HPos.CENTER);
	comboGridPane.setConstraints(agencyComboBox, 3, 2);
	
	//add Price range combobox & Label
	comboGridPane.setConstraints(priceRangeLabel, 4, 1);
	comboGridPane.setHalignment(priceRangeLabel, HPos.CENTER);
	comboGridPane.setConstraints(priceRangeComboBox, 4, 2);
	
	//Search Button
	Button searchButton = new Button("Search");
	searchButton.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 20));
					
	HBox bottomHBox = new HBox();
	bottomHBox.setAlignment(Pos.CENTER);
	bottomHBox.setPadding(new Insets(0, 10, 10, 10));
	bottomHBox.setSpacing(10);
	bottomHBox.getChildren().addAll(searchButton);
	
	comboGridPane.getChildren().addAll(priceRangeLabel, priceRangeComboBox, protTypeLabel, propTypeComboBox,locationLabel,locationComboBox, agencyLabel,agencyComboBox );
	return comboGridPane;
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
