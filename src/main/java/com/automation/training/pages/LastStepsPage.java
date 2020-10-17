package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LastStepsPage extends BasePage {

	public LastStepsPage(WebDriver pDriver) {
		super(pDriver);
	}

	@FindBy(css = "#phone")

	private WebElement phone;

	@FindBy(css = "[class='required_fields_description restrict_width']")
	private WebElement message1;
	@FindBy(css = "[class=\"book-form-field field_name_full_name\"] div:nth-child(2)")

	private WebElement fullName;
	@FindBy(css = "[class='personal_details_reassurance_email_text']")

	private WebElement email;
	@FindBy(css = "[class='highlight_phone_help_message_wrapper']")

	private WebElement message2;

	public void enterPhone() {
		customWait.waitVisibleElement(getDriver(), phone);
		type(phone, "3188807359");

	}

	public boolean isVisibleMessageAlmost() {
		return getText(message1).contains("¡Ya casi estás! Solo tienes que rellenar los campos marcados con");
	}

	public boolean isVisibleFullName() {
		return getText(fullName).contains("Candy Guerrero");
	}

	public boolean isVisibleEmail() {
		return getText(email).contains("candygueme.cg@gmail.com");
	}

}
