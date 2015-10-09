package br.com.lorencity.generators;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONObject;

import br.com.lorencity.controller.FileNameController;
import br.com.lorencity.modelo.DadosDenuncia;
import br.com.lorencity.modelo.Endereco;

public final class ModelPattern {
	/*
	 * Recebe o JSONObject request, obtém o endereço da imagem no diretório do 
	 * servidor e retorna o objeto modelo preenchido. 
	 */
	
	private static final String FILE_PATH = "C:/SANIT Project/media/images/";
	
	private ModelPattern(){
		
	}
	
	public static DadosDenuncia preencherModelo(JSONObject jsonRequest) 
			throws RuntimeException{
		//Preenche o objeto modelo com os dados enviados do request, e o retorna.
		
		System.out.println("Criando modelo de dados.");
		
		DadosDenuncia modeloDados = new DadosDenuncia();
		
		preencherCamposEndereco(modeloDados, jsonRequest);
		preencherDirFoto(modeloDados, jsonRequest);

		System.out.println("Modelo criado e preenchido.");
		return modeloDados;
	}
	
	private static void preencherCamposEndereco(DadosDenuncia modelo, JSONObject jsonRequest){
		Endereco endereco = new Endereco();
		
		System.out.println("Inserindo dados do endereço.");
		endereco.setLogradouro(jsonRequest.getString("logradouro"));
		endereco.setNumero(Integer.parseInt(jsonRequest.getString("numero")));
		endereco.setBairro(jsonRequest.getString("bairro"));
		endereco.setComplemento(jsonRequest.getString("complemento"));
		
		modelo.setEndereco(endereco);
	}
	
	private static void preencherDirFoto(DadosDenuncia modelo, JSONObject jsonRequest) 
			throws RuntimeException{
		
		System.out.println("Recuperando a imagem.");
				
		String base64Img = jsonRequest.getString("imagem");
		File imgFile;
		byte[] imageByteArray;
		
		FileNameController fnc = new FileNameController();
		fnc.setFilePath(ModelPattern.FILE_PATH);
		
		try{
			imageByteArray = Base64.decodeBase64(base64Img);
			isArrayEmpty(imageByteArray);
			
			imgFile = new File(ModelPattern.FILE_PATH + fnc.generateImgFileName());
			
			writeImgToServerDir(imgFile, imageByteArray);
			
			modelo.setDirFoto(imgFile.getPath());
			
			System.out.println("Imagem salva em: "+modelo.getDirFoto());
			
		}catch(IOException e){
			System.err.println("Erro de conversão ou escrita da imagem.");
			throw new RuntimeException("Erro na escrita da imagem.", e);
		}catch (NullPointerException e) {
			System.err.println("Erro na conversão da imagem, Array null.");
			throw new RuntimeException("Erro na conversão da imagem.", e);
		}
	}
	
	private static void writeImgToServerDir(File imgFile, byte[] imageByteArray)
			throws IOException, FileNotFoundException {
		
		ByteArrayInputStream input = new ByteArrayInputStream(imageByteArray);
		OutputStream output = new FileOutputStream(imgFile);
		
		IOUtils.copy(input, output);
		
		output.flush();
		output.close();
	}
	
	private static void isArrayEmpty(byte[] byteArray) throws NullPointerException{
		if(byteArray == null){
			throw new NullPointerException("Array imagem nulo.");
		}
	}
	
}
