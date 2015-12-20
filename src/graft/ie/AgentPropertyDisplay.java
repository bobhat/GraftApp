package graft.ie;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AgentPropertyDisplay extends ClientPropertyDisplay{
	
	private AgentBean loginAgentBean;
	
	@Override
	public void display(ArrayList<PropDetailsBean> propDetails) {
		// TODO Auto-generated method stub
		super.display(propDetails);
		Button aButton = new Button("Add New Property");
		aButton.setFont(Font.font("ITC Bauhaus", FontWeight.BOLD, 10));
		aButton.setOnAction(new EventHandler<ActionEvent>(){

			public void handle(ActionEvent event) {
				
				openAgentAddProp();
			}
			
		});
		
		super.addButton(aButton, 3,3);
	}
	
	private void openAgentAddProp(){
		AgentAddProp updateDisplay = new AgentAddProp();
		
		updateDisplay.display();
	}
	
	
	public void setAgentBean(AgentBean agentLogInBean){
		loginAgentBean = agentLogInBean;
	}
		
}
