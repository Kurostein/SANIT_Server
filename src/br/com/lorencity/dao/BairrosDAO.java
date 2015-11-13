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

import br.com.lorencity.modelo.Bairro;

public class BairrosDAO {

	private Connection conn;
	
	public BairrosDAO() throws SQLException, NamingException{
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/sanit");
		conn = ds.getConnection();
		
		System.out.println("Conectado com ao banco de dados!");
	}
	
	public void inserir(Bairro bairro) throws SQLException{
		String sql = "INSERT INTO bairros (bairro) VALUES ('"+bairro.getNome()+"');";
		
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
		System.out.println("Dados inseridos no banco!");
		
		stmt.close();
		conn.close();
	}
	
	public void remover(Bairro bairro) throws SQLException{
		String sql = "DELETE FROM bairros WHERE bairro = '"+bairro.getNome()+"';";
		
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
		System.out.println("Dados removidos do banco!");
		
		stmt.close();
		conn.close();
	}
	
	public void atualizar(Bairro bairro) throws SQLException{
		String sql = "UPDATE bairros SET bairro = '"+bairro.getNome()+"' "
				+ "WHERE id_bairro = "+bairro.getId()+";";
		
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
		System.out.println("Dados atualizados no banco!");
		
		stmt.close();
		conn.close();
	}
	
	public List<Bairro> listarBairros() throws SQLException{
		List<Bairro> listaBairros;
		Bairro bairro;
		
		String sql = "SELECT * FROM bairros;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		listaBairros = new ArrayList<Bairro>();
		
		while(rs.next()){
			bairro = new Bairro();
			bairro.setNome(rs.getString("bairro"));
			bairro.setId(rs.getInt("id_bairro"));
			
			listaBairros.add(bairro);
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
	
	public Bairro consultarBairro(Bairro bairro) throws SQLException{
		
		String sql = "SELECT * FROM bairros WHERE id_bairro = "+bairro.getId()+";";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		bairro = new Bairro();
		
		rs.next();
		
		bairro.setNome(rs.getString("bairro"));
		bairro.setId(rs.getInt("id_bairro"));

		stmt.close();
		conn.close();
		rs.close();
		
		return bairro;
	}
}
