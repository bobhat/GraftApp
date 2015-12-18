package graft.ie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private Connection dbConnection = null;
	private static String connectionString = "jdbc:derby://localhost:1527/c:\\Users\\Server\\workspace\\EE562\\GraftApp\\PropertyDB\\PropertyDB;create=true;user=me;password=mine";
	
	//Connstructor that just set the database connection
	public DBConnection(){
		
		this.dbConnection = setDBConnection();
		
	}
	
	private static Connection setDBConnection() {
		
		Connection con = null;
		
		System.out.println("DatabaseChecks.checkUser.working1");
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			System.out.println("DatabaseChecks.checkUser.working1.1");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DatabaseChecks.checkUser.working2");
		try {
			con = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DatabaseChecks.checkUser.Connected");
		
		return con;
	
	}
	
	public Connection getDBConnection(){
		
		return dbConnection;
	}
	
}
