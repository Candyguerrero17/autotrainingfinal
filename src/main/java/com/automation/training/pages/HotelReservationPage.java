package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.modals.RervationModel;

public class HotelReservationPage extends BasePage {
	RervationModel reservation;
	public HotelReservationPage(WebDriver pDriver) {
		super(pDriver);

	}

	public static final String TABLE_RESERVATION = "[class='totalPrice\'] ";
	@FindBy(css = "h3.top_pick_heading")
	private WebElement nameHotel;

	@FindBy(css = TABLE_RESERVATION + "[class='bui-price-display__label ']")
	private WebElement descriptionReservation;

	@FindBy(css = TABLE_RESERVATION + "[class='bui-price-display__value prco-inline-block-maker-helper']")
	private WebElement priceReservation;
	@FindBy(css = "table#hprt-table>tbody>tr:nth-child(1)>td:nth-child(5)>div>select")
	private WebElement selectRoom;

	@FindBy(css = "#group_recommendation")
	private WebElement continer;
	
	@FindBy(css = "button#hp_book_now_button")
	private WebElement button;
	
	@FindBy(css = "div[class='hprt-reservation-cta'] button")
	private WebElement buttonReservation;
	
	public WriteData yourRoom() {
		selectOptionValue(selectRoom, "1");
		click(buttonReservation);
		return new WriteData(getDriver());
	}

	public boolean isVisibleameHotel(String value) {
		changeWindos();
		customWait.waitVisibleElement(getDriver(), descriptionReservation);
		moveToElement(continer);	
		return getText(nameHotel).contains(value);
	}

	public boolean isVisibleDescription() {
		
		return getText(descriptionReservation).equals("14 noches, 3 adultos, 1 niño");
	}

	public boolean isVisiblePrice(String value) {
		
		return getText(priceReservation).equals(value);
	}
}
