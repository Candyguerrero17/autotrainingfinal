package com.automation.training.pages.booking;

import static com.automation.training.utils.text.DataBooking.AGE_CHILDREN;
import static com.automation.training.utils.text.DataBooking.COUNTRY;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.pages.BasePage;

/**
 * Description:Page home of booking
 *
 */
public class BookingHome extends BasePage {

	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : WebDriver
	 */
	public BookingHome(WebDriver pDriver) {
		super(pDriver);

	}
	// WebElements

	@FindBy(css = "#ss")
	private WebElement searchDestination;

	@FindBy(css = "#xp__guests__toggle")
	private WebElement inputGuest;

	@FindBy(css = "[aria-label='Aumenta el número de Adultos']")
	private WebElement buttonAddAdultos;

	@FindBy(css = "[aria-label='Aumenta el número de Niños']")
	private WebElement buttonAddNinos;
	@FindBy(css = "[name='age'] ")
	private WebElement selectAgeofChildrens;
	@FindBy(css = "[class=\"sb-searchbox__button \"]")
	private WebElement buttonSearch;

	@FindBy(css = "[class='bui-calendar__wrapper'] div")
	private List<WebElement> nextMouth;
	@FindBy(css = "[data-bui-ref=\"calendar-next\"]")
	private WebElement next;
	@FindBy(css = "ul[role=\"listbox\"]>li:first-child")
	private WebElement firstCountry;

	/**
	 * Returns a HotelFoundPage after enter country, data and add "Adultos", "Ninos"
	 * 9 years old.
	 * 
	 * 
	 * @return HotelFoundPage
	 */
	public HotelFoundPage searchHotel() {

		customWait.waitVisbleElementWithRefreshsPage(getDriver(), searchDestination);
		typeAndEnter(searchDestination, firstCountry, COUNTRY);
		chooseData(getAllData(30), getMonth(30), nextMouth, next);
		chooseData(getAllData(44), getMonth(44), nextMouth, next);
		click(inputGuest);
		click(buttonAddAdultos);
		click(buttonAddNinos);
		selectOptionText(selectAgeofChildrens, AGE_CHILDREN);
		click(buttonSearch);
		return new HotelFoundPage(getDriver());

	}

}
