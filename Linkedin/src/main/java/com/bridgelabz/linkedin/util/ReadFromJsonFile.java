package com.bridgelabz.linkedin.util;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFromJsonFile {

	public static void main(String[] args) throws IOException, ParseException {

		FileReader file = new FileReader("/home/admin1/eclipse-workspace/Mayuresh/Selenium/Linkedin/src/main/java/com/bridgelabz/linkedin/repository/demodata.json");
		
		JSONParser parser = new JSONParser();
		
		Object javaObject = parser.parse(file);
		
		JSONObject object = (JSONObject) javaObject;
		
		System.out.println("First Name is: "+object.get("firstname"));
		System.out.println("Last Name is: "+object.get("lastname"));
		
		JSONArray array = (JSONArray) object.get("address");
		
		for (int i = 0; i < array.size(); i++) {
			
			object = (JSONObject) array.get(i);
			
			System.out.println("State Name is: "+object.get("state"));
			System.out.println("Country Name is: "+object.get("country"));
			System.out.println("Pincode is: "+object.get("Pin Code"));
		}
	}
}
