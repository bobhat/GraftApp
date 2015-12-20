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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgentLogon extends Application {

	private PasswordField pwdField;
	private TextField nameField;
	private Stage primaryStage;
	private ClientHomePage homePageNext;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void display(ClientHomePage homePage){
		homePageNext = homePage;
		primaryStage = new Stage();
		GridPane pwdGridPane = new GridPane();
		
		Label nameLabel = new Label("Username: ");
		nameField = new TextField();
		
		Label pwdLabel = new Label("Password: ");
		pwdField = new PasswordField();
		
		Button okButton = new Button("OK");
		
		pwdGridPane.add(nameLabel, 1, 2);
		pwdGridPane.add(nameField, 2, 2);
		pwdGridPane.add(pwdLabel, 1, 3);
		pwdGridPane.add(pwdField, 2, 3);
		pwdGridPane.add(okButton, 2, 4);
		
		pwdGridPane.setAlignment(Pos.CENTER);
		pwdGridPane.setHgap(10);
		pwdGridPane.setVgap(10);
		pwdGridPane.setPadding(new Insets(10, 10, 10, 10));
		
		
		Scene primaryScene = new Scene(pwdGridPane,300, 200);
		primaryStage.setTitle("Graft Agent Login");
		primaryStage.setMaxWidth(300);
		primaryStage.setMaxWidth(300);
		primaryStage.setScene(primaryScene);
		primaryStage.show();
		
		okButton.setOnAction(new EventHandler<ActionEvent>(){

			public void handle(javafx.event.ActionEvent event) {
			
				AgentBean agentLogInBean = new AgentBean();
				String tempString1 = pwdField.getText();
				String tempString2 = nameField.getText();
				agentLogInBean.setPwdString(tempString1);
				agentLogInBean.setUserNameString(tempString2);
				
				ClientImp callInterface = new ClientImp();
				boolean resultBol = callInterface.checkAgent(agentLogInBean);
				
				if(resultBol == true)
				{
					try {
						AgentPropertyDisplay agentDisplayPage = new AgentPropertyDisplay();
						ArrayList<PropDetailsBean> agentSearchBeans = new ArrayList<PropDetailsBean>();
						agentSearchBeans = callInterface.agentSearch(agentLogInBean);
						agentDisplayPage.display(agentSearchBeans);
						agentDisplayPage.setAgentBean(agentLogInBean);
						
						homePageNext.closeDisplay();
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					primaryStage.close();
				}
				
				
			}
			
		});
		
	}

}
