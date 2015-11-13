package br.com.lorencity.bo;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.json.JSONArray;

import br.com.lorencity.dao.BairrosDAO;
import br.com.lorencity.dao.UsuarioDAO;
import br.com.lorencity.modelo.Bairro;

public class BoBairros {

	public BoBairros(){
		
	}

	public String consultarBairrosJson() {
		JSONArray bairros = new JSONArray();

		try{
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			bairros = usuarioDAO.getListaBairros();
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
		
		String sJson = bairros.toString();
		
		return sJson;
	}

	public List<Bairro> listarBairros() {
		List<Bairro> listaBairros;
		try{
			BairrosDAO bairrosDAO = new BairrosDAO();
			listaBairros = bairrosDAO.listarBairros();
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
				
		return listaBairros;
	}

	public String atualizar(Bairro bairro) {
		BairrosDAO bairrosDAO;
		
		try{
			bairrosDAO = new BairrosDAO();
			bairrosDAO.atualizar(bairro);
			
			return "Bairro atualizado com sucesso!";
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
	}

	public String remover(Bairro bairro) {
		BairrosDAO bairrosDAO;
		
		try{
			bairrosDAO = new BairrosDAO();
			bairrosDAO.remover(bairro);
			
			return "Bairro removido com sucesso!";
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
	}

	public String inserir(Bairro bairro) {
		BairrosDAO bairrosDAO;
		
		try{
			bairrosDAO = new BairrosDAO();
			bairrosDAO.inserir(bairro);
			
			return "Bairro inserido com sucesso!";
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
	}
	
	public Bairro consultarBairro(Bairro bairro) {
		BairrosDAO bairrosDAO;
		
		try{
			bairrosDAO = new BairrosDAO();
			bairro = bairrosDAO.consultarBairro(bairro);
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
				
		return bairro;
	}
}
