package com.automation.training.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pmw.tinylog.Logger;

public class CustomWait {
	public final long MIN_WAIT_SECONDS = 1;
	public final long SHORT_WAIT_SECONDS = 5;
	public final long NORMAL_WAIT_SECONDS = 15;
	public final long MEDIUM_WAIT_SECONDS = 40;
	public final long LARGE_WAIT_SECONDS = 60;

	private static final int SECONDS_CONVERSION = 1000;




	public WebDriverWait getWait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		return wait;
	}

	

	public void waitVisbleElementWithRefreshsPage(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));

	}
	

	public void waitVisbleFrame(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element)));

	}

	public void waitVisibleElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitInvisibilityElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitInSeconds(int seconds) {
		try {
			Thread.sleep(seconds * SECONDS_CONVERSION);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
			Logger.error(ex.getMessage(), ex);
		}
	}
}
