package com.automation.training.utils;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BaseWebServices {
	protected RequestSpecification request = RestAssured.with();
	protected Response response;
	String body ="{\r\n" + 
			"  \"name\": \"CandyGuerrero\",\r\n" + 
			"  \"type\": \"simple\",\r\n" + 
			"  \"regular_price\": \"21.99\",\r\n" + 
			"  \"description\": \"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",\r\n" + 
			"  \"short_description\": \"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.\",\r\n" + 
			"  \"categories\": [\r\n" + 
			"    {\r\n" + 
			"      \"id\": 9\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 14\r\n" + 
			"    }\r\n" + 
			"  ],\r\n" + 
			"  \"images\": [\r\n" + 
			"    {\r\n" + 
			"      \"src\": \"http://demo.woothemes.com/woocommerce/wp-content/uploads/sites/56/2013/06/T_2_front.jpg\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"src\": \"http://demo.woothemes.com/woocommerce/wp-content/uploads/sites/56/2013/06/T_2_back.jpg\"\r\n" + 
			"    }\r\n" + 
			"  ]\r\n" + 
			"}";
	public int requestPostWithtAuthorization() {

		return request.given().header("Authorization", "Basic " + "4oCLc2hvcG1hbmFnZXI64oCLIOKAi2F4WTIgcmltYyBTek85IGNvYmYgQVpCdyBOTG5Y").contentType(ContentType.JSON)
				.body(body).when()
				.post("http://34.205.174.166/wp-json/wc/v3/products").then().extract().path("id");

	}
	
	public Response requestDeleteWithtAuthorization(int id) {

		return 		request.given().contentType(ContentType.JSON)
		.delete("http://34.205.174.166/wp-json/wc/v3/products/"+id+"?force=true");

	}
	
}
