package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAcountPage extends BasePage {

	public NewAcountPage(WebDriver pDriver) {
		super(pDriver);
	}

	@FindBy(name = "firstName")
	private WebElement textFirtName;

	@FindBy(name = "lastName")
	private WebElement textLastName;

	@FindBy(name = "email")
	private WebElement textEmail;

	@FindBy(name = "newPassword")
	private WebElement textNewPassword;

	@FindBy(css = "button[class='btn btn-primary ng-scope ng-isolate-scope']")
	private WebElement buttonSingUp;

	@FindBy(css = "[ng-repeat='item in parsedItems']")
	private WebElement itemTestFail;
	
	
	public void informationNewAcount(String name, String lastName, String email, String password) {
		waitVisibleElement(textFirtName);
		textFirtName.sendKeys(name);
		textLastName.sendKeys(lastName);
		textEmail.sendKeys(email);
		textNewPassword.sendKeys(password);
	
	}
	


	public HomePageEspn sendInformation() {
		buttonSingUp.click();
		leaveIframe();
		return new HomePageEspn(getDriver());

	}
	
	
	public String getPageTextFail() {
		waitVisibleElement(itemTestFail);
		return itemTestFail.getText();
	}
}
