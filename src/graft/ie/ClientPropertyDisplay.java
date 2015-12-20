package graft.ie;


import java.awt.event.ActionListener;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ClientPropertyDisplay extends Application implements ActionListener{
	
	
	private Stage primaryStage;
	private ClientDisplayGrid propGridPane1;
	private GridPane clientCenterGridPane;
	private ClientComboGrid displayComboGrid;
	private GridPane finalGridPane;
	private Button searchButton;
	private ArrayList<TextArea> detailTextAreas;
	private EventHandler<MouseEvent> handler1;
	

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}
	
	@SuppressWarnings("static-access")
	public void display(ArrayList<PropDetailsBean> propDetails){
		
		//Creates and returns the Grid-display with the propertydetails. This display will be used as the centre display.
		//propGridPane1 will be used to access the different parts of the Grid 
		this.propGridPane1 = new ClientDisplayGrid(propDetails);
		
		//BorderPane that will be used in the Over all layout
		final BorderPane propDetailsBorderPane = new BorderPane();
		
		//clientCenterGridPane was create just a tempory way of holding the GridPane that propGridPane1.getDisplay returns.
		//When propGridPane1.getDisplay() was added to teh Borderpane.setCenter errors occurred.
		this.clientCenterGridPane = propGridPane1.getDisplay();
		propDetailsBorderPane.setCenter(this.clientCenterGridPane);
		propDetailsBorderPane.setTop(propGridPane1.getWelcomeLabel());
		
		//Display for the dropdown lists that are common.
		displayComboGrid = new ClientComboGrid();
		//Temporary GridPane node that is used to store the return grid from the displayComboGrid
		finalGridPane = new GridPane();
				
		finalGridPane = displayComboGrid.getComboGridPane();
		searchButton = displayComboGrid.getSearchBotton();
			
		finalGridPane.setConstraints(searchButton,4,3);
		finalGridPane.setHalignment(searchButton,HPos.RIGHT);
		finalGridPane.getChildren().addAll(searchButton);
		
		propDetailsBorderPane.setBottom(finalGridPane);
		
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
		
		    

			
		
		
		searchButton.setOnAction(new EventHandler<ActionEvent>(){
			
			
			public void handle(ActionEvent e) {
				
				SearchBean searchDetailsBean = new SearchBean();
				searchDetailsBean.setLocationString(displayComboGrid.getLocationComboBox());
				searchDetailsBean.setAgencyString(displayComboGrid.getAgencyComboBox());
				searchDetailsBean.setPriceRangeString(displayComboGrid.getPriceRangeComboBox());
				searchDetailsBean.setPropTypeString(displayComboGrid.getPropTypeComboBox());
				
					
				System.out.println("New search button working!!!!");
				ClientImp clientRequestImp = new ClientImp();
				ArrayList<PropDetailsBean> clientSearchBeans = new ArrayList<PropDetailsBean>();
				clientSearchBeans = clientRequestImp.clientSearch(searchDetailsBean);
				javafx.scene.Node testNode = propDetailsBorderPane.getCenter();
				propDetailsBorderPane.getChildren().remove(testNode);
				propDetailsBorderPane.setCenter(null);
				clientCenterGridPane = null;
				clientCenterGridPane = propGridPane1.updateDisplay(clientSearchBeans);
								
				propDetailsBorderPane.setCenter(clientCenterGridPane);
				
			}
			
		});
			
	}
	public void handler1(MouseEvent event) {
		System.out.println("CLINKING WORKING*******!!!!!");
	} 
	
	public void update(ArrayList<PropDetailsBean> propDetails){
		System.out.println("before updateDisplay");
		final GridPane temPane = this.propGridPane1.updateDisplay(propDetails);
		temPane.setVisible(true);
		System.out.println("after updateDisplay");
					
	}
	public void addButton(String titleString, Integer colPos, Integer rowPos){
		
		Button aButton = new Button("titleString");
		aButton.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 20));
		finalGridPane.setConstraints(aButton, colPos, rowPos);
		finalGridPane.setHalignment(aButton,HPos.RIGHT);
		finalGridPane.getChildren().addAll(aButton);
		
	}
	
	public void addButton(Button aButton, Integer colPos, Integer rowPos){
		
		finalGridPane.setConstraints(aButton, colPos, rowPos);
		finalGridPane.setHalignment(aButton,HPos.RIGHT);
		finalGridPane.getChildren().addAll(aButton);
		
	}
	
	public void addLabel(){
		
	}
	
	public Button getSearchButton(){
		return searchButton;
	}

	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		System.out.println("Clicked on" );
		
	}
	

	
}
