package br.com.lorencity.modelo;

import java.util.Date;

public class Ocorrencia {
	private Endereco endereco;
	private String tipoProblema;
	private String dirFoto;
	private Date dataCriacao;

	public Ocorrencia(){
		
	}
	
	public String getTipoProblema() {
		return tipoProblema;
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
	
	public Date getDataCriacao(){
		return this.dataCriacao;
	}
	
	public void setDataCriacao(){
		this.dataCriacao = new Date();
	}
}
