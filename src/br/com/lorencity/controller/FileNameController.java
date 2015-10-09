package br.com.lorencity.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileNameController {
	
	private String filePath;
	private String counterFileName = "nameCounterFile.txt";
	private String defaultNameToGenerate = "SANIT_Img_";
	private String fileExtension = ".jpeg";
	
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
	
	public void setFileExtension(String fileExt){
		this.fileExtension = fileExt;
	}
	
	public String generateImgFileName(){
		String fileName = this.defaultNameToGenerate
				+ getLastCounterNumber() + this.fileExtension;
		
		return fileName;
	}
	
	private String getLastCounterNumber(){
		File nameCounterFile = new File(this.filePath + this.counterFileName);
		String lastImgNumber;
		
		try {
			lastImgNumber = readLastFileNumber(nameCounterFile);
			writeNumberCount(nameCounterFile, Integer.parseInt(lastImgNumber));
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
	
	private void writeNumberCount(File counterFile, int actualCounter){
		/**
		 * apagar o texto atual e escrever o próximo.
		 */
	}
	
	private String getCounterFromDB(){
		//Read DB image table to get the number of last image added.
		String lastNumber;
		
		/**
		 * Implementar conexão com o DB para ler o contador da última imagem.
		 */
		
		return lastNumber;
	}
	
	private void createNameCounterFile(String lastNumber){
		//create a file in the class specified directory, writing the received String.
		
		/**
		 * Implementar criação do file.txt com o último número (preguiça no momento).
		 */
	}
}
