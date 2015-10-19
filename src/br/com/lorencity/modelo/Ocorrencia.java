package br.com.lorencity.modelo;

public class Ocorrencia {
	private Endereco endereco;
	private String dirFoto;

	public Ocorrencia(){
		
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getDirFoto() {
		return dirFoto;
	}

	public void setDirFoto(String dirFoto) {
		this.dirFoto = dirFoto.trim();
	}
	
	
}
