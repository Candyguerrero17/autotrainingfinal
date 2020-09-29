package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageEspn extends BasePage {

	public HomePageEspn(WebDriver pDriver) {
		super(pDriver);

	}

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

	public void openProfileAgain(WebElement element) {
		waitInvisibilityElement(element);
		buttonIconUser.click();

	}

	public void openProfile() {
		waitElementToBeClickable(buttonIconUser);
		buttonIconUser.click();
	}

	public LogInPage openLogIn() {
		linkLogIn.click();
		return new LogInPage(getDriver());
	}

	public String getPageTitleProfile() {
		openProfileAgain(linkLogOut);

		return pageTitleProfile.getText();
	}

	public void closeSession() {
		openProfileAgain(linkLogOut);
		linkLogOut.click();
	}

	public DeleteAccountPage delete() {
		openProfileAgain(linkLogOut);
		linkProfiles.click();

		return new DeleteAccountPage(getDriver());
	}

	public String getPageTitleCloseSession() {
		openProfileAgain(linkLogIn);
		return pageTitleClosetSession.getText();
	}


}
