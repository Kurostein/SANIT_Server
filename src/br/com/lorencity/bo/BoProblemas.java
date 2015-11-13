package br.com.lorencity.bo;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.json.JSONArray;

import br.com.lorencity.dao.ProblemasDAO;
import br.com.lorencity.modelo.TipoDeProblema;

public class BoProblemas {

	public BoProblemas(){
		
	}

	public String consultarProblemasJson() {
		JSONArray listaProblemas;

		try{
			ProblemasDAO problemasDAO = new ProblemasDAO();
			listaProblemas = problemasDAO.consultarProblemasJson();
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
		
		String sJson = listaProblemas.toString();
		
		return sJson;
	}
	
	public TipoDeProblema consultarProblema(TipoDeProblema problema) {
		try{
			ProblemasDAO problemasDAO = new ProblemasDAO();
			problema = problemasDAO.consultarProblema(problema);
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
				
		return problema;
	}

	public List<TipoDeProblema> listarProblemas() {
		List<TipoDeProblema> listaProblemas;
		try{
			ProblemasDAO problemasDAO = new ProblemasDAO();
			listaProblemas = problemasDAO.listarProblemas();
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
				
		return listaProblemas;
	}

	public String atualizar(TipoDeProblema problema) {
		ProblemasDAO problemasDAO;
		
		try{
			problemasDAO = new ProblemasDAO();
			problemasDAO.atualizar(problema);
			
			return "Problema atualizado com sucesso!";
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
	}

	public String remover(TipoDeProblema problema) {
		ProblemasDAO problemasDAO;
		
		try{
			problemasDAO = new ProblemasDAO();
			problemasDAO.remover(problema);
			
			return "Problema removido com sucesso!";
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
	}

	public String inserir(TipoDeProblema problema) {
		ProblemasDAO problemasDAO;
		
		try{
			problemasDAO = new ProblemasDAO();
			problemasDAO.inserir(problema);
			
			return "Problema adicionado com sucesso!";
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
	}
}
