package com.automation.training.pages.booking;

import static com.automation.training.utils.text.Messages.BAD_NUMBER;
import static com.automation.training.utils.text.Messages.PHONE_HELP;
import static com.automation.training.utils.text.Messages.REQUEST_FIELDS;
import static com.automation.training.utils.text.TextData.CVC_CARD;
import static com.automation.training.utils.text.TextData.EMAIL;
import static com.automation.training.utils.text.TextData.FIRST_NAME;
import static com.automation.training.utils.text.TextData.NAME_CARD;
import static com.automation.training.utils.text.TextData.NUMBER_CARD;
import static com.automation.training.utils.text.TextData.NUMBER_PHONE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.BasePage;
/**
 * Description:Last steps to reserve
 *
 */
public class LastStepsPage extends BasePage {
	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : WebDriver
	 */
	public LastStepsPage(WebDriver pDriver) {
		super(pDriver);
	}

	// WebElements
	@FindBy(css = "[class='required_fields_description restrict_width']")
	private WebElement messageRequiredFields;

	@FindBy(css = "[class='highlight_phone_help_message_wrapper']")
	private WebElement messagePhoneHelp;

	@FindBy(css = "p#bp_form_cc_number_msg")
	private WebElement messageCcNumber;

	@FindBy(css = "[class=\"book-form-field field_name_full_name\"] div:nth-child(2)")
	private WebElement fullName;

	@FindBy(css = "[class='personal_details_reassurance_email_text']")
	private WebElement email;

	@FindBy(css = "#phone")
	private WebElement phone;

	@FindBy(css = "#cc_type")
	private WebElement typeCard;

	@FindBy(css = "#cc_number")
	private WebElement numberCard;

	@FindBy(css = "#cc_cvc")
	private WebElement cvcCard;

	@FindBy(id = "tag-container")
	private WebElement frame;

	@FindBy(css = "button[data-bui-ref='modal-close']")
	private WebElement buttonCloseWindow;

	/**
	 * Enter number phone and call method to close windows
	 * 
	 */
	public void enterNumberPhone() {
		customWait.waitVisibleElement(getDriver(), phone);
		type(phone, NUMBER_PHONE);
		popUpsPresent();
	}

	/**
	 * close the window
	 * 
	 */
	public void popUpsPresent() {
		customWait.waitElementToBeClickable(getDriver(), buttonCloseWindow);
		click(buttonCloseWindow);
	}

	/**
	 * Enter information to pay
	 * 
	 */
	public void enterInformacionToPay() {

		selectOptionValue(typeCard, NAME_CARD);
		type(numberCard, NUMBER_CARD);
		type(cvcCard, CVC_CARD);

	}

	/**
	 * 
	 * @return true if full name is equal
	 * 
	 */
	public boolean isVisibleFullName() {
		return getText(fullName).contains(FIRST_NAME);
	}

	/**
	 * 
	 * @return true if email is equal
	 * 
	 */
	public boolean isVisibleEmail() {
		return getText(email).contains(EMAIL);
	}

	/**
	 * 
	 * @return true if message resquest filds is equal
	 * 
	 */
	public boolean isVisibleMessageRequestedFields() {
		return getText(messageRequiredFields).contains(REQUEST_FIELDS);
	}

	/**
	 * 
	 * @return true if massage phone help is equal
	 * 
	 */
	public boolean isVisibleMessagePhoneHelp() {
		return getText(messagePhoneHelp).contains(PHONE_HELP);
	}

	/**
	 * 
	 * @return true if message number card is equal
	 * 
	 */
	public boolean isVisibleMessageNumberCard() {
		customWait.waitVisibleElement(getDriver(), messageCcNumber);
		return getText(messageCcNumber).contains(BAD_NUMBER);
	}

}
