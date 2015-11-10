package br.com.lorencity.modelo;

public class Fiscal extends Usuario{
	
	private int matricula;
	private String senha;
	
	public Fiscal(){
		
	}

	public int getMatricula() {
		return this.matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha.trim();
	}
	
}
