package br.com.lorencity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;

import br.com.lorencity.generators.ConnectionFactory;
import br.com.lorencity.modelo.Ocorrencia;

public class UsuarioDAO {
	
	private Connection conn;
	private String dbName = "mysql";
	private String dbUser = "sanit";
	private String dbPass = "sanitserver";
	
	public UsuarioDAO() throws SQLException{
		this.conn = ConnectionFactory.getConnection(this.dbName,
				this.dbUser, this.dbPass);
	}
	
	public void inserir(Ocorrencia ocorrencia) throws SQLException{
		String sql = "INSERT INTO Ocorrencia" +
						"(logradouro, numero, cod_bairro, complemento, cep" +
						"latitude, longitude, cod_problema, cod_anexo, " +
						"confirmado, data_criacao, data_atualizacao)" +
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, ocorrencia.getEndereco().getLogradouro());
		stmt.setInt(2, ocorrencia.getEndereco().getNumero());
		stmt.setString(3, ocorrencia.getEndereco().getBairro());
		stmt.setString(4, ocorrencia.getEndereco().getComplemento());
		stmt.setString(5, ocorrencia.getEndereco().getCep());
		//stmt.setString(6, ocorrencia.getEndereco().getLatitude());
		//stmt.setString(7, ocorrencia.getEndereco().getLongitude());
		stmt.setString(8, ocorrencia.getTipoProblema());
		stmt.setString(9, ocorrencia.getDirFoto());
		stmt.setString(10, null);
		//stmt.setString(11, ocorrencia.getDataCriacao());
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
		
		return jsonArray;
	}
}
