package br.com.lorencity.modelo;

public class TipoDeProblema {

	private String problema;
	private int prioridade;
	
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema.trim();
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	
}
