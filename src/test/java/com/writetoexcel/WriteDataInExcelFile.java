package com.writetoexcel;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataInExcelFile {
	
	public static void main(String[] args) throws Exception {

		//Log4j setup start
		CreateLogger.createLog4jLoggerDirectory();
		String logFilePath = System.getProperty("user.dir")+ "\\target\\LogFile\\log4j-Logger.log";
		System.out.println("######## Log file path is : " + logFilePath);
		PropertyConfigurator.configure(logFilePath);
		Logger logger = Logger.getLogger(WriteDataInExcelFile.class);
		
		//end of log4j setup
		
		//Pre- requisite : Apache POI dependency /Jars
		//Step 1- create workbook object
		 XSSFWorkbook wb = new XSSFWorkbook();
		 logger.info("Step 1- create workbook object");

		 //step 2 - create	sheet
		 XSSFSheet sheetdata = wb.createSheet("sheetTestData2");
		 logger.info("step 2 - create	sheet");
		
		 //step 3 - create row
		 Row row_0 = sheetdata.createRow(0);
		 logger.info("step 3 - create row");

		/* //step 4 - create cell
		 Cell cell_A = row_0.createCell(0);
		Cell cell_B = row_0.createCell(1);
		
		//step  -  Add data in Excel File using File Otput stream object
		cell_A.setCellValue("Google");
		cell_B.setCellValue("Yahoo");
*/

		for (int rows =0; rows<10; rows++){
			Row row = sheetdata.createRow(rows);
			 logger.info("step 3 - create row : " + rows);
			
			 for(int column =0; column<10;column++){
				
				 int intSetCellValue = (int)(Math.random()*100);
				Cell cell = row.createCell(column);
				
				cell.setCellValue(intSetCellValue);
				logger.info("Step 4 - Create cell : " + column +  " set value : " + intSetCellValue);
			}
		}
		
		
		
		//Step 6 - connecting Excel File -
		 File file = new File(System.getProperty("user.dir")
		+ "/src/main/resources/testData/ExcelFiles/Automation TestData Input.xlsx");
		FileOutputStream fout = new FileOutputStream(file);
		
		logger.info("Step 6 - connecting Excel File ");

		 wb.write(fout);

		 
		
		 //step 7 - close connection
		 fout.close();
		 logger.info("step 7 - close connection");
		 
		 System.out.println("testdata added successfully");
		 }


}
