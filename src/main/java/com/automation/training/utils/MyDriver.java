package com.automation.training.utils;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.training.utils.maps.UrlMaps;



public class MyDriver {

	private WebDriver driver;
	private static final String DRIVER = "DRIVER";
	private static final String URLBASE = "URLBASE";
	private static final String  FIREFOX= "firefox";
	private static final String CHORME = "chrome";
	Map<String, String> urlsEnviroment = UrlMaps.urlInit();
	public MyDriver(String browser) {
		switch (browser) {
		case FIREFOX:
			break;
		case CHORME:
			System.setProperty("webdriver.chrome.driver", urlsEnviroment.get(DRIVER));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(urlsEnviroment.get(URLBASE));
			break;
		default:
			break;
		}
	}

	public WebDriver getDriver() {
		return this.driver;
	}
}
