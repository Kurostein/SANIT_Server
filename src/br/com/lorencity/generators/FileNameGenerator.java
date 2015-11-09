package br.com.lorencity.generators;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class FileNameGenerator {
	
	private String defaultName = "SANIT_Img_";
	private String fileExtension = ".jpeg";
	
	public FileNameGenerator(){
		
	}
	
	public void setDefaultFileName(String defaultNameToGenerate){
		this.defaultName = defaultNameToGenerate;
	}
	
	public void setFileExtension(String fileExt){
		this.fileExtension = fileExt;
	}
	
	public String generateImgFileName(){
		String fileName = this.defaultName + getCurrentTimestamp() + this.fileExtension;
		return fileName;
	}
	
	private String getCurrentTimestamp(){
		String sTimestamp;
		
		Date currentTime = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		sTimestamp = dateFormat.format(currentTime);
		return sTimestamp;
	}
	
}
