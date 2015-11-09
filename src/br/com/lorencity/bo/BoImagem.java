package br.com.lorencity.bo;

import java.sql.SQLException;

import javax.naming.NamingException;

import br.com.lorencity.dao.ImagemDAO;
import br.com.lorencity.generators.ImageHandler;

public class BoImagem {

	public BoImagem(){
		
	}
	
	public String adicionar(String base64Image){
		byte[] imageByteArray;
		String imagePath;
		String modifiedImagePath;
		
		ImageHandler imageHandler = new ImageHandler();
		
		imageByteArray = imageHandler.decodeBase64Image(base64Image);
		imagePath = imageHandler.writeImage(imageByteArray).getPath();
		modifiedImagePath = imageHandler.filePathFormat(imagePath);
		//Formatando path para inserir corretamente no DB.
		try{
			ImagemDAO imagemDao = new ImagemDAO();
			imagemDao.inserir(modifiedImagePath);
		}catch(SQLException e){
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}catch (NamingException e) {
			e.printStackTrace();
			System.err.println("Problema na conexão com o banco.");
			throw new RuntimeException("Problema na conexão com o banco.", e);
		}
		
		return modifiedImagePath;
	}
}
