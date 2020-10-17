package com.automation.training.pages.booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.BasePage;

import static com.automation.training.utils.text.Messages.DESCRIPTION_OF_RESERVER;

import static com.automation.training.utils.text.TextData.NUMBER_ROOM;
/**
 * Description:Hotel reservation 
 *
 */
public class HotelReservationPage extends BasePage {
	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : WebDriver
	 */
	public HotelReservationPage(WebDriver pDriver) {
		super(pDriver);

	}

	public static final String TABLE_RESERVATION = "[class='totalPrice'] ";
	
	// WebElements
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
	
	/**
	 * Select number of rooms and do click in reservtion
	 * 
	 * 
	 */

	public WriteData yourRoom() {
		selectOptionValue(selectRoom,NUMBER_ROOM);
		click(buttonReservation);
		return new WriteData(getDriver());
	}
	/**
	 * 
	 * @return true if the hotel name contain same name of before page "HotelFoundPage"
	 * @param value : String
	 */
	public boolean isVisibleameHotel(String value) {
		changeWindos();
		customWait.waitVisibleElement(getDriver(), descriptionReservation);
		moveToElement(continer);	
		return getText(nameHotel).contains(value);
	}
	/**
	 * 
	 * @return true if description of reserve is equals.

	 */
	public boolean isVisibleDescription() {
		
		return getText(descriptionReservation).equals(DESCRIPTION_OF_RESERVER);
	}
	/**
	 * 
	 * @return true if the hotel price contain same price of before page "HotelFoundPage"
	 * 
	 *  @param value : String
	 */
	public boolean isVisiblePrice(String value) {
		
		return getText(priceReservation).equals(value);
	}
}
