package com.bridgelabz.datadriven.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData {
	
	private static XSSFWorkbook xWorkbook;
	private static XSSFSheet xSheet;
	private static FileInputStream excelFile;
	
	
	/**Method: To get Data form Xlsx file
	 * @return Data in Object Form
	 */
	public static Object[][] getLoginData() {
		
		try {
			excelFile = new FileInputStream("/home/admin1/eclipse-workspace/Mayuresh/Selenium/DataDrivenFramework/xlsxfiles/FacebookTestData.xlsx");
			xWorkbook = new XSSFWorkbook(excelFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		xSheet = xWorkbook.getSheet("LoginDataTest");
		int row = xSheet.getLastRowNum();
		
		Object[][] data = new Object[row][2];
		int k=0;	
		for (int i = 0; i < row; i++) {
			
			String username = xSheet.getRow(i+1).getCell(k).getStringCellValue();
			String password = xSheet.getRow(i+1).getCell(k+1).getStringCellValue();
			System.out.println("Row "+i+" UserName: "+username);
			System.out.println("Row "+i+" Password: "+password);
			System.out.println();
			data[i][0] = username;
			data[i][1] = password;
		}
		return data;
	}

}
