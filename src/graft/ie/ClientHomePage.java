package graft.ie;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class ClientHomePage extends Application implements EventHandler<javafx.event.ActionEvent>{
	
	private Stage primaryStage;
	private Label welcomeLabel;
	ClientComboGrid comboGrid;
	
	public static void main(String[] args) {
				launch(args);
	}

	@SuppressWarnings("static-access")
	public void start(Stage arg0) throws Exception {
		this.primaryStage = arg0;
		primaryStage.setTitle("Welcome to Graft");
		
		
		welcomeLabel = new Label("graft.ie");
		welcomeLabel.setFont(new Font("ITC Bauhaus", 40));
		Image welcomeImage = new Image("image/blue-home-icon.png");
		welcomeLabel.setGraphic(new ImageView(welcomeImage));
		welcomeLabel.setTextFill(Color.web("#0076a3"));
		
		//Search Button
		Button searchButton = new Button("Search");
		searchButton.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 20));
		Button agentButton = new Button("Click Here if Agent");
		agentButton.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 10));
				
				
		HBox bottomHBox = new HBox();
		bottomHBox.setAlignment(Pos.CENTER);
		bottomHBox.setPadding(new Insets(0, 10, 10, 10));
		bottomHBox.setSpacing(10);
		bottomHBox.getChildren().addAll(searchButton, agentButton);
						
		System.out.println("about to call ClientComboGrid");
		comboGrid = new ClientComboGrid();
		GridPane welcomeGridPane = new GridPane();
		welcomeGridPane = comboGrid.getComboGridPane();
		
		
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
				
				ArrayList<PropDetailsBean> clientSearchBeans = new ArrayList<PropDetailsBean>();
				ClientPropertyDisplay propertyDisplay = new ClientPropertyDisplay();
				
				SearchBean clientSearchDetails = new SearchBean();
				clientSearchDetails.setPropTypeString(comboGrid.getPropTypeComboBox());
				clientSearchDetails.setPriceRangeString(comboGrid.getPriceRangeComboBox());
				clientSearchDetails.setLocationString(comboGrid.getLocationComboBox());
				clientSearchDetails.setAgencyString(comboGrid.getAgencyComboBox());
				System.out.println("Failing here");
				System.out.println("SearchOption: " + "Type: " +  comboGrid.getPropTypeComboBox()+  " Location: " + comboGrid.getLocationComboBox());
				
				ClientImp tempImp = new ClientImp();
				clientSearchBeans = tempImp.clientSearch(clientSearchDetails);
									
				for (PropDetailsBean tempBeans : clientSearchBeans) {
					System.out.println("Property Address" + tempBeans.getPropAddress1() + " Prop Cost:" + tempBeans.getPropCostInteger());
					
				}
				propertyDisplay.display(clientSearchBeans);
				primaryStage.close();
				
			}
		});
		
		agentButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				openAgentLogin();
				
			}
		});
		
	}
	
	public void openAgentLogin(){
		AgentLogon agentPWD = new AgentLogon();
		agentPWD.display(this);
		System.out.println("Logon window Closed");
	}
	
	public void closeDisplay()
	{
		try {
			this.primaryStage.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
