package com.automation.training.utils;

/**
 * Class of load json
 * 
 * @author 
 *
 */

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.automation.training.utils.text.Urls;



public class PropertiesJson {

	public static JSONObject read(String file) throws IOException, ParseException {
		
		JSONParser jsonParser = new JSONParser();
		Object object = jsonParser
				.parse(new InputStreamReader(new FileInputStream(System.getProperty(Urls.USER_DIR) + file), StandardCharsets.UTF_8));

		return (JSONObject) object;

	}

	
	
	
	public String getJson(String prop, String file) throws IOException, ParseException {
		
		
		return (String) read(file).get(prop);
	}
}
