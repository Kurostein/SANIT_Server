package br.com.lorencity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.JSONArray;

import br.com.lorencity.modelo.Ocorrencia;

public class UsuarioDAO {
	
	private Connection conn;
	
	public UsuarioDAO() throws NamingException, SQLException{
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/sanit");
		conn = ds.getConnection();
		
		System.out.println("Conectado com ao banco de dados!");
	}
	
	public void inserir(Ocorrencia ocorrencia) throws SQLException{
		String sql = "INSERT INTO ocorrencias "
				+ "(logradouro, numero, id_bairro, complemento, cep, id_problema, id_anexo, "
				+ "data_criacao, data_atualizacao) "
				+ "VALUES ("
				+ "'" + ocorrencia.getEndereco().getLogradouro() + "', "
				+ "'" + ocorrencia.getEndereco().getNumero() + "', "
				+ "(SELECT id_bairro FROM bairros WHERE bairro = '" + ocorrencia.getEndereco().getBairro() + "'), "
				+ "'" + ocorrencia.getEndereco().getComplemento() + "', "
				+ "'" + ocorrencia.getEndereco().getCep() + "', "
				+ "(SELECT id_problema FROM problemas WHERE tipo_problema = '" + ocorrencia.getTipoProblema().getProblema() + "'), "
				+ "(SELECT id_anexo FROM anexos WHERE caminho_anexo = '" + ocorrencia.getImagePath() + "'), "
				+ "CURDATE(), "
				+ "CURDATE());";
		
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		System.out.println("Dados inseridos no banco!");

		stmt.close();
		conn.close();
	}
	
	public JSONArray getListaProblemas() throws SQLException{
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
	
	public JSONArray getListaBairros() throws SQLException{
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
