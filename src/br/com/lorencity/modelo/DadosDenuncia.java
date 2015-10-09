package br.com.lorencity.modelo;

public class DadosDenuncia {
	private Endereco endereco;
	private String dirFoto;

	public DadosDenuncia(){
		
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
