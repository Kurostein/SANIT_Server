package br.com.lorencity.bo;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.json.JSONObject;

import br.com.lorencity.dao.GestorDAO;
import br.com.lorencity.modelo.Endereco;
import br.com.lorencity.modelo.Ocorrencia;
import br.com.lorencity.modelo.TipoDeProblema;

public class BoGestor {
	
	public BoGestor(){

	}
	
	public List<Ocorrencia> listarOcorrencias() throws RuntimeException{
		GestorDAO gestorDAO;
		List<Ocorrencia> lista = null;
		
		try {
			gestorDAO = new GestorDAO();
			lista = gestorDAO.listarOcorrencias();
		} catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		} catch (SQLException e) {
			System.err.println("Problema na consulta do banco.");
			throw new RuntimeException("Problema na consulta do banco.", e);
		}
		
		return lista;
	}
	
	public List<Ocorrencia> consultarOcorrenciasPorBairro(Endereco endereco) throws RuntimeException{
		GestorDAO gestorDAO;
		List<Ocorrencia> lista = null;
		
		try {
			gestorDAO = new GestorDAO();
			lista = gestorDAO.consultarOcorrenciasPorBairro(endereco);
		} catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		} catch (SQLException e) {
			System.err.println("Problema na consulta do banco.");
			throw new RuntimeException("Problema na consulta do banco.", e);
		}
		
		return lista;
	}
	
	public List<Ocorrencia> consultarOcorrenciasPorProblema(TipoDeProblema problema) throws RuntimeException{
		GestorDAO gestorDAO;
		List<Ocorrencia> lista = null;
		
		try {
			gestorDAO = new GestorDAO();
			lista = gestorDAO.consultarOcorrenciasPorProblema(problema);
		} catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		} catch (SQLException e) {
			System.err.println("Problema na consulta do banco.");
			throw new RuntimeException("Problema na consulta do banco.", e);
		}
		
		return lista;
	}
	
	public List<JSONObject> consultarNumeroDeOcorrenciasPorProblema() throws RuntimeException{
		GestorDAO gestorDAO;
		List<JSONObject> lista = null;
		
		try {
			gestorDAO = new GestorDAO();
			lista = gestorDAO.consultarNumeroDeOcorrenciasPorProblema();
		} catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		} catch (SQLException e) {
			System.err.println("Problema na consulta do banco.");
			throw new RuntimeException("Problema na consulta do banco.", e);
		}
		
		return lista;
	}
	
	public List<JSONObject> consultarNumeroDeOcorrenciasPorBairro() throws RuntimeException{
		GestorDAO gestorDAO;
		List<JSONObject> lista = null;
		
		try {
			gestorDAO = new GestorDAO();
			lista = gestorDAO.consultarNumeroDeOcorrenciasPorBairro();
		} catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		} catch (SQLException e) {
			System.err.println("Problema na consulta do banco.");
			throw new RuntimeException("Problema na consulta do banco.", e);
		}
		
		return lista;
	}
}
