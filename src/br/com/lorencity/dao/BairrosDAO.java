package br.com.lorencity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.JSONArray;

public class BairrosDAO {

	private Connection conn;
	
	public BairrosDAO() throws SQLException, NamingException{
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/sanit");
		conn = ds.getConnection();
		
		System.out.println("Conectado com ao banco de dados!");
	}
	
	public void inserir(String bairro) throws SQLException{
		String sql = "INSERT INTO bairros (bairro) VALUES ('"+bairro+"');";
		
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
		System.out.println("Dados inseridos no banco!");
		
		stmt.close();
		conn.close();
	}
	
	public void remover(String bairro) throws SQLException{
		String sql = "DELETE FROM bairros WHERE bairro = '"+bairro+"';";
		
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
		System.out.println("Dados removidos do banco!");
		
		stmt.close();
		conn.close();
	}
	
	public void atualizar(String bairro){
		
	}
	
	public List<String> consultarBairros() throws SQLException{
		List<String> listaBairros;
		String sql = "SELECT bairro FROM bairros;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		listaBairros = new ArrayList<String>();
		
		while(rs.next()){
			listaBairros.add(rs.getString("bairro"));
		}

		stmt.close();
		conn.close();
		rs.close();
		
		return listaBairros;
	}
	
	public JSONArray consultarBairrosJson() throws SQLException{
		JSONArray jsonArray;
		String sql = "SELECT bairro FROM bairros;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		jsonArray = new JSONArray();
		
		while(rs.next()){
			jsonArray.put(rs.getString("bairro"));
		}

		stmt.close();
		conn.close();
		rs.close();
		
		return jsonArray;
	}
}
