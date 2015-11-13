package br.com.lorencity.bo;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.lorencity.dao.GestorDAO;
import br.com.lorencity.modelo.Bairro;
import br.com.lorencity.modelo.Estatistica;
import br.com.lorencity.modelo.Gestor;
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
	
	public List<Ocorrencia> consultarOcorrenciasPorBairro(Bairro bairro) throws RuntimeException{
		GestorDAO gestorDAO;
		List<Ocorrencia> lista = null;
		
		try {
			gestorDAO = new GestorDAO();
			lista = gestorDAO.consultarOcorrenciasPorBairro(bairro);
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
	
	public List<Estatistica> consultarNumeroDeOcorrenciasPorProblema() throws RuntimeException{
		GestorDAO gestorDAO;
		List<Estatistica> lista = null;
		
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
	
	public List<Estatistica> consultarNumeroDeOcorrenciasPorBairro() throws RuntimeException{
		GestorDAO gestorDAO;
		List<Estatistica> lista = null;
		
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
	
	public boolean checkLoginGestor(Gestor gestor){
		Gestor gestorBanco;
		GestorDAO gestorDAO;
		
		try{
			gestorDAO = new GestorDAO();
			gestorBanco = gestorDAO.consultarLoginGestor(gestor);
			
			if(gestor.getMatricula() == gestorBanco.getMatricula()){
				if(gestor.getSenha().equals(gestorBanco.getSenha())){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		} catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			e.printStackTrace();
			throw new RuntimeException("Problema na conexão com o banco.", e);
		} catch (SQLException e) {
			System.err.println("Problema na consulta do banco.");
			e.printStackTrace();
			throw new RuntimeException("Problema na consulta do banco.", e);
		}
	}
}
