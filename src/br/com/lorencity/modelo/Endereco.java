package br.com.lorencity.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public static Endereco preencherEndereco(JSONObject addressData){
		Endereco endereco = new Endereco();
		
		System.out.println("Inserindo dados do endereço.");
		
		endereco.setLogradouro(addressData.getString("logradouro"));
		endereco.setNumero(Integer.parseInt(addressData.getString("numero")));
		endereco.setBairro(addressData.getString("bairro"));
		endereco.setComplemento(addressData.getString("complemento"));
		endereco.setCep(addressData.getString("cep"));
		
		return endereco;
	}
	
	public static Endereco preencherEndereco(ResultSet addressData) throws SQLException{
		Endereco endereco = new Endereco();
		
		System.out.println("Inserindo dados do endereço.");
		
		endereco.setLogradouro(addressData.getString("logradouro"));
		endereco.setNumero(Integer.parseInt(addressData.getString("numero")));
		endereco.setBairro(addressData.getString("bairro"));
		endereco.setComplemento(addressData.getString("complemento"));
		endereco.setCep(addressData.getString("cep"));
		
		return endereco;
	}
}
