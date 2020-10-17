package com.automation.training.pages.booking;

import static com.automation.training.utils.text.TextData.AGE_CHILDREN;
import static com.automation.training.utils.text.TextData.COUNTRY;
import static com.automation.training.utils.text.TextData.FORMAT_DATA;
import static com.automation.training.utils.text.TextData.ZONE_ID;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.BasePage;
import com.automation.training.utils.maps.UrlMaps;

/**
 * Description:Page home of booking
 *
 */
public class BookingHome extends BasePage {
	Map<String, String> urlsEnviroment = UrlMaps.urlInit();
	private static final String URLBASE = "URLBASE";
	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : WebDriver
	 */
	public BookingHome(WebDriver pDriver) {
		super(pDriver);
		pDriver.get(urlsEnviroment.get(URLBASE));

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
	 * Returns a HotelFoundPage after enter country, data and add "Adultos", "Ninos" 9 years old.
	 * 
	 * 
	 * @return HotelFoundPage
	 */
	public HotelFoundPage searchHotel() {

		customWait.waitVisbleElementWithRefreshsPage(getDriver(), searchDestination);
		typeAndEnter(searchDestination,firstCountry, COUNTRY);
		chooseData(getAllData(30), getMonth(30));
		chooseData(getAllData(44), getMonth(44));
		click(inputGuest);
		click(buttonAddAdultos);
		click(buttonAddNinos);
		selectOptionText(selectAgeofChildrens, AGE_CHILDREN);
		click(buttonSearch);
		return new HotelFoundPage(getDriver());

	}


	public void chooseData(String data, String mounth) {

		for (int i = 0; i < 2; i++) {
			if (nextMouth.get(i).getText().contains(mounth)) {
				click(buildElement(data));
			} else if (i == 1) {
				click(next);
				i--;
			}
		}

	}

	public String getMonth(int days) {
		Month data = LocalDate.now(ZoneId.of(ZONE_ID)).plusDays(days).getMonth();
		String month = data.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		return month;
	}

	public String getAllData(int days) {
		LocalDate data = LocalDate.now(ZoneId.of(ZONE_ID)).plusDays(days);
		String formData = data.format(DateTimeFormatter.ofPattern(FORMAT_DATA));
		return formData;
	}

	public WebElement buildElement(String value) {
		WebElement element = getDriver().findElement(By.cssSelector("[data-date='" + value + "']"));
		return element;
	}

}
