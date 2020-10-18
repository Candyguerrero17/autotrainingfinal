package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Description:New account
 *
 */
public class NewAcountPage extends BasePage {
	/**
	 * Constructor method.
	 * 
	 * 
	 * @param pDriver : Webdriver
	 */
	public NewAcountPage(WebDriver pDriver) {
		super(pDriver);
	}
	// WebElements
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
	/**
	 * Enter information of new account
	 * 
	 *
	 * * @param name : String
	 * * @param lastName : String
	 * * @param email : String
	 * * @param password : String
	 * 
	 */
	
	public void informationNewAcount(String name, String lastName, String email, String password) {
		waitVisibleElement(textFirtName);
		textFirtName.sendKeys(name);
		textLastName.sendKeys(lastName);
		textEmail.sendKeys(email);
		textNewPassword.sendKeys(password);
	
	}
	/**
	 *Return a HomePageEspn after do clik in Sing up
	 * 
	 *@return HomePageEspn
	 */


	public HomePageEspn sendInformation() {
		buttonSingUp.click();
		leaveIframe();
		return new HomePageEspn(getDriver());

	}
	
	/**
	 *Return text
	 * 
	 *@return text
	 */
	public String getPageTextFail() {
		waitVisibleElement(itemTestFail);
		return itemTestFail.getText();
	}
}
