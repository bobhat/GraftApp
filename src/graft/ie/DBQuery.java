package graft.ie;

import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.scene.image.Image;

public class DBQuery {
	
	private static Connection dbConnection = null;
	private static ResultSet resultSet = null;
	
	
	//What are our queries:
	//get

public static void testBlob() throws Exception {
	DBConnection temp = new DBConnection();
	dbConnection = temp.getDBConnection();
	
	Blob blob = dbConnection.createBlob();
    Image ii = new Image("image/House1.jpeg");
    
    ObjectOutputStream oos;
    oos = new ObjectOutputStream(blob.setBinaryStream(1));
    oos.writeObject(ii);
    oos.close();
	
	Statement statement = dbConnection.createStatement();
	statement.executeQuery("INSERT INTO PHOTOS );
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
		
		//String queryString = "SELECT "
		
		DBConnection temp = new DBConnection();
		dbConnection = temp.getDBConnection();
		
		ArrayList<PropDetailsBean> agentsArrayList = new ArrayList();
		Statement statement;
		try {
			statement = dbConnection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM APP.AGENT");
			
			while (resultSet.next()){
				Agents tempAgents = new Agents();
				tempAgents.setAgentid(resultSet.getInt("AGENT_ID"));
				tempAgents.setFirstName(resultSet.getString("AGENT_FNAME"));
				tempAgents.setLastName(resultSet.getString("AGENT_LNAME"));
				tempAgents.setAddress1String(resultSet.getString("AGENT_ADDRESS1"));
				tempAgents.setAddress2String(resultSet.getString("AGENT_ADDRESS2"));
				agentsArrayList.add(tempAgents);
				System.out.println(tempAgents.getFirstName());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DatabaseChecks.getAgentsList");
		return agentsArrayList;
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		Boolean test = DatabaseChecks.checkUser("John","John");
		System.out.println("return values is: " + test);

	}



}
