package br.com.lorencity.bo;

import java.sql.SQLException;

import org.json.JSONArray;

import br.com.lorencity.dao.UsuarioDAO;
import br.com.lorencity.modelo.Ocorrencia;

public class BoUsuario {
	//Recebe a a��o requisitada ao servlet e a executa.

	public BoUsuario(){

	}
	
	public String doServletAction(Ocorrencia ocorrencia, String action){	
		
		String response;
		
		switch (action) {
		case "inserir":
			response = inserirDados(ocorrencia);
			return response;
		case "remover":
			response = removerDados();
			return response;
		case "atualizar":
			response = atualizarDados();
			return response;
		case "consultarProblemas":
			response = consultarTiposProblemas();
			return response;
			default:
			return "Filter Error";
		}
	}
	
	private String consultarTiposProblemas() {
		JSONArray tiposProblemas = new JSONArray();
		tiposProblemas.put("Vazamento de �gua");
		tiposProblemas.put("Vazamento de esgoto");
		/*
		try{
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			tiposProblemas = usuarioDAO.getListaProblemas();
		}catch(SQLException e){
			System.err.println("Problema na conex�o com o banco.");
			throw new RuntimeException("Problema na conex�o com o banco.", e);
		}
		 */
		String sJson = tiposProblemas.toString();
		System.out.println(sJson);
		
		return sJson;
	}
	
	private String inserirDados(Ocorrencia ocorrencia) {
		try{
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.inserir(ocorrencia);
		}catch(SQLException e){
			System.err.println("Problema na conex�o com o banco.");
			throw new RuntimeException("Problema na conex�o com o banco.", e);
		}
		
		return "Ocorr�ncia adicionada com sucesso.";
	}
	
	private String atualizarDados() {
		return "N�o implementado";
	}
	
	private String removerDados() {
		return "N�o implementado";
	}
	
}
