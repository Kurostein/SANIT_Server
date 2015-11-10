package br.com.lorencity.modelo;


public class Ocorrencia {
	private Endereco endereco;
	private TipoDeProblema tipoProblema;
	private String imagePath;
	private Fiscal fiscal;

	public Ocorrencia(){
		
	}
	
	public Fiscal getFiscal() {
		return this.fiscal;
	}

	public void setFiscal(Fiscal fiscal) {
		this.fiscal = fiscal;
	}

	public TipoDeProblema getTipoProblema() {
		return this.tipoProblema;
	}

	public void setTipoProblema(TipoDeProblema tipoProblema) {
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
