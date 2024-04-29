package com.cas.news.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataHandler {

	FileInputStream fileInputStream;
	FileOutputStream fileOutputStream;

	final String filepath = System.getProperty("user.dir") + "\\ExcelData\\CASNews.xlsx";

	public void writeTooltipData(String[][] data) {
		if (!filePresent()) {
			createNewFile();
		}
		
		try {
			fileInputStream = new FileInputStream(filepath);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			
			XSSFSheet sheet = workbook.getSheet("ToolTips");
			
			int lastRowNum = sheet.getLastRowNum();
			
			int i = 1;
			
			for(String[] arr : data) {
				XSSFRow row = sheet.createRow(lastRowNum + i);
				
				row.createCell(0).setCellValue(lastRowNum + i);
				
				for(byte j = 1; j <= arr.length; j++) {
					row.createCell(j).setCellValue(arr[j-1]);
				}
				
				i++;
			}
			
			fileInputStream.close();
			
			fileOutputStream = new FileOutputStream(filepath);
			
			workbook.write(fileOutputStream);
			
			fileOutputStream.close();
			
			workbook.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private boolean filePresent() {
		return (new File(filepath)).exists();
	}
	
	private void createNewFile() {
		File excelFile = new File(filepath);

		try {
			excelFile.createNewFile();
			
			fileOutputStream = new FileOutputStream(excelFile);
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			
			XSSFSheet sheet = workbook.createSheet("ToolTips");
			
			XSSFRow rowHeaders = sheet.createRow(0);
			
			rowHeaders.createCell(0).setCellValue("Serial No.");
			rowHeaders.createCell(1).setCellValue("Parent Page");
			rowHeaders.createCell(2).setCellValue("News Title");
			rowHeaders.createCell(3).setCellValue("Tooltip Text");
			rowHeaders.createCell(4).setCellValue("Result");
			
			workbook.write(fileOutputStream);
			
			fileOutputStream.close();
			
			workbook.close();
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
