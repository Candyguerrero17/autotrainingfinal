package com.automation.training.utils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.automation.training.pages.BookingHome;

public class BaseTests{
	
	protected  MyDriver myDriver;
	
	private BookingHome bookingPage;
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {

		myDriver = new MyDriver(browser);
		bookingPage = new BookingHome(myDriver.getDriver());
		
	}

	
	@AfterTest(alwaysRun=true)
	public void afterSuite() {
		bookingPage.dispose();
	}

	public BookingHome getBookingHomePage() {
		return bookingPage;
	}
	
}
