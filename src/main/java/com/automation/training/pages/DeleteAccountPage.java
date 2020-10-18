package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.text.Intengers;
/**
 * Description:Delete account
 *
 */
public class DeleteAccountPage extends BasePage {
	/**
	 * Constructor method.
	 * 
	 * 
	 * @param pDriver : Webdriver
	 */
	public DeleteAccountPage(WebDriver pDriver) {
		super(pDriver);

	}
	// WebElements
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
	/**
	 * Do click in link delete
	 * 
	 * 
	 */

	public void delete() throws InterruptedException {

		waitForIframeLoadAndPostTimeout(frame,Intengers.THREE);
		waitVisibleElement(linkDelete);
		linkDelete.click();
		waitVisibleElement(buttonDelete);
		buttonDelete.click();

	}
	/**
	 *Return text
	 * 
	 *@return
	 */
	public String getPagetitleDeleteAccountFail() {
		waitVisibleElement(pagetitleDeleteAccountFail);

		return pagetitleDeleteAccountFail.getText();
	}
	/**
	 *Return text
	 * 
	 *@return
	 */
	public String getPagetitleDeleteAcount() {
		waitVisibleElement(pagetitleDeleteAccount);
		return pagetitleDeleteAccount.getText();
	}
}