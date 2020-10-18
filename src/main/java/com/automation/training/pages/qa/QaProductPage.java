package com.automation.training.pages.qa;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.pages.BasePage;
import com.automation.training.utils.text.DataQa;
/**
 * Description:page of product
 *
 */
public class QaProductPage extends BasePage {
	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : WebDriver
	 */
	public QaProductPage(WebDriver pDriver) {
		super(pDriver);

	}
	// WebElements
	@FindBy(css = "[class='product_title entry-title']")
	private WebElement titleProduct;

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
	/**
	 * 
	 * @return true if title is displayed

	 */
	public boolean isDisableTittleProduct() {
		customWait.waitVisibleElement(getDriver(), titleProduct);
		return titleProduct.isDisplayed();
	}
	/**
	 * 
	 * @return true if price is displayed

	 */
	public boolean isDisablePriceProduct() {

		return priceProduct.isDisplayed();
	}
	/**
	 * Return a CartPage after enter quality and add of cart
	 * @return CartPage

	 */
	public CartPage addQuantityToCard() {
		quantityInput.clear();
		type(quantityInput, DataQa.QUALITY);
		click(buttonAddCart);
		customWait.waitVisibleElement(getDriver(), alert);
		click(buttonGoCart);
		return new CartPage(getDriver());
	}

}
