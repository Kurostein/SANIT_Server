package br.com.lorencity.bo;

import org.json.JSONArray;

import br.com.lorencity.modelo.Ocorrencia;

public class BoUsuario {
	//Recebe a a��o requisitada ao servlet e a executa.
		
	private String action;
	private Ocorrencia ocorrenciaTmp;
	
	public BoUsuario(){
		this.action = null;
		this.ocorrenciaTmp = null;
	}
	
	public String doServletAction(Ocorrencia ocorrenciaModelo, String action){	
		this.ocorrenciaTmp = ocorrenciaModelo;
		this.action = action;
		
		return doAction(action);
	}
	
	public String doAction(String Action){
		//Chama fun��o de a��o baseado na a��o passada.
		String response;
		
		switch (action) {
		case "inserir":
			response = inserirDados();
			return response;
		case "remover":
			response = removerDados();
			return response;
		case "atualizar":
			response = atualizarDados();
			return response;
		case "consultar":
			response = consultarDados();
			return response;
			default:
			return "Filter Error";
		}
	}
	
	private String consultarDados() {
		JSONArray tiposProblemas = new JSONArray();
		tiposProblemas.put("Vazamento de �gua");
		tiposProblemas.put("Vazamento de esgoto");
		
		String sJson = tiposProblemas.toString();
		System.out.println(sJson);
		
		return sJson;
	}
	
	private String atualizarDados() {
		return "N�o implementado";
	}
	
	private String removerDados() {
		return "N�o implementado";
	}
	
	private String inserirDados() {
		return "Sucesso";
	}
	
}

