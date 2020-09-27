package com.automation.training.utils.maps;

import java.util.HashMap;
import java.util.Map;

import com.automation.training.utils.PropertiesLoader;

public class UrlMaps {
	  private UrlMaps() {
		    throw new IllegalStateException("Utility class");
		  }
	 static PropertiesLoader prop = new PropertiesLoader();
	private static final String URLBASE = "URLBASE";
	private static final String DRIVER="DRIVER";
	 public static Map<String, String> urlInit() {
		    Map<String, String> response = new HashMap<>();
		    response.put(URLBASE, prop.getProperty(URLBASE));
		    response.put(DRIVER, prop.getProperty(DRIVER));
		    return response;
		  }

}
