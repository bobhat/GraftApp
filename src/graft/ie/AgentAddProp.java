package graft.ie;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AgentAddProp extends Application{
	
	private ComboBox<String> propTypeComboBox;
	private ComboBox<String> locationComboBox;
	private ComboBox<String> agencyComboBox;
	private ComboBox<String> roomsComboBox;
	private TextField agentNameField;
	private TextField priceField;
	private Stage primaryStage;
	
	public static void main(String[] args) throws Exception {
		launch(args);
		System.out.println("indiisplaysfdsf");
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.display();
		
	}
	
	public void display(){
		
		Label welcomeLabel = new Label("graft.ie");
		welcomeLabel.setFont(new Font("ITC Bauhaus", 40));
		Image welcomeImage = new Image("image/blue-home-icon.png");
		welcomeLabel.setGraphic(new ImageView(welcomeImage));
		welcomeLabel.setTextFill(Color.web("#0076a3"));
		
		
		Label propTypeLabel = new Label("Property Type");
		propTypeComboBox = new ComboBox<String>(getPropTypeList());
		//propTypeComboBox.setMinSize(50, 10);
		
		Label locationLabel = new Label("County");
		locationComboBox = new ComboBox<String>(getLocationList());
		
		Label agencyLabel = new Label("Agency");
		agencyComboBox = new ComboBox<String>(getAgencyList());
		
		Label numRoomLabel = new Label("Num of Rooms");
		roomsComboBox = new ComboBox<String>(getRoomList());
		
		Label agentLabel = new Label ("Name of Agent");
		agentNameField = new TextField();
		agentNameField.setMinWidth(40);
		
		Label priceLabel = new Label("Price of Property");
		priceField = new TextField();
		
		Button submitButton = new Button("Submit");
		
		submitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				PropDetailsBean newPropDetailsBean = new PropDetailsBean();
				
				//LOCATION
				newPropDetailsBean.setLocationString(getLocationComboBox());
				
				//AGENCY
				newPropDetailsBean.setAgencyString(getAgencyComboBox());
				
				//PRICE
				String tempString = getPriceField();
				Integer tempInteger = new Integer(tempString);
				newPropDetailsBean.setPropCostInteger(tempInteger);
				
				//NUMBER OF ROOMS
				Integer tempInteger2 = new Integer(getRoomsComboBox());
				newPropDetailsBean.setNumRoomInteger(tempInteger2);	
				
				//AGENT
				newPropDetailsBean.setAgentString(getAgentNameField());
				
				newPropDetailsBean.setPropTypeString(getPropTypeComboBox());
				
				ClientImp callingImp = new ClientImp();
				System.out.println("I'M HERE NOW!!");
				callingImp.updateNewProp(newPropDetailsBean);
				
				primaryStage.close();
				
			}
		});
		
		GridPane addPropPane = new GridPane();
		
		addPropPane.add(welcomeLabel, 1,1);
		addPropPane.add(propTypeLabel, 1, 2);
		addPropPane.add(propTypeComboBox,1,3);
		
		addPropPane.add(locationLabel, 2, 2);
		addPropPane.add(locationComboBox, 2, 3);
		
		addPropPane.add(agencyLabel, 3, 2);
		addPropPane.add(agencyComboBox, 3, 3);
		
		addPropPane.add(agentLabel, 4, 2);
		addPropPane.add(agentNameField, 4, 3);
		
		addPropPane.add(numRoomLabel, 1, 4);
		addPropPane.add(roomsComboBox, 1, 5);
		
		addPropPane.add(priceLabel, 2, 4);
		addPropPane.add(priceField, 2, 5);
		addPropPane.add(submitButton, 1, 6);	
		
		addPropPane.setAlignment(Pos.CENTER);
		addPropPane.setHgap(10);
		addPropPane.setVgap(10);
		addPropPane.setPadding(new Insets(10, 10, 10, 10));
		
		Scene primaryScene = new Scene(addPropPane);
		primaryStage = new Stage();
		primaryStage.setTitle("Graft Agent Login");
		primaryStage.setScene(primaryScene);
		
		primaryStage.show();
		
		
	}

	
	public String getPropTypeComboBox() {
		return propTypeComboBox.getValue();
	}

	public String getLocationComboBox() {
		return locationComboBox.getValue();
	}

	public String getAgencyComboBox() {
		return agencyComboBox.getValue();
	}

	public String getRoomsComboBox() {
		return roomsComboBox.getValue();
	}

	public String getAgentNameField() {
		return agentNameField.getText();
	}

	public String getPriceField() {
		return priceField.getText();
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
	
	public ObservableList<String> getLocationList()
	{
		
		ObservableList<String> propLocationList = 
			    FXCollections.observableArrayList(
			    		"Antrim",
			    		"Armagh",
			    		"Carlow",
			    		"Cavan",
			    		"Wicklow"
			    );
		return propLocationList;
		
		
	}
	
	public ObservableList<String> getRoomList()
	{
		
		ObservableList<String> propRoomList = 
			    FXCollections.observableArrayList(
			        "1",
			        "2",
			        "3",
			        "4",
			        "5",
			        "6",
			        "7"			        
			    );
		return propRoomList;
		
		
	}



	
	
}
