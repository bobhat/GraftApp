package graft.ie;

import java.io.Serializable;

public class SearchBean implements Serializable{
	
	String agencyString;
	String priceRangeString;
	String propTypeString;
	String locationString;
	
	public String getAgencyString() {
		return agencyString;
	}
	public void setAgencyString(String agencyString) {
		this.agencyString = agencyString;
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
