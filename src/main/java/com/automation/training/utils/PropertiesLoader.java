package com.automation.training.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import com.automation.training.utils.text.Urls;
/**
 * Class of load config.properties
 * 
 * @author 
 *
 */
public class PropertiesLoader {

	private static PropertiesLoader instance;
	private static Properties properties = new Properties();

	public PropertiesLoader() {
		load();
	}

	public static synchronized PropertiesLoader getInstance() {
		if (instance == null) {
			instance = new PropertiesLoader();
		}
		return instance;
	}

	public Properties load() {
		try {

			InputStream in = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(System.getProperty(Urls.USER_DIR) + Urls.CONFIG_PROPERTIES);
			if (in == null) {
				properties.load(new FileInputStream(System.getProperty(Urls.USER_DIR) + Urls.CONFIG_PROPERTIES));
			} else {
				properties.load(in);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (Properties) properties.clone();
	}

	public String getProperty(String prop) {
		String value = "";

		value = properties.getProperty(prop);
	
		return value;
	}

	public String getProperty(String prop, String vDefalult) {

		String value = "";

		value = properties.getProperty(prop, vDefalult);
	

		return value;

	}

	public Enumeration<?> getPropertyNames() {
		return properties.propertyNames();
	}

}
