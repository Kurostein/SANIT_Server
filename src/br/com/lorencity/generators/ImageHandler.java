package br.com.lorencity.generators;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;

public class ImageHandler {
	
	private final String DEFAULT_IMG_FILE_PATH = "C:/SANIT Project/media/images/";
	
	public ImageHandler(){
		
	}
	
	public File writeImage(byte[] imageByteArray) throws RuntimeException{
		File imageFile;
		
		FileNameGenerator fng;
		
		try{
			System.out.println("Iniciando processo de criação da imagem.");
			
			fng = new FileNameGenerator();
			
			imageFile = new File(DEFAULT_IMG_FILE_PATH + fng.generateImgFileName());
			writeImageBytesToFile(imageFile, imageByteArray);
						
			System.out.println("Imagem salva em: "+imageFile.getPath());
		}catch(IOException e){
			System.err.println("Erro na escrita da imagem.");
			throw new RuntimeException("Erro na escrita da imagem.", e);
		}
		
		return imageFile;
	}
	
	private void writeImageBytesToFile(File imageFile, byte[] imageByteArray)
			throws IOException, FileNotFoundException {
		
		ByteArrayInputStream input = new ByteArrayInputStream(imageByteArray);
		OutputStream output = new FileOutputStream(imageFile);
		
		IOUtils.copy(input, output);
		
		output.flush();
		output.close();
		input.close();
	}
	
	public String filePathFormat(String path){
		//Retorna o path modificado para inclusão no DB.
		return path.replace("\\", "\\\\");
	}
	
	private boolean isArrayEmpty(byte[] byteArray){
		return byteArray == null;
	}
	
	public byte[] decodeBase64Image(String base64Image) throws NullPointerException{
		byte[] imageByteArray = Base64.decodeBase64(base64Image);
		
		if(isArrayEmpty(imageByteArray)){
			throw new NullPointerException("Conversão de imagem falhou.");
		}
		
		return imageByteArray;
	}
}
