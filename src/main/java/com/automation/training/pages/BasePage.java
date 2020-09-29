package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.training.utils.text.Intengers;

public abstract class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		driver = pDriver;
	}

	protected WebDriver getDriver() {
		return driver;
	}

	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriverWait driverWait() {
		WebDriverWait wait = new WebDriverWait(driver, Intengers.TWENTY);

		return wait;
	}

	public void waitForIframeLoad(WebElement element) {

		driverWait().until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element)));

	}

	public void waitForIframeLoadAndPostTimeout(WebElement element, int time) throws InterruptedException {

		driverWait().until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element)));
		Thread.sleep(time*1000);
	}

	public void waitVisibleElement(WebElement element) {

		driverWait().until(ExpectedConditions.visibilityOf(element));
	}

	public void waitElementToBeClickable(WebElement element) {

		driverWait().until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitInvisibilityElement(WebElement element) {

		driverWait().until(ExpectedConditions.invisibilityOf(element));
	}

	public void leaveIframe() {

		getDriver().switchTo().defaultContent();
	}

}
