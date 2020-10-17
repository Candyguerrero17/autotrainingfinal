package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WriteData extends BasePage {

	public WriteData(WebDriver pDriver) {
		super(pDriver);
	}

	@FindBy(css = "#firstname")
	private WebElement firstName;

	@FindBy(css = "#lastname")
	private WebElement lastName;
	@FindBy(css = "#email")
	private WebElement email;
	@FindBy(css = "#email_confirm")
	private WebElement emailConfirm;
	
	
	@FindBy(css = "[data-popover-content-id='bp-submit-popover']")
	private WebElement buttonSiguiente;
	
	public LastStepsPage addDate() {
		customWait.waitVisibleElement(getDriver(), buttonSiguiente);
		type(firstName, "Candy");
		type(lastName, "Guerrero");
		type(email, "candygueme.cg@gmail.com");
		type(emailConfirm, "candygueme.cg@gmail.com");
		click(buttonSiguiente);
		return new LastStepsPage(getDriver());
	}
	
}
