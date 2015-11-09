package br.com.lorencity.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ImagemDAO {
	
	private Connection conn;

	public ImagemDAO() throws NamingException, SQLException{
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/sanit");
		conn = ds.getConnection();
		
		System.out.println("Conectado com ao banco de dados!");
	}
	
	public void inserir(String imagePath) throws SQLException{
		String sql = "INSERT INTO anexos (caminho_anexo) VALUES ('"+imagePath+"');";
		
		System.out.println(sql);
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		System.out.println("Dados inseridos no banco!");
	}
}
