package graft.ie;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ClientDisplayGrid {
	
	
	private GridPane propDetailsGridPane;
	private Label welcomeLabel;
	private Image welcomeImage;
	private Image house1Image;
	private ImageView staticHouse1ImageView;
	private ImageView propImageView;
	private TextArea propLocationArea;
	private HBox propDetailBox;
	private ArrayList<HBox> detailsHBoxs;
	private ArrayList<TextArea> detailTextAreas;
	private ArrayList<ImageView> propImageViews;
	
	public ClientDisplayGrid(){
		
		System.out.println("PropGridDisplay1 constructor called");
		
		setImageDisplayTemp();
		setTextDisplayTemp();
				
		propDetailBox = new HBox(8);
		propDetailBox.getChildren().addAll(propImageView, propLocationArea);
		
		propDetailsGridPane = new GridPane();
		propDetailsGridPane.setHgap(10);
		propDetailsGridPane.setPadding(new Insets(10, 10, 10, 10));
		propDetailsGridPane.setConstraints(propDetailBox, 0,1);
		propDetailsGridPane.getChildren().add(propDetailBox);
		
	}
	
	public ClientDisplayGrid(ArrayList<PropDetailsBean> list){
		
		this.detailTextAreas = new ArrayList<TextArea>();
		this.detailsHBoxs = new ArrayList<HBox>();
		this.staticHouse1ImageView = new ImageView();
		this.propImageViews = new ArrayList<ImageView>();
		setStaticHouse1();
		Integer i = 0;
				
		System.out.println("(ClientDisplayGrid.ClientDisplayGrid) In constructor step 2");
		
		for (PropDetailsBean o : list){
			String costString, tempString;
			System.out.println("(ClientDisplayGrid.ClientDisplayGrid) In for loop");
			System.out.println("Price is " + list.get(i).getPriceDouble());
			Integer tempDouble = list.get(i).getPropCostInteger();
			System.out.println("(ClientDisplayGrid.ClientDisplayGrid) Step1 Working");
			
			if(tempDouble == null){
				costString = "NA";
			}
			else {
				costString = Double.toString(tempDouble);
			}
							
			TextArea tempArea = new TextArea();
			tempArea.setMaxSize(700, 100);
			tempArea.setEditable(false);
			this.detailTextAreas.add(i, tempArea);
			this.detailTextAreas.get(i).setText("COST: €" + costString);
			tempString = list.get(i).getPropAddress1();
			this.detailTextAreas.get(i).appendText("\nADDRESS: " + tempString);
			
			System.out.println("(ClientDisplayGrid.ClientDisplayGrid) Step3 Working");
			HBox tempHBox = new HBox();
			
			
			//ImageView tempImageView = new ImageView();
			//System.out.println("(ClientDisplayGrid.ClientDisplayGrid) Step4 Working");
			//tempImageView = list.get(i).getMasterPropImageView();
			
			
			//tempHBox.getChildren().add(tempImageView);
			tempHBox.getChildren().add(this.detailTextAreas.get(i));
			
			System.out.println("(ClientDisplayGrid.ClientDisplayGrid) Step5 Working");
			this.detailsHBoxs.add(tempHBox);
			
			System.out.println("(ClientDisplayGrid.ClientDisplayGrid) Step6 Working");
			i++;
		}
		
		System.out.println("(ClientDisplayGrid.ClientDisplayGrid) Step7 Working");
		setGridPane(detailsHBoxs);	
		System.out.println("(ClientDisplayGrid.ClientDisplayGrid) Step8 Working");
		getDisplay();
		
		
	}
	
	private void setGridPane(ArrayList<HBox> listHBoxs){
		
		propDetailsGridPane = new GridPane();
		propDetailsGridPane.setHgap(10);
		propDetailsGridPane.setPadding(new Insets(10, 10, 10, 10));
		Integer index = 0;
		for(HBox oBox : listHBoxs){
			propDetailsGridPane.setConstraints(oBox, 0, index);
			index++;
		}
		
		propDetailsGridPane.getChildren().addAll(listHBoxs);
		
	}
	
	public GridPane getDisplay(){
		
		return propDetailsGridPane;
	}
	private void setWelcomeLabelTemp(){
		
		System.out.println("starting setWelcomeLabel function called");
		
		this.welcomeLabel = new Label("graft.ie");
		this.welcomeLabel.setFont(new Font("ITC Bauhaus", 40));
		this.welcomeImage = new Image("image/blue-home-icon.png");
		this.welcomeLabel.setGraphic(new ImageView(welcomeImage));
		this.welcomeLabel.setTextFill(Color.web("#0076a3"));
		System.out.println("ending -> setWelcomeLabel function called");
		
	}
	
	public Label getWelcomeLabelTemp(){
		return welcomeLabel;
	}
	
	
	
	private void setImageDisplayTemp(){
		house1Image = new Image("image/house1.png");
		propImageView = new ImageView();
		propImageView.setImage(house1Image);
		propImageView.setFitWidth(100);
		propImageView.setPreserveRatio(true);
	}
	private void setTextDisplayTemp(){
		
		this.propLocationArea = new TextArea();
		this.propLocationArea.setPrefColumnCount(3);
		this.propLocationArea.setPrefSize(100, 10);
		this.propLocationArea.setText("Hello all");
		this.propLocationArea.setDisable(true);
		
	}
	
	private void setTextDisplay(){
		
		this.propLocationArea = new TextArea();
		this.propLocationArea.setPrefColumnCount(3);
		this.propLocationArea.setPrefSize(100, 10);
		this.propLocationArea.setText("Hello all");
		this.propLocationArea.setDisable(true);
		
	}

	public Label getWelcomeLabel() {
		setWelcomeLabelTemp();
		return welcomeLabel;
	}

	public void setWelcomeLabel(Label welcomeLabel) {
		this.welcomeLabel = welcomeLabel;
		
		
	}
	
	public void setStaticHouse1(){
		
		Image house2Image = new Image("image/house1.png");
		this.staticHouse1ImageView = new ImageView();
		this.staticHouse1ImageView.setImage(house2Image);
		this.staticHouse1ImageView.setFitWidth(100);
		this.staticHouse1ImageView.setPreserveRatio(true);
	}
	public ImageView getStaticHouse1(){
		
		return this.staticHouse1ImageView;
		
	}

}
