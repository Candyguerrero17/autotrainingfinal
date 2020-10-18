package com.automation.training.tests;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.automation.training.pages.HomePageEspn;
import com.automation.training.utils.MyDriver;
import com.automation.training.utils.maps.DataTest;
import com.automation.training.utils.modals.DateModal;

public class BaseTests {
	
	protected  MyDriver myDriver;
	protected static final String URLBASE = "URLBASE";
	private HomePageEspn espnPage;
	
	@BeforeTest(alwaysRun=true)
	public void beforeSuite() {
		myDriver = new MyDriver();
		myDriver.startDriverConnection();
		espnPage = new HomePageEspn(myDriver.getDriver());
	}
	@BeforeSuite(alwaysRun=true)
	public DateModal loadDate() {
		DataTest modalD = new DataTest();
		DateModal date = modalD.init();
		return date;
	}
	
	
	@AfterTest(alwaysRun=true)
	public void afterSuite() {
		espnPage.dispose();
	}

	public HomePageEspn getEspnHomePage() {
		return espnPage;
	}
	
}
