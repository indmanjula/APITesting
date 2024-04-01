package com.excelutils;



import io.restassured.RestAssured;
import io.restassured.response.Response;



public class RestAssured_Utils {

	public Response post_URL(String BaseURL, String URI, String newlyAddedUser) {

		BaseURL = BaseURL + URI;
		return RestAssured.given().header("Content-Type", "application/json").body(newlyAddedUser).log().all().post(BaseURL);

	}
	
}
