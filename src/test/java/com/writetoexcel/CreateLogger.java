package com.writetoexcel;

import java.io.File;

public class CreateLogger {

	
	public static void createLog4jLoggerDirectory(){
		
		String logFilePath = System.getProperty("user.dir")+ "\\target\\LogFile\\log4j-Logger.log";
		
		System.out.println("******** Log file path is : " + logFilePath);
		File reportFile = new File(logFilePath);
	
		try {
			
			if(!reportFile.exists()){
				new File(System.getProperty("user.dir")+ "\\target\\LogFile").mkdir();
				reportFile.createNewFile();
			}
			
		} catch (Exception e) {
			
		}
	}
}
