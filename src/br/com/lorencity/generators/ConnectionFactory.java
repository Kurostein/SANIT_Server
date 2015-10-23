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
		String url = "jdbc:mysql://ce-mysql-sanit.c99gmmgff5ac.sa-east-1.rds.amazonaws.com:3306/sanitdb";
		Connection con = DriverManager.getConnection(url, user, password);		
		System.out.println("Conectado ao DB!");
		return con;
	}
}
