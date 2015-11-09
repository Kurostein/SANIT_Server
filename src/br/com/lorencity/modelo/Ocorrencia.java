package br.com.lorencity.modelo;


public class Ocorrencia {
	private Endereco endereco;
	private String tipoProblema;
	private String imagePath;

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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath.trim();
	}

}
