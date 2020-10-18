package com.automation.training.pages.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.pages.BasePage;
import com.automation.training.utils.text.DataQa;
/**
 * Description:page cart
 *
 */
public class CartPage extends BasePage {
	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : WebDriver
	 */
	public CartPage(WebDriver pDriver) {
		super(pDriver);

	}
	// WebElements

	@FindBy(css = "[class='product-name'] a")
	private WebElement nameProduct;

	@FindBy(css = "input[title='Qty']")
	private WebElement quality;

	@FindBy(css = "[class='product-subtotal']>span")
	private WebElement totalPrice;
	/**
	 * 
	 * @return true if url is equals

	 */
	public boolean userNavegation() {

		return getDriver().getCurrentUrl().equals(DataQa.CURRENT_URL);
	}
	/**
	 * 
	 * @return true if name product is equals

	 */
	public boolean isVisibleNameProduct() {

		return getText(nameProduct).equals(DataQa.NAME_PRODUCT);
	}
	/**
	 * 
	 * @return true if quaity of product is equals

	 */
	public boolean isVisibleQualityProduct() {

		return getAttribute(quality).equals(DataQa.QUALITY);
	}
	/**
	 * 
	 * @return true if prices is equals

	 */
	public boolean isVisibleTotalPriceProduct() {

		return getText(totalPrice).equals(DataQa.PRICES);
	}

}
