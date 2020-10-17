package com.automation.training.pages;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Description:Screen to accept cookies
 *
 */
import org.openqa.selenium.support.FindBy;

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

	@FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[3]/td[6]/span/span")
	private WebElement dateCheckIn;
	@FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[5]/td[6]")
	private WebElement dateCheckOut;
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

	public HotelFoundPage searchHotel() {

		customWait.waitVisbleElementWithRefreshsPage(getDriver(), searchDestination);
		typeAndEnter(searchDestination, "Bogotá");
		data();
		click(inputGuest);
		click(buttonAddAdultos);
		click(buttonAddNinos);
		selectOptionText(selectAgeofChildrens, "9 años");
		click(buttonSearch);
		return new HotelFoundPage(getDriver());

	}

	public void data() {

		LocalDate checkin = LocalDate.now(ZoneId.of("America/Mexico_City")).plusDays(30);
		LocalDate checkout2 = LocalDate.now(ZoneId.of("America/Mexico_City")).plusDays(44);
		Month checkout = LocalDate.now(ZoneId.of("America/Bogota")).plusDays(50).getMonth();
		String amountCheckIn = checkin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String amountCheckOut = checkout.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		String amountCheckfinal = checkout2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		click(buildElement(amountCheckIn));
		for (int i = 0; i < 2; i++) {

			if (nextMouth.get(i).getText().contains(amountCheckOut)) {
				click(buildElement(amountCheckfinal));
			} else if (i == 1) {
				click(next);
				i--;
			}
		}

	}

	public WebElement buildElement(String value) {
		WebElement element = getDriver().findElement(By.cssSelector("[data-date='" + value + "']"));

		return element;
	}

}
