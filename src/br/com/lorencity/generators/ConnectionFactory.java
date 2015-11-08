package br.com.lorencity.generators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection(String dbName, String user, String password) throws SQLException{
		dbName = dbName.toLowerCase();
		switch(dbName){
			case "mysql": return ConnectionFactory.getMySQLConnection(user, password);
			default: return null;
		}
	}
	
	private static Connection getMySQLConnection(String user, String password) throws SQLException{
		String url = "jdbc:mysql://localhost:3306/sanit";
		Connection con = DriverManager.getConnection(url, user, password);		
		System.out.println("Conectado ao database!");
		return con;
	}
}
