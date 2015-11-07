package br.com.lorencity.modelo;


public class Ocorrencia {
	private Endereco endereco;
	private String tipoProblema;
	private String dirFoto;

	public Ocorrencia(){
		
	}
	
	public String getTipoProblema() {
		return this.tipoProblema;
	}

	public void setTipoProblema(String tipoProblema) {
		this.tipoProblema = tipoProblema;
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
