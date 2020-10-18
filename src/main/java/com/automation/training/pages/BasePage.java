package com.automation.training.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.training.utils.maps.UrlMaps;
import com.automation.training.utils.text.Intengers;
/**
 * Class base page
 * 
 * @author
 *
 */
public abstract class BasePage {

	protected WebDriver driver;
	protected Map<String, String> urlsEnviroment = UrlMaps.urlInit();
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
	 * Start WebDriverWait
	 * 
	 * @param driver
	 *            : WebDriver
	 * @return WebDriverWait
	 */
	public WebDriverWait driverWait() {
		WebDriverWait wait = new WebDriverWait(driver, Intengers.TWENTY);

		return wait;
	}

	public void waitForIframeLoad(WebElement element) {

		driverWait().until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element)));

	}

/**
 * Wait for freame and refresh of element
 * 
 * @param time
 *            : int
 * @param element
              : WebElement
 */
	public void waitForIframeLoadAndPostTimeout(WebElement element, int time) throws InterruptedException {

		driverWait().until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element)));
		Thread.sleep(time*1000);
	}
	/**
	 * Wait for visible and refresh of element
	 * 

	              : WebElement
	 */
	public void waitVisibleElement(WebElement element) {

		driverWait().until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * Wait for clickable and refresh of element

	 * @param element
	              : WebElement
	 */
	public void waitElementToBeClickable(WebElement element) {

		driverWait().until(ExpectedConditions.elementToBeClickable(element));

	}
	/**
	 * Wait for invisible and refresh of element

	 * @param element
	              : WebElement
	 */
	public void waitInvisibilityElement(WebElement element) {

		driverWait().until(ExpectedConditions.invisibilityOf(element));
	}
	/**
	 * Default content iframe


	 */
	public void leaveIframe() {

		getDriver().switchTo().defaultContent();
	}

}
