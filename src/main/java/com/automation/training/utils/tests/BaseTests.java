package com.automation.training.utils.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.training.pages.booking.BookingHome;
import com.automation.training.pages.qa.QaProductPage;
import com.automation.training.utils.others.MyDriver;
import com.automation.training.utils.pages.BaseWebServices;

public class BaseTests {

	protected MyDriver myDriver;
	private BookingHome bookingPage;
	private QaProductPage qaPage;
	protected BaseWebServices baseweb = new BaseWebServices();

	/**
	 * Before of suite start driver and send.
	 * 
	 * @param part : String
	 */
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

	/**
	 * After of suite closet driver.
	 * 
	 * @param part : String
	 */
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

	/**
	 * Return a bookingPage
	 * 
	 * @return BookingHome : String
	 */
	public BookingHome getBookingHomePage() {
		return bookingPage;
	}

	/**
	 * Return a qaPage
	 * 
	 * @return QaProductPage : String
	 */
	public QaProductPage getQaProductPage() {
		return qaPage;
	}

}
