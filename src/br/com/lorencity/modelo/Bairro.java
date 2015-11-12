package br.com.lorencity.modelo;

public class Bairro {

	private String nome;
	private int id;
	
	public Bairro(){
		
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome.trim();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
