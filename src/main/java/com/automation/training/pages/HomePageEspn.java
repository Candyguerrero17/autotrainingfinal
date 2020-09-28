package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

	
	

	public void openProfileStartSession() {
	
			getWait().until(ExpectedConditions.invisibilityOf(linkLogOut));
			buttonIconUser.click();	
		
		
	}
	
	public void openProfile() {
		getWait().until(ExpectedConditions.elementToBeClickable(buttonIconUser));
		buttonIconUser.click();
	}
	
	public void closeProfile() {
		getWait().until(ExpectedConditions.invisibilityOf(linkLogIn));
		buttonIconUser.click();
	}

	public LogInPage openLogIn() {
		linkLogIn.click();
		return new LogInPage(getDriver());
	}

	public String getPageTitleProfile() {
		openProfileStartSession();
		return pageTitleProfile.getText();
	}

	public void closeSession() {
		openProfileStartSession();
		linkLogOut.click();
	}

	public DeleteAccountPage delete() {
		openProfileStartSession();
		linkProfiles.click();

		return new DeleteAccountPage(getDriver());
	}

	public String getPageTitleCloseSession() {

		closeProfile();
		return pageTitleClosetSession.getText();
	}
	public void justCloseSession() {
		linkLogOut.click();
	}
}
