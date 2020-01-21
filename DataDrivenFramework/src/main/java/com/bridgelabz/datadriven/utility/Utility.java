package com.bridgelabz.datadriven.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {
	
	private FileInputStream excelFileInput;
	private FileOutputStream excelFileOutput;
	private XSSFWorkbook xWorkbook;
	private XSSFSheet xSheet;
	private XSSFCell xCell;
	private XSSFRow xRow;
	private String path = "/home/admin1/eclipse-workspace/Mayuresh/Selenium/DataDrivenFramework/xlsxfiles/FacebookTestData.xlsx";
	
	
	/**Method: To Read Xlsx File 
	 * @param path
	 */
	public void readXlsxFile(String path) {
		
		try {
			excelFileInput = new FileInputStream(path);
			xWorkbook = new XSSFWorkbook(excelFileInput);
			xSheet = xWorkbook.getSheetAt(0);
			excelFileInput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**Method: To get Data from the xlsx file to perform automation
	 * @param sheetName
	 * @param colName
	 * @param row
	 * @return Data in String format
	 */
	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, String colName, int row) {
	
		int colNum = -1;
		xSheet = xWorkbook.getSheet(sheetName);
		xRow = xSheet.getRow(0);
		
		for (int i = 0; i < xRow.getLastCellNum(); i++) {
			if(xRow.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				colNum = i;
			}
		}
		
		xRow = xSheet.getRow(row - 1);
		xCell = xRow.getCell(colNum);
		
		if(xCell.getCellType() == CellType.STRING) {
			return xCell.getStringCellValue();
		}
		else if(xCell.getCellTypeEnum() == CellType.NUMERIC || xCell.getCellTypeEnum() == CellType.FORMULA){
			
			String cellValue = String.valueOf(xCell.getNumericCellValue());
			
			if (HSSFDateUtil.isCellDateFormatted(xCell)) {
				DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
				Date date = xCell.getDateCellValue();
				cellValue = df.format(date);
			}
			return cellValue;
		}
		else if (xCell.getCellTypeEnum() == CellType.BLANK) {
			return "";
		}
		else {
			return String.valueOf(xCell.getBooleanCellValue());
		}
	}
	
	
	/**Method: To get the Count of rows present in the xlsx file
	 * @param sheetName
	 * @return Count of Rows
	 */
	public int getRowCount(String sheetName){
		
		int index = xWorkbook.getSheetIndex(sheetName);
		if(index == -1)
			return 0;
		else{
		xSheet = xWorkbook.getSheetAt(index);
		int number = xSheet.getLastRowNum()+1;
		return number;
		}
	}
	
	
	/**Method: To Add New Column in Xlsx Sheet
	 * @param sheetName
	 * @param colName
	 * @return Boolean Values
	 */
	public boolean addColumn(String sheetName,String colName){
		
		try{				
			int index = xWorkbook.getSheetIndex(sheetName);
			if(index==-1)
				return false;
			
		XSSFCellStyle style = xWorkbook.createCellStyle();
		
		xSheet = xWorkbook.getSheetAt(index);
		
		xRow = xSheet.getRow(0);
		if (xRow == null)
			xRow = xSheet.createRow(0);
		
		if(xRow.getLastCellNum() == -1)
			xCell = xRow.createCell(0);
		else
			xCell = xRow.createCell(xRow.getLastCellNum());
	        xCell.setCellValue(colName);
	        xCell.setCellStyle(style);
	        
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	
	
	/**Method: To write Data into Xlsx File
	 * @param sheetName
	 * @param colName
	 * @param rowNum
	 * @param data
	 * @return Boolean Values
	 */
	public boolean setCellData(String sheetName,String colName,int rowNum, String data){

		try {

			if (rowNum <= 0)
				return false;

			int index = xWorkbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			xSheet = xWorkbook.getSheetAt(index);
			xRow = xSheet.getRow(0);

			for (int i = 0; i < xRow.getLastCellNum(); i++) {
				if (xRow.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName)) {
					colNum = i;
				}
			}

			if (colNum == -1)
				return false;

			xSheet.autoSizeColumn(colNum);
			xRow = xSheet.getRow(rowNum - 1);
			if (xRow == null)
				xRow = xSheet.createRow(rowNum - 1);

			xCell = xRow.getCell(colNum);
			if (xCell == null)
				xCell = xRow.createCell(colNum);

			xCell.setCellValue(data);

			excelFileOutput = new FileOutputStream(path);
			xWorkbook.write(excelFileOutput);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	/**Method: To Add Sheet in perticXlsx File
	 * @param sheetname
	 * @return Boolean Values
	 */
	public boolean addXlsxSheet(String path, String sheetname){		
		
		FileOutputStream fileOut;
		try {
			 xWorkbook.createSheet(sheetname);	
			 fileOut = new FileOutputStream(path);
			 xWorkbook.write(fileOut);
		     fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**Method: To Check sheet exist in Xlsx file or not
	 * @param sheetName
	 * @return Boolean Value
	 */
	public boolean isXlsxSheetExist(String sheetName){
		
		int index = xWorkbook.getSheetIndex(sheetName);
		if(index == -1){
			index=xWorkbook.getSheetIndex(sheetName.toUpperCase());
			return false;
		}
		else
			return true;
	}	
}
