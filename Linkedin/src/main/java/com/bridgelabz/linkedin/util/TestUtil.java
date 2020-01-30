package com.bridgelabz.linkedin.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.linkedin.base.TestBase;

public class TestUtil extends TestBase{
	
	public final static long PAGE_LOAD_TIMEOUT = 30;
	public final static long IMPLICITLY_WAIT = 30;
	
	
	/**Method: To get SignIn Data form Xlsx file
	 * @return Data in Object Form
	 */
	public static Object[][] getData(String sheetName) {
		
		try {
			file = new FileInputStream("/home/admin1/eclipse-workspace/Mayuresh/Selenium/Linkedin/src/main/java/com/bridgelabz/linkedin/repository/LinkedInTestData.xlsx");
			workBook = WorkbookFactory.create(file);
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = workBook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
	public static String[] getJsonData() throws IOException, ParseException {
		
		FileReader file = new FileReader("/home/admin1/eclipse-workspace/Mayuresh/Selenium/Linkedin/src/main/java/com/bridgelabz/linkedin/repository/testdata.json");
		
		JSONParser parser = new JSONParser();
		
		Object javaObj = parser.parse(file);
		
		JSONObject object = (JSONObject) javaObj;
		
		JSONArray array = (JSONArray) object.get("SignIn Data");
		
		String arr[] = new String[array.size()];
		
		for (int i = 0; i < array.size(); i++) {
			
			JSONObject obj = (JSONObject) array.get(i);
			System.out.println(obj);
			String username = (String) obj.get("userName");
			String password = (String) obj.get("password");
			System.out.println("USername: "+username);
			System.out.println("Password: "+password);
			arr[i] = username +","+password;
		}
		return arr;
	}
}
