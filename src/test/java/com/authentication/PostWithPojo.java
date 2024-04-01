package com.authentication;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excelutils.ExcelUtils;
import com.excelutils.RestAssured_Utils;
import com.pojo.AllPojo;
import com.pojo.Register;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class PostWithPojo{
	
	Map<String, String> data = new HashMap<String, String>();
	public String URI = "http://localhost:3000";
	
	RestAssured_Utils restUtils = new RestAssured_Utils();
	
	// Primary excel file
		String originalExcelPath = System.getProperty("user.dir") + File.separator + "Resource" + File.separator
				+ "TestDataSource.xls";
		
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "http://localhost:3000/";
	}
	
	 
	@DataProvider(name = "firstDataProvider")
	public Object[][] userEntry() throws Exception {
		Object[][] retObjArr = ExcelUtils.get_Data(originalExcelPath, "Register", 5);
		System.out.println("getData function executed!!");
		return retObjArr;
	}

	@Test (priority = 1,  dataProvider = "firstDataProvider")
	public void postRequest(String Email, String Password, String FirstName, String LastName, String Age) {

		// Iterating with data
				data.put("Email", Email);
				data.put("Password", Password);
				data.put("Firstname",FirstName);
				data.put("Lastname",LastName);
				data.put("Age",  Age);

				AllPojo postNewUser = new AllPojo();
				String newlyAddedUser = postNewUser.addNewUser(data);
				System.out.println("--->" + newlyAddedUser);

				Response postUser = restUtils.post_URL(URI, "/users/register", newlyAddedUser);
				postUser.prettyPrint();
		
	}
	
}