package br.com.lorencity.generators;

import java.sql.Connection;

public class ConnectionFactory {
	
	private Connection connection;

	private ConnectionFactory(){
		
	}
	
	public Connection getConnection(){
		
		
		return this.connection;
	}
}
