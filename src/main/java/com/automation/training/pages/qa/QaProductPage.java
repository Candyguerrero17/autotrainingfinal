package com.automation.training.pages.qa;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.BasePage;

public class QaProductPage extends BasePage {

	public QaProductPage(WebDriver pDriver) {
		super(pDriver);
		pDriver.get("http://34.205.174.166/product/candyguerrero/");
	}

	@FindBy(css = "[class='product_title entry-title']")
	private WebElement titlleProduct;

	@FindBy(css = "[class='summary entry-summary']>p:first-of-type>span>span")
	private WebElement priceProduct;

	@FindBy(css = "input[title='Qty']")
	private WebElement quantityInput;

	@FindBy(css = "[name='add-to-cart']")
	private WebElement buttonAddCart;

	@FindBy(css = "a[class='cart-contents']")
	private WebElement buttonGoCart;
	
	@FindBy(css = "[role='alert']")
	private WebElement alert;
	
	public boolean isDisableTittleProduct() {
		customWait.waitVisibleElement(getDriver(), titlleProduct);
		return titlleProduct.isDisplayed();
	}

	public boolean isDisablePriceProduct() {

		return priceProduct.isDisplayed();
	}

	public CartPage addQuantityToCard() {
		quantityInput.clear();
		type(quantityInput, "7");
		click(buttonAddCart);
		customWait.waitVisibleElement(getDriver(), alert);
		click(buttonGoCart);
		
		return new CartPage(getDriver());
	}

}
