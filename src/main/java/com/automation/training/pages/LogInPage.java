package com.automation.training.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {

	public LogInPage(WebDriver pDriver) {
		super(pDriver);

	}
		
	@FindBy(css = "a[class='btn btn-secondary ng-isolate-scope']")
	private WebElement buttonSingUp;
                 
	@FindBy(css = "[ng-model='vm.username']")
	private WebElement textUser;

	@FindBy(css = " [class='ng-pristine ng-untouched ng-invalid ng-invalid-required']")
	private WebElement textPassword;

	@FindBy(css = "[class='btn btn-primary btn-submit ng-isolate-scope']")
	private WebElement buttonLogIn;
	@FindBy(css = "[ng-repeat='item in parsedItems']")
	private WebElement textFailLogIn;
	@FindBy(css = "[name='disneyid-iframe']")
	private WebElement frame;
	public NewAcountPage openRegister() {
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame)));
		getWait().until(ExpectedConditions.elementToBeClickable(buttonSingUp));
		buttonSingUp.click();
		return new NewAcountPage(getDriver());
	}

	public HomePageEspn starSession(String user, String password) {
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame)));
		getWait().until(ExpectedConditions.visibilityOf(textUser));
		textUser.sendKeys(user);
		textPassword.sendKeys(password);
		buttonLogIn.click();
		getDriver().switchTo().defaultContent();
		return new HomePageEspn(getDriver());
	}
	
	public DeleteAccountPage  starSessionFail(String user, String password) {
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame)));
		getWait().until(ExpectedConditions.visibilityOf(textUser));
		textUser.sendKeys(user);
		textPassword.sendKeys(password);
		buttonLogIn.click();
		return new DeleteAccountPage(getDriver());
		
	}

	public String getPageTitleFailLogIn() {
		getWait().until(ExpectedConditions.visibilityOf(textFailLogIn));
		return textFailLogIn.getText();
	}

	

}
