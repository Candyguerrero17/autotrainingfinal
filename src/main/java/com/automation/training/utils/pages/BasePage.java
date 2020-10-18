package com.automation.training.utils.pages;

import static com.automation.training.utils.text.DataBooking.FORMAT_DATA;
import static com.automation.training.utils.text.DataBooking.ZONE_ID;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.training.utils.maps.UrlMaps;
import com.automation.training.utils.others.CustomWait;

/**
 * Class base page
 * 
 * @author
 *
 */
public abstract class BasePage {

	protected WebDriver driver;
	protected CustomWait customWait = new CustomWait();
	protected Map<String, String> urlsEnviroment = UrlMaps.urlInit();

	private static final int NUM_WINDOWS = 1;
	private static final String ATTRIBUTE = "value";

	/**
	 * Constructor method.
	 * 
	 * 
	 * @param pDriver : WebDriver
	 */
	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		driver = pDriver;
	}

	/**
	 * Get url to open browser
	 * 
	 * @param url : String
	 */
	public void openBrowser(String url) {
		driver.get(urlsEnviroment.get(url));
	}

	/**
	 * Get driver
	 * 
	 * @return driver
	 */
	protected WebDriver getDriver() {
		return driver;
	}

	/**
	 * Quit driver
	 * 
	 */
	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Senkeys to element
	 * 
	 * @param element : WebElement
	 * @param text    : String
	 */
	public void type(WebElement element, String text) {
		element.sendKeys(text);
	}

	/**
	 * Sendkeys and do enter.
	 * 
	 * @param element     : WebElement
	 * @param elementWait : WebElement
	 * @param text        : String
	 */
	public void typeAndEnter(WebElement element, WebElement elementWait, String text) {
		element.sendKeys(text);
		customWait.waitVisibleElement(driver, elementWait);
		element.sendKeys(Keys.DOWN);
		element.sendKeys(Keys.ENTER);

	}

	/**
	 * Do click.
	 * 
	 * @param element : WebElement
	 */
	public void click(WebElement element) {
		element.click();

	}

	/**
	 * Select option of list to element
	 * 
	 * @param element : WebElement
	 * @param text    : String
	 */
	public void selectOptionText(WebElement element, String text) {

		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}

	/**
	 * Select value of list to element
	 * 
	 * @param element : WebElement
	 * @param text    : String
	 */
	public void selectOptionValue(WebElement element, String text) {

		Select dropdown = new Select(element);
		dropdown.selectByValue(text);
	}

	/**
	 * Change of window.
	 * 
	 */
	public void changeWindos() {
		ArrayList<String> openedWindows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(openedWindows.get(NUM_WINDOWS));

	}

	/**
	 * Get of text to element
	 * 
	 * @param element : WebElement
	 */
	public String getText(WebElement element) {

		return element.getText();
	}

	/**
	 * Get Attribute to element
	 * 
	 * @param element : WebElement
	 */

	public String getAttribute(WebElement element) {

		return element.getAttribute(ATTRIBUTE);
	}

	/**
	 * Move until element
	 * 
	 * @param element : WebElement
	 */
	public void moveToElement(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	/**
	 * Method to do click in data.
	 * 
	 * 
	 * @param data        : String
	 * @param mounth      : String
	 * @param elementList : List<WebElement>
	 * @param element     : WebElement
	 */
	public void chooseData(String data, String mounth, List<WebElement> elementList, WebElement element) {

		for (int i = 0; i < 2; i++) {
			if (elementList.get(i).getText().contains(mounth)) {
				click(buildElement(data));
			} else if (i == 1) {
				click(element);
				i--;
			}
		}

	}

	/**
	 * Method for get mounth now
	 * 
	 * 
	 * @param days : int
	 * @return String
	 */
	public String getMonth(int days) {
		Month data = LocalDate.now(ZoneId.of(ZONE_ID)).plusDays(days).getMonth();
		String month = data.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		return month;
	}

	/**
	 * Method for get data with format.
	 * 
	 * 
	 * @param days : int
	 * @return String
	 */
	public String getAllData(int days) {
		LocalDate data = LocalDate.now(ZoneId.of(ZONE_ID)).plusDays(days);
		String formData = data.format(DateTimeFormatter.ofPattern(FORMAT_DATA));
		return formData;
	}

	/**
	 * Method for get element.
	 * 
	 * 
	 * @param value : String
	 * @return String
	 */
	public WebElement buildElement(String value) {
		WebElement element = getDriver().findElement(By.cssSelector("[data-date='" + value + "']"));
		return element;
	}
}
