package com.automation.training.pages.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.BasePage;

public class CartPage extends BasePage {

	public CartPage(WebDriver pDriver) {
		super(pDriver);

	}

	@FindBy(css = "[class='product-name'] a")
	private WebElement nameProduct;

	@FindBy(css = "input[title='Qty']")
	private WebElement quality;

	@FindBy(css = "[class='product-subtotal']>span")
	private WebElement totalPrice;

	public boolean userNavegation() {

		return getDriver().getCurrentUrl().equals("http://34.205.174.166/cart/");
	}

	public boolean isVisibleNameProduct() {

		return getText(nameProduct).equals("CandyGuerrero");
	}

	public boolean isVisibleQualityProduct() {

		return getAttribute(quality).equals("7");
	}
	
	public boolean isVisibleTotalPriceProduct() {

		return getText(totalPrice).equals("$153.93");
	}

}
