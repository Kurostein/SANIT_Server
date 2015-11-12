package br.com.lorencity.bo;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.lorencity.dao.FiscalDAO;
import br.com.lorencity.modelo.Fiscal;
import br.com.lorencity.modelo.Usuario;

public class BoFiscal {
	
	public BoFiscal(){
		
	}

	public List<Fiscal> consultarFiscais() {
		List<Fiscal> listaFiscais;
		FiscalDAO fiscalDAO;
		try{
			fiscalDAO = new FiscalDAO();
			listaFiscais = fiscalDAO.consultarFiscais();
		}catch(SQLException e){
			System.err.println("Problema na conex�o com o banco.");
			throw new RuntimeException("Problema na conex�o com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conex�o com o banco.");
			throw new RuntimeException("Problema na conex�o com o banco.", e);
		}
				
		return listaFiscais;
	}

	public String atualizar(Usuario usuario) {
		FiscalDAO fiscalDAO;
		
		try{
			fiscalDAO = new FiscalDAO();
			fiscalDAO.remover(usuario);
			
			return "Usu�rio atualizado com sucesso!";
		}catch(SQLException e){
			System.err.println("Problema na conex�o com o banco.");
			throw new RuntimeException("Problema na conex�o com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conex�o com o banco.");
			throw new RuntimeException("Problema na conex�o com o banco.", e);
		}
	}

	public String remover(Usuario usuario) {
		FiscalDAO fiscalDAO;
		
		try{
			fiscalDAO = new FiscalDAO();
			fiscalDAO.remover(usuario);
			
			return "Usu�rio removido com sucesso!";
		}catch(SQLException e){
			System.err.println("Problema na conex�o com o banco.");
			throw new RuntimeException("Problema na conex�o com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conex�o com o banco.");
			throw new RuntimeException("Problema na conex�o com o banco.", e);
		}
	}

	public String inserir(Usuario usuario) {
		FiscalDAO fiscalDAO;
		
		try{
			fiscalDAO = new FiscalDAO();
			fiscalDAO.inserir(usuario);
			
			return "Usu�rio inserido com sucesso!";
		}catch(SQLException e){
			System.err.println("Problema na conex�o com o banco.");
			throw new RuntimeException("Problema na conex�o com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conex�o com o banco.");
			throw new RuntimeException("Problema na conex�o com o banco.", e);
		}
	}

}
