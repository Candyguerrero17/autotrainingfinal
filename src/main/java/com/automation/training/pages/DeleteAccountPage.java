package com.automation.training.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteAccountPage extends BasePage {

	public DeleteAccountPage(WebDriver pDriver) {
		super(pDriver);

	}

	@FindBy(css = "[class='section-divider section-cancel section-cancel-account'] #cancel-account")
	private WebElement linkDelete;

	@FindBy(css = "[id='disneyid-wrapper']")
	private WebElement styleActive;

	@FindBy(css = "[class='btn btn-primary ng-isolate-scope']")
	private WebElement buttonDelete;
	@FindBy(css = "h2[class='title title-primary ng-isolate-scope']")
	private WebElement pagetitleDeleteAcount;

	public void delete() {

		getWait().until(
				ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt("disneyid-iframe")));
	
	
		linkDelete.click();
		buttonDelete.click();
		getDriver().switchTo().defaultContent();

	}

	public String getPagetitleDeleteAcount() {
		getWait().until(ExpectedConditions.visibilityOf(pagetitleDeleteAcount));
		return pagetitleDeleteAcount.getText();
	}

}
