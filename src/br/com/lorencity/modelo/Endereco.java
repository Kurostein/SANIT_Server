package br.com.lorencity.modelo;

import org.json.JSONObject;

public class Endereco {
	private String logradouro;
	private int numero;
	private String bairro;
	private String complemento;
	private String cep;
	
	public Endereco(){
		
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro.trim();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro.trim();
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento.trim();
	}
	
	public static Endereco preencherEndereco(JSONObject jsonRequest){
		Endereco endereco = new Endereco();
		
		System.out.println("Inserindo dados do endereço.");
		
		endereco.setLogradouro(jsonRequest.getString("logradouro"));
		endereco.setNumero(Integer.parseInt(jsonRequest.getString("numero")));
		endereco.setBairro(jsonRequest.getString("bairro"));
		endereco.setComplemento(jsonRequest.getString("complemento"));
		endereco.setCep(jsonRequest.getString("cep"));
		
		return endereco;
	}
}
