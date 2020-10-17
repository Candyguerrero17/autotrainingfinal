package com.automation.training.utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.training.pages.booking.BookingHome;
import com.automation.training.pages.qa.QaProductPage;

public class BaseTests {

	protected MyDriver myDriver;
	private BookingHome bookingPage;
	private QaProductPage qaPage;
	protected BaseWebServices baseweb = new BaseWebServices();

	@BeforeSuite(alwaysRun = true)
	@Parameters({ "part" })
	public void beforeSuite(String part) {
		myDriver = new MyDriver();
		myDriver.startDriverConnection();
		switch (part) {
		case "1":
			bookingPage = new BookingHome(myDriver.getDriver());
			break;
		case "2":
			qaPage = new QaProductPage(myDriver.getDriver());
			break;
		default:
			break;
		}

	}
	@Parameters({ "part" })
	@AfterSuite(alwaysRun = true)
	public void afterSuite(String part) {		
		switch (part) {
		case "1":
			bookingPage.dispose();
			break;
		case "2":
			qaPage.dispose();
			break;
		default:
			break;
		}
	}

	public BookingHome getBookingHomePage() {
		return bookingPage;
	}

	public QaProductPage getQaProductPage() {
		return qaPage;
	}

}
