package graft.ie;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PropDetailsBean implements Serializable{
	
	Image masterPropImage;
	ArrayList<ImageView> masterPropImageViewArray;
	String agencyString = "none given";
	Double priceDouble;
	String priceRangeString;
	String propTypeString;
	String locationString;
	
	public PropDetailsBean(Double priceDouble) {
		super();
		this.priceDouble = priceDouble;
		this.masterPropImageViewArray = new ArrayList<ImageView>();
		Image tempImage = new Image("image/blue-home-icon.png");
		setMasterPropImageView(tempImage);
	}
	
	public PropDetailsBean(String propType, String location, String agency, String priceRange){
		setPropTypeString(propType);
		setLocationString(location);
		setAgencyString(agency);
		setPriceRangeString(priceRange);
		
	}
	
	public PropDetailsBean(Image masterPropImage, Double priceDouble) {
		super();
		this.priceDouble = priceDouble;
		this.masterPropImageViewArray = new ArrayList<ImageView>();
		this.masterPropImage = masterPropImage; 
		setMasterPropImageView(masterPropImage);
	}
	
	
	public PropDetailsBean(Image masterPropImage, String agencyString,
			Double priceDouble) {
		super();
		this.masterPropImage = masterPropImage;
		this.agencyString = agencyString;
		this.priceDouble = priceDouble;
	}
	

	public Image getMasterPropImage() {
		return masterPropImage;
	}
	public void setMasterPropImage(Image masterPropImage) {
		
		this.masterPropImage = masterPropImage;
		//setMasterPropImageView(masterPropImage);
	}
	
	public ImageView getMasterPropImageView() {
		
		ImageView tempImageView = new ImageView();
		System.out.println("(Prop Bean.getMasterPropImageView())");
		tempImageView = masterPropImageViewArray.get(0);
		
		return tempImageView;
	}
	
	public void setMasterPropImageView(Image masterPropImageView) {
		
		System.out.println("(Prop Bean.setMasterPropImageView)");
		
		ImageView tempImageView = new ImageView();
		tempImageView.setImage(masterPropImageView);
		tempImageView.setFitWidth(133);
		tempImageView.setPreserveRatio(true);
		System.out.println("(Prop Bean.setMasterPropImageView)");
		this.masterPropImageViewArray.add(tempImageView);
	}
	
	public void setMasterPropImageView(ArrayList<ImageView> masterPropImageView) {
		this.masterPropImageViewArray = masterPropImageView;
	}
	
	/*public void setMasterPropImageView(ImageView masterPropImageView) {
		this.masterPropImageView = masterPropImageView;
	}*/
	
	public String getAgencyString() {
		return agencyString;
	}
	public void setAgencyString(String agencyString) {
		this.agencyString = agencyString;
	}
	public Double getPriceDouble() {
		return priceDouble;
	}
	public void setPriceDouble(Double priceDouble) {
		this.priceDouble = priceDouble;
	}

	public String getPriceRangeString() {
		return priceRangeString;
	}

	public void setPriceRangeString(String priceRangeString) {
		this.priceRangeString = priceRangeString;
	}

	public String getPropTypeString() {
		return propTypeString;
	}

	public void setPropTypeString(String propTypeString) {
		this.propTypeString = propTypeString;
	}

	public String getLocationString() {
		return locationString;
	}

	public void setLocationString(String locationString) {
		this.locationString = locationString;
	}
	
	
}
