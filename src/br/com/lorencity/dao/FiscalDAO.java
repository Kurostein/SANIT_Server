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

import br.com.lorencity.modelo.Fiscal;
import br.com.lorencity.modelo.Usuario;

public class FiscalDAO {

	private Connection conn;
	
	public FiscalDAO() throws SQLException, NamingException{
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/sanit");
		conn = ds.getConnection();
		
		System.out.println("Conectado com ao banco de dados!");
	}
	

	public void inserir(Usuario usuario) throws SQLException{
		Fiscal fiscal = (Fiscal) usuario;
		
		String sql = "INSERT INTO fiscais (cpf, nome, matricula, senha) "
				+ "VALUES ('?', '?', '?', '?');";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, fiscal.getCPF());
		stmt.setString(2, fiscal.getNome());
		stmt.setInt(3, fiscal.getMatricula());
		stmt.setString(4, fiscal.getSenha());
		
		stmt.executeUpdate(sql);
		
		System.out.println("Usuário inserido no banco!");
		
		stmt.close();
		conn.close();
	}
	
	public void remover(Usuario usuario) throws SQLException{
		Fiscal fiscal = (Fiscal) usuario;
		
		String sql = "DELETE FROM fiscais WHERE matricula = '"+fiscal.getMatricula()+"';";
		
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
		System.out.println("Usuário removido do banco!");
		
		stmt.close();
		conn.close();
	}
	
	public void atualizar(Usuario usuario){
		
	}
	
	public List<Fiscal> consultarFiscais() throws SQLException{
		List<Fiscal> listaUsuarios;
		Fiscal fiscal;
		
		String sql = "SELECT * FROM fiscais;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		listaUsuarios = new ArrayList<Fiscal>();
		
		while(rs.next()){
			fiscal = new Fiscal();
			fiscal.setNome(rs.getString("nome"));
			fiscal.setCPF(rs.getString("cpf"));
			fiscal.setMatricula(Integer.parseInt(rs.getString("matricula")));
			fiscal.setSenha(rs.getString("senha"));
			
			listaUsuarios.add(fiscal);
		}

		stmt.close();
		conn.close();
		rs.close();
		
		return listaUsuarios;
	}
}
