package com.bridgelabz.datadriven.utility;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {
	
	private FileInputStream excelFile;
	private XSSFWorkbook xWorkbook;
	private XSSFSheet xSheet;
	private XSSFCell xCell;
	private XSSFRow xRow;
	
	
	/**Method: To Read Xlsx File 
	 * @param path
	 */
	public void ReadXlsxFile(String path) {
		
		try {
			excelFile = new FileInputStream(path);
			xWorkbook = new XSSFWorkbook(excelFile);
			xSheet = xWorkbook.getSheetAt(0);
			excelFile.close();
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
	public String getData(String sheetName, String colName, int row) {
	
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
}
