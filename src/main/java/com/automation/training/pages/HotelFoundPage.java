package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.automation.training.utils.modals.RervationModel;

public class HotelFoundPage extends BasePage {
	RervationModel reservation = new RervationModel();

	public HotelFoundPage(WebDriver pDriver) {
		super(pDriver);

	}

	private static final String SECOND_BANNER = "div#hotellist_inner>div:nth-child(3) ";
	private static final String SECOND_BANNER_OPT = "div#hotellist_inner>div:nth-child(2) ";
	@FindBy(css = "[data-component='sr_alternative_dates'] button")
	private WebElement banner;
	@FindBy(css = "[class='sr_header '] h1")
	private WebElement titlePage;

	@FindBy(css = "a[data-id='class-5']")
	private WebElement filterFiveStarts;

	@FindBys({ @FindBy(css = SECOND_BANNER + "[class='js-sr-hotel-link hotel_name_link url'] span:nth-child(1)"),
			@FindBy(css = SECOND_BANNER_OPT + "[class='js-sr-hotel-link hotel_name_link url'] span:nth-child(1)") })
	private WebElement nameHotel;

	@FindBy(css = SECOND_BANNER + "[class='bui-review-score__badge']")
	private WebElement scoreHotel;

	@FindBy(css = SECOND_BANNER + "[class='bui-price-display__value prco-inline-block-maker-helper']")
	private WebElement priceHotel;
	@FindBy(css = SECOND_BANNER + "[class='txp-cta bui-button bui-button--primary sr_cta_button']")
	private WebElement buttonEligeHabitacion;

	public void filter() {

		customWait.waitVisibleElement(getDriver(), titlePage);
		click(filterFiveStarts);

	}

	public RervationModel setData() {
		reservation.setNameHotel(nameHotel.getText());
		reservation.setPriceHotel(priceHotel.getText());
		return reservation;
	}

	public HotelReservationPage doReservation() {
		click(buttonEligeHabitacion);
		return new HotelReservationPage(getDriver());

	}

	public void bannerPresente() {
		customWait.waitVisibleElement(getDriver(), banner);
		if (banner.isEnabled()) {
			customWait.waitInSeconds(2);
			click(banner);
		}

	}

	public boolean isVisibleNameHotel() {
		bannerPresente();
		customWait.waitVisibleElement(getDriver(), nameHotel);
		return nameHotel.isDisplayed();
	}

	public boolean isVisibleScore() {

		return scoreHotel.isDisplayed();

	}

	public boolean isVisiblePrice() {

		return priceHotel.isDisplayed();
	}

	public String returnPriceHotel() {

		return priceHotel.getText();
	}

	public String returnNameHotel() {

		return nameHotel.getText();
	}

}
