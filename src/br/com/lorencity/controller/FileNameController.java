package br.com.lorencity.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileNameController {
	
	private String filePath;
	private String counterFileName = "nameCounterFile.txt";
	private String defaultNameToGenerate = "SANIT_Img_";
	
	public FileNameController(){
		
	}
	
	public FileNameController(String filePath){
		setFilePath(filePath);
	}
	
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	
	public void setCounterFileName(String counterFileName){
		this.counterFileName = counterFileName;
	}
	
	public void setDefaultFileName(String defaultNameToGenerate){
		this.defaultNameToGenerate = defaultNameToGenerate;
	}
	
	public String generateImgFileName(){
		String fileName = this.defaultNameToGenerate
				+ getLastCounterNumber() + ".jpeg";
		
		return fileName;
	}
	
	private String getLastCounterNumber(){
		File nameCounterFile = new File(this.filePath + this.counterFileName);
		String lastImgNumber;
		
		try {
			lastImgNumber = readLastFileNumber(nameCounterFile);
		} catch (FileNotFoundException e) {
			lastImgNumber = getCounterFromDB();
			createNameCounterFile(lastImgNumber);
		}
		
		return lastImgNumber;
	}
	
	private String readLastFileNumber(File file) throws FileNotFoundException{
		Scanner fileIn = new Scanner(file);
		String lastNumber = fileIn.next();
		fileIn.close();
		
		return lastNumber;
	}
	
	private String getCounterFromDB(){
		//Read DB image table to get the number of last image added.
		String lastNumber;
		
		/**
		 * Implementar conex�o com o DB para ler o contador da �ltima imagem.
		 */
		
		return lastNumber;
	}
	
	private void createNameCounterFile(String lastNumber){
		//create a file in the class specified directory, writing the received String.
		
		/**
		 * Implementar cria��o do file.txt com o �ltimo n�mero (pregui�a no momento).
		 */
	}
}