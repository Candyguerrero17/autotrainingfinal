package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Description:Delete account
 *
 */
public class HomePageEspn extends BasePage {
	/**
	 * Constructor method.
	 * 
	 * 
	 * @param pDriver : Webdriver
	 */
	public HomePageEspn(WebDriver pDriver) {
		super(pDriver);

	}

	// WebElements
	@FindBy(css = "#global-user-trigger")
	private WebElement buttonIconUser;

	@FindBy(css = ".user a[tref='/members/v3_1/login']")
	private WebElement linkLogIn;

	@FindBy(css = ".user .display-user span")
	private WebElement pageTitleProfile;

	@FindBy(css = ".display-user")
	private WebElement pageTitleClosetSession;

	@FindBy(css = "#global-header .small")
	private WebElement linkLogOut;

	@FindBy(css = ".user [tref='/members/v3_1/modifyAccount']")
	private WebElement linkProfiles;

	/**
	 * Do click icon user and wait for elemen is invisible
	 * 
	 * 
	 */
	public void openProfileAgain(WebElement element) {
		waitInvisibilityElement(element);
		buttonIconUser.click();

	}

	/**
	 * Do click icon user and wait for elemen is clickable
	 * 
	 * 
	 */
	public void openProfile() {
		waitElementToBeClickable(buttonIconUser);
		buttonIconUser.click();
	}

	/**
	 * Return a LogInPage after do click in log in
	 * 
	 * @return LogInPage
	 */
	public LogInPage openLogIn() {
		linkLogIn.click();
		return new LogInPage(getDriver());
	}

	/**
	 * Return a pageTitleProfile after do click in log out
	 * 
	 * @return pageTitleProfile
	 */
	public String getPageTitleProfile() {
		openProfileAgain(linkLogOut);
		return pageTitleProfile.getText();
	}
	/**
	 * Do click in log out
	 * 
	 * 
	 */
	public void closeSession() {
		openProfileAgain(linkLogOut);
		linkLogOut.click();
	}
	/**
	 * Return a DeleteAccountPage after do click in log out
	 * 
	 * @return DeleteAccountPage
	 */
	public DeleteAccountPage delete() {
		openProfileAgain(linkLogOut);
		linkProfiles.click();
		return new DeleteAccountPage(getDriver());
	}
	/**
	 * Return a pageTitleClosetSession after do click in log in
	 * 
	 * @return pageTitleClosetSession
	 */
	public String getPageTitleCloseSession() {
		openProfileAgain(linkLogIn);
		return pageTitleClosetSession.getText();
	}

}
