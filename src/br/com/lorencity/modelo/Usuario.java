package br.com.lorencity.modelo;

public class Usuario {
	private String nome;
	private String CPF;
	private int id;
	
	public Usuario(){
		
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome.trim();
	}

	public String getCpf() {
		return this.CPF;
	}

	public void setCpf(String CPF) {
		this.CPF = CPF.trim();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
