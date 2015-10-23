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

import br.com.lorencity.modelo.Endereco;

public final class ModelFormat {
	
	private static final String IMG_FILE_PATH = "C:/SANIT Project/media/images/";
	
	private ModelFormat(){
		
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
	
	public static String gravarImgFile(JSONObject jsonRequest) throws RuntimeException{
		/*
		 * Converve a imagem de String Base64, salva em um arquivo e retorna
		 * o endereço em que foi salvo.
		 */
		
		String base64Img = jsonRequest.getString("imagem");
		String imgFilePath;
		File imgFile;
		byte[] imageByteArray;
		
		FileNameGenerator fng = new FileNameGenerator();
		
		try{
			System.out.println("Recuperando a imagem.");
			
			imageByteArray = Base64.decodeBase64(base64Img);
			isArrayEmpty(imageByteArray);
			
			imgFile = new File(ModelFormat.IMG_FILE_PATH + fng.generateImgFileName());
			
			writeImgToServerDir(imgFile, imageByteArray);
			
			imgFilePath = imgFile.getPath();
			
			System.out.println("Imagem salva em: "+imgFilePath);
			
		}catch(IOException e){
			System.err.println("Erro de conversão ou escrita da imagem.");
			throw new RuntimeException("Erro na escrita da imagem.", e);
		}catch (NullPointerException e) {
			System.err.println("Erro na conversão da imagem, Array null.");
			throw new RuntimeException("Erro na conversão da imagem.", e);
		}
		
		return imgFilePath;
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
