package Javagui;

import java.sql.Connection;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class javaMYSQLTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/";
		String username ="root";
		String password ="prachi13*data";
		
		try {
			
			Connection connection = DriverManager.getConnection(url,username,password);
		//Class.forName("com.mysql.cj.jdbc.Driver").DriverManager.getConnection();
		System.out.println("Connected to the database");
		} catch (SQLException e) {
			System.out.println("Oops,error!");
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}
}