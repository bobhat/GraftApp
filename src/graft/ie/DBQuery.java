package graft.ie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBQuery {
	
	private static Connection dbConnection = null;
	private static ResultSet resultSet = null;
	private String agencyString;
	private String locationString;
	private String priceRangeString;
	private String propTypeString;
		
public boolean checkAgent(AgentBean agentTemp){
	DBConnection temp = new DBConnection();
	dbConnection = temp.getDBConnection();
	Statement statement;
	Boolean pwdBoolean = false;
	
	try {
		statement = dbConnection.createStatement();
		String tempString = agentTemp.getUserNameString(); 
		System.out.println("tempString = " + tempString);
		resultSet = statement.executeQuery("SELECT AGENT_FNAME from APP.AGENT where AGENT_FNAME='" + tempString +"'");
		while (resultSet.next()){
			 pwdBoolean = true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return pwdBoolean;
}

public void updateNewProp(PropDetailsBean newPropBean){
	
	DBConnection temp = new DBConnection();
	dbConnection = temp.getDBConnection();
	Statement statement;
	
	
	try {
		Integer propTypeInt = 0;
		Integer agentID = 0;
		statement = dbConnection.createStatement();
		
		String tempString = newPropBean.getPropTypeString();
		System.out.println(tempString );
		resultSet = statement.executeQuery("SELECT PROP_TYPE_ID from APP.PROPERTY_TYPE where PROP_TYPE_DES='" + tempString + "'");
		while (resultSet.next()){
			propTypeInt = resultSet.getInt("PROP_TYPE_ID");
			System.out.println(propTypeInt + " " + tempString );
		}
		tempString = newPropBean.getAgentString();
		resultSet = statement.executeQuery("SELECT AGENT_ID from APP.AGENT where AGENT_FNAME='" + tempString +"'");

	    while (resultSet.next()){
	    	agentID = resultSet.getInt("AGENT_ID");
	    }		
		Integer costInteger = newPropBean.getPropCostInteger();
		String propAddressString = newPropBean.getPropAddress1();
		
		System.out.println("ABout to add data");
		//INSERT into APP.PROPERTY(PROPERTY_COST, PROPERTY_ADDRESS, AGENT_ID, PROP_TYPE,DATE_TO_MARKET, PROPERTY_OWNER, PROPERTY_NAME) values(350,'John',2 ,2, '2015-05-05', 'temp', 'WHY OH WHY')
		//INSERT into APP.PROPERTY(PROPERTY_COST, PROPERTY_ADDRESS, PROPERTY_NAME, PROPERTY_OWNER, DATE_TO_MARKET,PROP_TYPE, AGENT_ID) values(3099900, 'Galway', 'house4', 'Frank', '2015-07-05', 2, 2);
		statement.executeUpdate("INSERT into APP.PROPERTY(PROPERTY_COST, PROPERTY_ADDRESS, PROPERTY_NAME, PROPERTY_OWNER, DATE_TO_MARKET,PROP_TYPE, AGENT_ID) values(" + costInteger + ", '" + propAddressString + "', 'whitehouse', 'DAN', '2015-07-05', " + propTypeInt + "," + agentID + ")");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

public ArrayList<PropDetailsBean> clientSearch(SearchBean searchBean){
	
	DBConnection temp = new DBConnection();
	dbConnection = temp.getDBConnection();
	
	ArrayList<PropDetailsBean> resultBeanArrayList = new ArrayList<PropDetailsBean>();
	Statement statement;

	try {
		statement = dbConnection.createStatement();
		
		System.out.println("The serach string about to add to SQL is " + searchBean.getPropTypeString());
		String propTypeString = searchBean.getPropTypeString();
		
		
		resultSet = statement.executeQuery("SELECT PROPERTY_COST,PROPERTY_ADDRESS FROM APP.PROPERTY where PROP_TYPE in (SELECT PROP_TYPE_ID from APP.PROPERTY_TYPE where PROP_TYPE_DES='" + propTypeString + "')");
		
		while (resultSet.next()){
			System.out.println("in result set");
			PropDetailsBean tempResultBean = new PropDetailsBean();
			
			tempResultBean.setPropCostInteger(resultSet.getInt("PROPERTY_COST"));
			tempResultBean.setPropAddress1(resultSet.getString("PROPERTY_ADDRESS"));
			System.out.println("Cost of House:: " + tempResultBean.getPropCostInteger());
			resultBeanArrayList.add(tempResultBean);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//System.out.println("DatabaseChecks.getAgentsList:::" + resultBeanArrayList.size());
	return resultBeanArrayList;
	
}

public ArrayList<PropDetailsBean> agentSearch(AgentBean searchBean){
	
	DBConnection temp = new DBConnection();
	dbConnection = temp.getDBConnection();
	
	ArrayList<PropDetailsBean> resultBeanArrayList = new ArrayList<PropDetailsBean>();
	Statement statement;
		
	try {
		statement = dbConnection.createStatement();
		
		System.out.println("The serach string about to add to SQL is " + searchBean.getUserNameString());
		String propTypeString = searchBean.getUserNameString();
		
		
		resultSet = statement.executeQuery("SELECT PROPERTY_COST,PROPERTY_ADDRESS FROM APP.PROPERTY where AGENT_ID in (SELECT AGENT_ID from APP.AGENT where AGENT_FNAME='" + propTypeString + "')");
		
		while (resultSet.next()){
			System.out.println("in result set");
			PropDetailsBean tempResultBean = new PropDetailsBean();
			
			tempResultBean.setPropCostInteger(resultSet.getInt("PROPERTY_COST"));
			tempResultBean.setPropAddress1(resultSet.getString("PROPERTY_ADDRESS"));
			System.out.println("Cost of House:: " + tempResultBean.getPropCostInteger());
			resultBeanArrayList.add(tempResultBean);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return resultBeanArrayList;
}





public static String getLName(String username) throws Exception{
		
		DBConnection temp = new DBConnection();
		dbConnection = temp.getDBConnection();
		String getLNAME = "yyy";
						
		Statement statement = dbConnection.createStatement();
		resultSet = statement.executeQuery("SELECT * FROM APP.AGENT WHERE AGENT_FNAME = '" + username + "'");
		while (resultSet.next()){
			getLNAME = resultSet.getString("AGENT_LNAME");
		}
		
		return getLNAME;
	}
	
			
public static ArrayList<PropDetailsBean> getPropDetails(){
		
		DBConnection temp = new DBConnection();
		dbConnection = temp.getDBConnection();
		
		ArrayList<PropDetailsBean> agentsArrayList = new ArrayList<PropDetailsBean>();
		Statement statement;
		try {
			statement = dbConnection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM APP.AGENT");
			
			while (resultSet.next()){
			/*	Agents tempAgents = new Agents();
				tempAgents.setAgentid(resultSet.getInt("AGENT_ID"));
				tempAgents.setFirstName(resultSet.getString("AGENT_FNAME"));
				tempAgents.setLastName(resultSet.getString("AGENT_LNAME"));
				tempAgents.setAddress1String(resultSet.getString("AGENT_ADDRESS1"));
				tempAgents.setAddress2String(resultSet.getString("AGENT_ADDRESS2"));
				agentsArrayList.add(tempAgents);
				System.out.println(tempAgents.getFirstName());*/
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DatabaseChecks.getAgentsList");
		return agentsArrayList;
			
	}

	public String getAgencyString() {
		return agencyString;
	}

	public void setAgencyString(String agencyString) {
		this.agencyString = agencyString;
	}

	public String getLocationString() {
		return locationString;
	}

	public void setLocationString(String locationString) {
		this.locationString = locationString;
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

}
