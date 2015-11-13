package br.com.lorencity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import br.com.lorencity.modelo.Endereco;
import br.com.lorencity.modelo.Estatistica;
import br.com.lorencity.modelo.Fiscal;
import br.com.lorencity.modelo.Ocorrencia;
import br.com.lorencity.modelo.TipoDeProblema;

public class GestorDAO {

	private Connection conn;
	
	public GestorDAO() throws SQLException, NamingException{
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/sanit");
		conn = ds.getConnection();
		
		System.out.println("Conectado com ao banco de dados!");
	}
	
	//Retorna todas as ocorrências.
	public List<Ocorrencia> listarOcorrencias() throws SQLException{
		List<Ocorrencia> listaOcorrencias;
		Ocorrencia ocorrencia;
		Fiscal fiscal;
		TipoDeProblema problema;
		
		String sql = "SELECT O.logradouro, O.numero, B.bairro, O.cep, P.tipo_problema, "
				+ "P.prioridade"
				+ "FROM ocorrencias O, bairros B, problemas P"
				+ "WHERE O.id_bairro = B.id_bairro"
				+ "AND O.id_problema = P.id_problema"
				+ "ORDER BY B.bairro;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		listaOcorrencias = new ArrayList<Ocorrencia>();
		
		while(rs.next()){
			fiscal = new Fiscal();
			fiscal.setMatricula(Integer.parseInt(rs.getString("matricula")));
			
			ocorrencia = new Ocorrencia();
			ocorrencia.setEndereco(Endereco.preencherEndereco(rs));
			ocorrencia.setFiscal(fiscal);
			
			problema = new TipoDeProblema();
			problema.setProblema(rs.getString("tipo_problema"));
			problema.setPrioridade(rs.getInt("prioridade"));
			
			ocorrencia.setTipoProblema(problema);
			
			listaOcorrencias.add(ocorrencia);
		}

		stmt.close();
		conn.close();
		rs.close();
		
		return listaOcorrencias;
	}
	
	//Retorna todas as ocorrências do bairro informado.
	public List<Ocorrencia> consultarOcorrenciasPorBairro(Endereco endereco) throws SQLException{
		List<Ocorrencia> listaOcorrencias;
		Ocorrencia ocorrencia;
		Fiscal fiscal;
		TipoDeProblema problema;
		
		String sql = "SELECT O.logradouro, O.numero, B.bairro, O.cep, P.tipo_problema, "
				+ "P.prioridade"
				+ "FROM ocorrencias O, bairros B, problemas P"
				+ "WHERE B.bairro = '"+endereco.getBairro()+"'"
				+ "AND O.id_bairro = B.id_bairro"
				+ "AND O.id_problema = P.id_problema"
				+ "ORDER BY B.bairro;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		listaOcorrencias = new ArrayList<Ocorrencia>();
		
		while(rs.next()){
			fiscal = new Fiscal();
			fiscal.setMatricula(Integer.parseInt(rs.getString("matricula")));
			
			ocorrencia = new Ocorrencia();
			ocorrencia.setEndereco(Endereco.preencherEndereco(rs));
			ocorrencia.setFiscal(fiscal);
			
			problema = new TipoDeProblema();
			problema.setProblema(rs.getString("tipo_problema"));
			problema.setPrioridade(rs.getInt("prioridade"));
			
			ocorrencia.setTipoProblema(problema);
			
			listaOcorrencias.add(ocorrencia);
		}

		stmt.close();
		conn.close();
		rs.close();
		
		return listaOcorrencias;
	}
	
	//Retorna todas as ocorrências do tipo de problema informado.
	public List<Ocorrencia> consultarOcorrenciasPorProblema(TipoDeProblema problema) throws SQLException{
		List<Ocorrencia> listaOcorrencias;
		Ocorrencia ocorrencia;
		Fiscal fiscal;
		
		String sql = "SELECT O.logradouro, O.numero, B.bairro, O.cep, P.tipo_problema, "
				+ "P.prioridade"
				+ "FROM ocorrencias O, bairros B, problemas P"
				+ "WHERE P.tipo_problema = '"+problema.getProblema()+"'"
				+ "AND O.id_bairro = B.id_bairro"
				+ "AND O.id_problema = P.id_problema"
				+ "ORDER BY P.tipo_problema;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		listaOcorrencias = new ArrayList<Ocorrencia>();
		
		while(rs.next()){
			fiscal = new Fiscal();
			fiscal.setMatricula(Integer.parseInt(rs.getString("matricula")));
			
			ocorrencia = new Ocorrencia();
			ocorrencia.setEndereco(Endereco.preencherEndereco(rs));
			ocorrencia.setFiscal(fiscal);
			
			problema = new TipoDeProblema();
			problema.setProblema(rs.getString("tipo_problema"));
			problema.setPrioridade(rs.getInt("prioridade"));
			
			ocorrencia.setTipoProblema(problema);
			
			listaOcorrencias.add(ocorrencia);
		}

		stmt.close();
		conn.close();
		rs.close();
		
		return listaOcorrencias;
	}
	
	//Retorna todos os problemas e a quantidade de ocorrencias em cada um.
	public List<Estatistica> consultarNumeroDeOcorrenciasPorProblema() throws SQLException{
		List<Estatistica> lista;
		Estatistica estatistica;
		
		String sql = "SELECT P.tipo_problema AS Problema, COUNT(O.id_ocorrencia) AS Quantidade"
				+ "FROM problemas P, ocorrencias O"
				+ "WHERE O.id_problema = P.id_problema"
				+ "GROUP BY Problema"
				+ "ORDER BY Quantidade DESC;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		lista = new ArrayList<Estatistica>();
		
		while(rs.next()){
			estatistica = new Estatistica();
			estatistica.setDescricao(rs.getString("Problema"));
			estatistica.setQuantidade(rs.getInt("Quantidade"));
			
			lista.add(estatistica);
		}

		stmt.close();
		conn.close();
		rs.close();
		
		return lista;
	}
	
	//Retorna todos os bairros e a quantidade de ocorrencias em cada um.
	public List<Estatistica> consultarNumeroDeOcorrenciasPorBairro() throws SQLException{
		List<Estatistica> lista;
		Estatistica estatistica;
		
		String sql = "SELECT B.bairro AS Bairro, COUNT(O.id_ocorrencia) AS Quantidade"
				+ "FROM bairros B, ocorrencias O"
				+ "WHERE O.id_bairro = B.id_bairro"
				+ "GROUP BY Bairro"
				+ "ORDER BY Quantidade DESC;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		lista = new ArrayList<Estatistica>();
		
		while(rs.next()){
			estatistica = new Estatistica();
			estatistica.setDescricao(rs.getString("Bairro"));
			estatistica.setQuantidade(rs.getInt("Quantidade"));
			
			lista.add(estatistica);
		}

		stmt.close();
		conn.close();
		rs.close();
		
		return lista;
	}
}
