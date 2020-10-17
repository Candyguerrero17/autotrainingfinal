package com.automation.training.pages.booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.BasePage;
import static com.automation.training.utils.text.TextData.FIRST_NAME;
import static com.automation.training.utils.text.TextData.LAST_NAME;
import static com.automation.training.utils.text.TextData.EMAIL;

/**
 * Description: Write data to finish process.
 *
 */

public class WriteData extends BasePage {
	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : WebDriver
	 */
	public WriteData(WebDriver pDriver) {
		super(pDriver);
	}
	// WebElements
	@FindBy(css = "#firstname")
	private WebElement firstName;

	@FindBy(css = "#lastname")
	private WebElement lastName;
	
	@FindBy(css = "#email")
	private WebElement email;
	
	@FindBy(css = "#email_confirm")
	private WebElement emailConfirm;

	@FindBy(css = "[data-popover-content-id='bp-submit-popover']")
	private WebElement buttonSiguiente;
	/**
	 * Returns a LastStepsPage after enter fisrt name, last name, email and do click in Siguiente
	 * 
	 * 
	 * @return LastStepsPage
	 */

	public LastStepsPage addDate() {
		customWait.waitVisibleElement(getDriver(), buttonSiguiente);
		type(firstName, FIRST_NAME);
		type(lastName, LAST_NAME);
		type(email, EMAIL);
		type(emailConfirm, EMAIL);
		click(buttonSiguiente);
		return new LastStepsPage(getDriver());
	}

}
