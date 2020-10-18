package com.automation.training.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Description:Log in
 *
 */
public class LogInPage extends BasePage {
	/**
	 * Constructor method.
	 * 
	 * 
	 * @param pDriver : Webdriver
	 */
	public LogInPage(WebDriver pDriver) {
		super(pDriver);

	}
	// WebElements
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
	/**
	 *Return a NewAcountPage after do clik in Sing up
	 * 
	 *@return NewAcountPage
	 */
	public NewAcountPage openRegister() {
		
		waitForIframeLoad(frame);
		waitElementToBeClickable(buttonSingUp);
		buttonSingUp.click();
		return new NewAcountPage(getDriver());
	}
	/**
	 *Return a HomePageEspn after do enter user an password
	 * 
	 *@return HomePageEspn
	 */
	public HomePageEspn starSession(String user, String password) {
		infoProfile(user,password);
		leaveIframe();
		return new HomePageEspn(getDriver());
	}
	/**
	 *Return a DeleteAccountPage after do enter user an password
	 * 
	 *@return DeleteAccountPage
	 */
	public DeleteAccountPage  starSessionFail(String user, String password) {
		infoProfile(user,password);
		return new DeleteAccountPage(getDriver());
		
	}
	/**
	 *Return text
	 * 
	 *@return text
	 */
	public String getPageTitleFailLogIn() {
		
		waitVisibleElement(textFailLogIn);
		return textFailLogIn.getText();
	}
	/**
	 *Enter user and password
	 * 
	 */
	
	public void infoProfile(String user, String password) {
		waitForIframeLoad(frame);
		waitVisibleElement(textUser);
		textUser.sendKeys(user);
		textPassword.sendKeys(password);
		buttonLogIn.click();
	}

}
