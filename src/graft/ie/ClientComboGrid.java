package graft.ie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class ClientComboGrid {
	
	ComboBox<String> propTypeComboBox;
	ComboBox<String> locationComboBox;
	ComboBox<String> agencyComboBox;	
	ComboBox<String> priceRangeComboBox;
	

	@SuppressWarnings("static-access")
	public GridPane getComboGridPane(){
		propTypeComboBox = new ComboBox<String>();
		locationComboBox = new ComboBox<String>();
		agencyComboBox = new ComboBox<String>();	
		priceRangeComboBox = new ComboBox<String>();
	
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
	public Button getSearchBotton()
	{
	Button searchButton = new Button("Search");
	searchButton.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 20));
		
	return searchButton;
	
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
