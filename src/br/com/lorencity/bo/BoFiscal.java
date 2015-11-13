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

	public List<Fiscal> listarFiscais() {
		List<Fiscal> listaFiscais;
		FiscalDAO fiscalDAO;
		try{
			fiscalDAO = new FiscalDAO();
			listaFiscais = fiscalDAO.listarFiscais();
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
				
		return listaFiscais;
	}
	
	public Fiscal consultarFiscal(Usuario usuario) {
		FiscalDAO fiscalDAO;
		Fiscal fiscal;
		try{
			fiscal = (Fiscal) usuario;
			
			fiscalDAO = new FiscalDAO();
			fiscal = fiscalDAO.consultarFiscal(fiscal);
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
				
		return fiscal;
	}

	public String atualizar(Usuario usuario) {
		FiscalDAO fiscalDAO;
		Fiscal fiscal;
		
		try{
			fiscal = (Fiscal) usuario;
			
			fiscalDAO = new FiscalDAO();
			fiscalDAO.atualizar(fiscal);
			
			return "Usuário atualizado com sucesso!";
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
	}

	public String remover(Usuario usuario) {
		FiscalDAO fiscalDAO;
		Fiscal fiscal;
		
		try{
			fiscal = (Fiscal) usuario;
			
			fiscalDAO = new FiscalDAO();
			fiscalDAO.remover(fiscal);
			
			return "Usuário removido com sucesso!";
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
	}

	public String inserir(Usuario usuario) {
		FiscalDAO fiscalDAO;
		
		try{
			fiscalDAO = new FiscalDAO();
			fiscalDAO.inserir(usuario);
			
			return "Usuário inserido com sucesso!";
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
	}

}
