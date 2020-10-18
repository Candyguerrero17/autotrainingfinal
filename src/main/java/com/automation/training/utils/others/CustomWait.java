package com.automation.training.utils.others;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Class to manage the synchronization of elements with waits.
 * 
 */
public class CustomWait {
	// time in seconds for waits methods.
	public final long MEDIUM_WAIT_SECONDS = 40;

	/**
	 * Start WebDriverWait
	 * 
	 * @param driver
	 *            : WebDriver
	 * @return WebDriverWait
	 */
	public WebDriverWait getWait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, MEDIUM_WAIT_SECONDS);
		return wait;
	}
	/**
     * Wait for visibility and refresh of element
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param element
	              : WebElement
	 */
	public void waitVisbleElementWithRefreshsPage(WebDriver driver, WebElement element) {
		getWait(driver).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));

	}
	/**
     * Wait for visibility of element
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param element
	              : WebElement
	 */
	public void waitVisibleElement(WebDriver driver, WebElement element) {

		getWait(driver).until(ExpectedConditions.visibilityOf(element));
	}

	/**
     * Wait for element to be clickable
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param element
	              : WebElement
	 */
	public void waitElementToBeClickable(WebDriver driver, WebElement element) {

		getWait(driver).until(ExpectedConditions.elementToBeClickable(element));

	}
	/**
     * Wait for invisibility of element
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param element
	              : WebElement
	 */
	
	public void waitInvisibilityElement(WebDriver driver, WebElement element) {

		getWait(driver).until(ExpectedConditions.invisibilityOf(element));
	}

}
