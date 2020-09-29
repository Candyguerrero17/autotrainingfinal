package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.text.Intengers;

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

	public void delete() throws InterruptedException {

		waitForIframeLoadAndPostTimeout(frame,Intengers.THREE);
		waitVisibleElement(linkDelete);
		linkDelete.click();
		waitVisibleElement(buttonDelete);
		buttonDelete.click();

	}

	public String getPagetitleDeleteAccountFail() {
		waitVisibleElement(pagetitleDeleteAccountFail);

		return pagetitleDeleteAccountFail.getText();
	}

	public String getPagetitleDeleteAcount() {
		waitVisibleElement(pagetitleDeleteAccount);
		return pagetitleDeleteAccount.getText();
	}
}