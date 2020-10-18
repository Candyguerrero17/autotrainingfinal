package com.automation.training.pages.booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.modals.RervationModel;
import com.automation.training.utils.pages.BasePage;

/**
 * Description:Hotel found to select second option
 *
 */
public class HotelFoundPage extends BasePage {
	RervationModel reservation = new RervationModel();
	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : WebDriver
	 */
	public HotelFoundPage(WebDriver pDriver) {
		super(pDriver);

	}


	private static final String SECOND_BANNER = "div#hotellist_inner>div:nth-child(3) ";

	// WebElements
	@FindBy(css = "[data-component='sr_alternative_dates'] button")
	private WebElement banner;
	@FindBy(css = "[class='sr_header '] h1")
	private WebElement titlePage;
	@FindBy(css = "a[data-id='class-5']")
	private WebElement filterFiveStars;
	@FindBy(css = SECOND_BANNER + "[class='js-sr-hotel-link hotel_name_link url'] span:nth-child(1)")
	private WebElement nameHotel;
	@FindBy(css = SECOND_BANNER + "[class='bui-review-score__badge']")
	private WebElement scoreHotel;
	@FindBy(css = SECOND_BANNER + "[class='bui-price-display__value prco-inline-block-maker-helper']")
	private WebElement priceHotel;
	@FindBy(css = SECOND_BANNER + "[class='txp-cta bui-button bui-button--primary sr_cta_button']")
	private WebElement buttonEligeHabitacion;

	/**
	 * Select option 5 stars
	 */
	public void filter() {

		customWait.waitVisibleElement(getDriver(), titlePage);
		click(filterFiveStars);

	}

	/**
	 * Returns the values hotel name and price
	 * 
	 * 
	 * @return reservation
	 */

	public RervationModel setData() {
		reservation.setNameHotel(nameHotel.getText());
		reservation.setPriceHotel(priceHotel.getText());
		return reservation;
	}

	/**
	 * Returns a HotelReservationPage after do click in button Elige Habitacion
	 * 
	 * 
	 * @return HotelReservationPage
	 */
	public HotelReservationPage doReservation() {
		click(buttonEligeHabitacion);
		return new HotelReservationPage(getDriver());

	}

	/**
	 * Do click if banner is enable
	 * 
	 * 
	 */
	public void bannerPresente() {
		customWait.waitVisibleElement(getDriver(), banner);
		if (banner.isEnabled()) {
			click(banner);
			customWait.waitInvisibilityElement(getDriver(), banner);
		}

	}

	/**
	 * Returns true if hotel name is enable
	 * 
	 * 
	 * @return true
	 */
	public boolean isVisibleNameHotel() {
		bannerPresente();
		customWait.waitVisibleElement(getDriver(), nameHotel);
		return nameHotel.isEnabled();
	}

	/**
	 * Returns true if hotel score is enable
	 * 
	 * 
	 * @return true
	 */
	public boolean isVisibleScore() {

		return scoreHotel.isEnabled();

	}

	/**
	 * Returns true if hotel price is enable
	 * 
	 * 
	 * @return true
	 */
	public boolean isVisiblePrice() {

		return priceHotel.isEnabled();
	}

	/**
	 * Returns string wiht hotel price
	 * 
	 * 
	 * @return String
	 */

	public String returnPriceHotel() {

		return priceHotel.getText();
	}

	/**
	 * Returns string wiht hotel name
	 * 
	 * 
	 * @return String
	 */

	public String returnNameHotel() {

		return nameHotel.getText();
	}

}
