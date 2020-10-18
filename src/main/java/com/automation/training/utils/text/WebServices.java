package com.automation.training.utils.text;
/**
 * Class of constans of string to web services
 * 
 * @author 
 *
 */
public class WebServices {
	public static final String  BODY ="{\r\n" + 
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
	
	public static final String  TOKEN = "4oCLc2hvcG1hbmFnZXI64oCLIOKAi2F4WTIgcmltYyBTek85IGNvYmYgQVpCdyBOTG5Y";
	public static final String AUTHORIZATION= "Authorization";
	public static final String BASIC = "Basic " ;
	public static final String BASE_POST = "http://34.205.174.166/wp-json/wc/v3/products";
	public static final String ID = "id";
	public static final String  DELETE_FIRST= "http://34.205.174.166/wp-json/wc/v3/products/";
	public static final String  DELETE_SECOND= "?force=true";
	
}
