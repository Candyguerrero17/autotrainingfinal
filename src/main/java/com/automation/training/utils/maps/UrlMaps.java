package com.automation.training.utils.maps;

import java.util.HashMap;
import java.util.Map;

import com.automation.training.utils.others.PropertiesLoader;
import com.automation.training.utils.text.ConfigProperties;
/**
 * Class fot put values of file config.properties
 * 
 * @author  *
 */
public class UrlMaps {
	  private UrlMaps() {
		    throw new IllegalStateException("Utility class");
		  }
	 static PropertiesLoader prop = new PropertiesLoader();
	 /**
	  * Method for pu data form  config.properties .
	  * 
	  * @return values of  config.properties *
	  */
	 public static Map<String, String> urlInit() {
		    Map<String, String> response = new HashMap<>();
		    response.put(ConfigProperties.URLBASE, prop.getProperty(ConfigProperties.URLBASE));
		    response.put(ConfigProperties.URLBASEQA, prop.getProperty(ConfigProperties.URLBASEQA));
		    response.put(ConfigProperties.DRIVER, prop.getProperty(ConfigProperties.DRIVER));
		    return response;
		  }

}
