package br.com.lorencity.bo;

import br.com.lorencity.modelo.DadosDenuncia;

public class BoUsuario {
	//Recebe a ação requisitada ao servlet e a executa.
		
	private String action;
	private DadosDenuncia denunciaApurada;
	
	public BoUsuario(){
		this.action = null;
		this.denunciaApurada = null;
	}
	
	public DadosDenuncia doServletAction(DadosDenuncia dadosDenuncia, String action){	
		this.denunciaApurada = dadosDenuncia;
		this.action = action;
		
		doAction(action);
		
		return this.denunciaApurada;
	}
	
	public void doAction(String Action){
		//Chama função de ação baseado na ação passada.
		
		switch (action) {
		case "inserir":
			inserirDados();
			break;
		case "remover":
			removerDados();
			break;
		case "atualizar":
			atualizarDados();
			break;
		case "consultar":
			consultarDados();
			break;
			default:
			break;
		}
	}
		private void consultarDados() {
		// TODO Auto-generated method stub
		
	}
		private void atualizarDados() {
		// TODO Auto-generated method stub
		
	}
		private void removerDados() {
		// TODO Auto-generated method stub
		
	}
		private void inserirDados() {
		// TODO Auto-generated method stub
		
	}
	
}

