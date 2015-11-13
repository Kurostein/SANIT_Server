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

import br.com.lorencity.modelo.TipoDeProblema;

public class ProblemasDAO {

	private Connection conn;
	
	public ProblemasDAO() throws SQLException, NamingException{
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/sanit");
		conn = ds.getConnection();
		
		System.out.println("Conectado com ao banco de dados!");
	}
	
	public void inserir(TipoDeProblema problema) throws SQLException{
		String sql = "INSERT INTO problemas (tipo_problema, prioridade) "
				+ "VALUES ('"+problema.getProblema()+"', '"+problema.getPrioridade()+"');";
		
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
		System.out.println("Dados inseridos no banco!");
		
		stmt.close();
		conn.close();
	}
	
	public void remover(TipoDeProblema problema) throws SQLException{
		String sql = "DELETE FROM problemas WHERE tipo_problema = '"+problema.getProblema()+"';";
		
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
		System.out.println("Dados removidos do banco!");
		
		stmt.close();
		conn.close();
	}
	
	public void atualizar(TipoDeProblema problema) throws SQLException{
		String sql = "UPDATE problemas "
				+ "SET tipo_problema = '"+problema.getProblema()+"', "
				+ "prioridade = "+problema.getPrioridade()
				+ " WHERE id_problema = "+problema.getId()+";";
		
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
		System.out.println("Dados atualizados no banco!");
		
		stmt.close();
		conn.close();
	}
	
	public List<TipoDeProblema> listarProblemas() throws SQLException{
		List<TipoDeProblema> listaProblemas;
		TipoDeProblema problema;
		
		String sql = "SELECT * FROM problemas;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		listaProblemas = new ArrayList<TipoDeProblema>();
		
		while(rs.next()){
			problema = new TipoDeProblema();
			problema.setId(rs.getInt("id_problema"));
			problema.setProblema(rs.getString("tipo_problema"));
			problema.setPrioridade(rs.getInt("prioridade"));
			listaProblemas.add(problema);
		}

		stmt.close();
		conn.close();
		rs.close();
		
		return listaProblemas;
	}
	
	public TipoDeProblema consultarProblema(TipoDeProblema problema) throws SQLException{
	
		String sql = "SELECT * FROM problemas WHERE id_problema = "+problema.getId()+";";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		rs.next();

		problema = new TipoDeProblema();
		problema.setId(rs.getInt("id_problema"));
		problema.setProblema(rs.getString("tipo_problema"));
		problema.setPrioridade(rs.getInt("prioridade"));

		stmt.close();
		conn.close();
		rs.close();
		
		return problema;
	}
	
	public JSONArray consultarProblemasJson() throws SQLException{
		JSONArray jsonArray;
		String sql = "SELECT tipo_problema FROM problemas;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		jsonArray = new JSONArray();
		
		while(rs.next()){
			jsonArray.put(rs.getString("tipo_problema"));
		}
		
		stmt.close();
		conn.close();
		rs.close();
		
		return jsonArray;
	}
}
