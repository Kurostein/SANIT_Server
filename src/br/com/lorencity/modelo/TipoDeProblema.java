package br.com.lorencity.modelo;

public class TipoDeProblema {

	private String problema;
	private String prioridade;
	
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema.trim();
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade.trim();
	}
	
	
}
