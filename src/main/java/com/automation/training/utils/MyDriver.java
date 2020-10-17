package com.automation.training.utils;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.training.utils.maps.UrlMaps;



public class MyDriver {

	private WebDriver driver;
	private static final String DRIVER = "DRIVER";
	Map<String, String> urlsEnviroment = UrlMaps.urlInit();


	public void startDriverConnection() {
		System.setProperty("webdriver.chrome.driver", urlsEnviroment.get(DRIVER));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
}
