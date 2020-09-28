package com.automation.training.pages;

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

	@FindBy(css = "button[did-translate='deactivate.confirmation.buttons.confirm']")
	private WebElement buttonDelete;
	@FindBy(css = "h2[class='title title-primary ng-isolate-scope']")
	private WebElement pagetitleDeleteAccountFail;

	@FindBy(css = "h2[did-translate='deactivate.successful.messages.header']")
	private WebElement pagetitleDeleteAccount;

	@FindBy(css = "[name='disneyid-iframe']")
	private WebElement frame;

	public void delete() {

		try {
			getWait().until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame)));
			Thread.sleep(2000);
			linkDelete.click();
			getWait().until(ExpectedConditions.visibilityOf(buttonDelete));
			buttonDelete.click();

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public String getPagetitleDeleteAccountFail() {
		getWait().until(ExpectedConditions.visibilityOf(pagetitleDeleteAccountFail));
		return pagetitleDeleteAccountFail.getText();
	}

	public String getPagetitleDeleteAcount() {
		getWait().until(ExpectedConditions.visibilityOf(pagetitleDeleteAccount));
		return pagetitleDeleteAccount.getText();
	}
}