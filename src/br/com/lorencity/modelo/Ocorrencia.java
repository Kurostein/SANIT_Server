package br.com.lorencity.modelo;


public class Ocorrencia {
	private Endereco endereco;
	private TipoProblema tipoProblema;
	private String dirFoto;

	public Ocorrencia(){
		
	}
	
	public TipoProblema getTipoProblema() {
		return tipoProblema;
	}

	public void setTipoProblema(TipoProblema tipoProblema) {
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
