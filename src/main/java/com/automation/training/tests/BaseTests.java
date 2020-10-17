package com.automation.training.tests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.automation.training.pages.BookingHome;
import com.automation.training.utils.MyDriver;
import com.automation.training.utils.maps.DataTest;
import com.automation.training.utils.modals.DateModal;

public class BaseTests{
	
	protected  MyDriver myDriver;
	
	private BookingHome bookingPage;
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {

		myDriver = new MyDriver(browser);
		bookingPage = new BookingHome(myDriver.getDriver());
		
	}
	@BeforeSuite(alwaysRun=true)
	public DateModal loadDate() {
		DataTest modalD = new DataTest();
		DateModal date = modalD.init();
		return date;
	}
	
	
	@AfterTest(alwaysRun=true)
	public void afterSuite() {
		bookingPage.dispose();
	}

	public BookingHome getBookingHomePage() {
		return bookingPage;
	}
	
}
