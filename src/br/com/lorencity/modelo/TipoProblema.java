package br.com.lorencity.modelo;

public class TipoProblema {

	private int id_problema;
	private String descricao;
	
	public TipoProblema(){
		
	}
	
	public int getId_problema() {
		return id_problema;
	}
	public void setId_problema(int id_problema) {
		this.id_problema = id_problema;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
