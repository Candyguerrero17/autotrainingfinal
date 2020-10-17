package com.automation.training.utils;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {
	
	protected WebDriver driver;
	protected CustomWait customWait = new CustomWait();

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

	public void type(WebElement element, String text) {
		element.sendKeys(text);

	}

	public void typeAndEnter(WebElement element, String text) {
		element.sendKeys(text);
		customWait.waitInSeconds(1);
		element.sendKeys(Keys.DOWN);
		customWait.waitInSeconds(1);
		element.sendKeys(Keys.ENTER);

	}

	public void click(WebElement element) {
		element.click();

	}



	public void selectOptionText(WebElement element, String text) {

		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}

	public void selectOptionValue(WebElement element, String text) {

		Select dropdown = new Select(element);
		dropdown.selectByValue(text);
	}

	public void changeWindos() {
		ArrayList<String> openedWindows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(openedWindows.get(1));
		
	}

	public String getText(WebElement element) {

		return element.getText();
	}

	public void moveToElement(WebElement element) {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
}
