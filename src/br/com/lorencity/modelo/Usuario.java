package br.com.lorencity.modelo;

public class Usuario {
	private String nome;
	private String CPF;
	
	public Usuario(){
		
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome.trim();
	}

	public String getCPF() {
		return this.CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF.trim();
	}
}
