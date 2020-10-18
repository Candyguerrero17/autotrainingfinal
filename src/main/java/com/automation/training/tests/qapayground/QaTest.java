package com.automation.training.tests.qapayground;

import static com.automation.training.utils.text.ConfigProperties.URLBASEQA;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.training.pages.qa.CartPage;
import com.automation.training.pages.qa.QaProductPage;
import com.automation.training.utils.tests.BaseTests;


public class QaTest extends BaseTests{
	private static int id; 
	private QaProductPage qa;
	private CartPage card;
	/**
	 * Create a product with api.
	 * @author AnyOne
	 * 
	 */
	@BeforeTest
	public void createProductoApiTest() {
		id = baseweb.requestPostWithtAuthorization();
System.out.println(id );
	}
	/**
	 * Add quality to card 
	 * verify prices, and name.
	 * 
	 * @author AnyOne
	 * 
	 */
	@Test
	public void verifyNewProduct() {
		qa= getQaProductPage();
		qa.openBrowser(URLBASEQA);
		assertTrue(qa.isDisableTittleProduct());
		assertTrue(qa.isDisablePriceProduct());
		card = qa.addQuantityToCard();
		assertTrue(card.userNavegation());
		assertTrue(card.isVisibleNameProduct());
		assertTrue(card.isVisibleQualityProduct());
		assertTrue(card.isVisibleTotalPriceProduct());
	}
	
	/**
	 * Delete product..
	 * @author AnyOne
	 * 
	 */
	@AfterTest
	public void deleteProductoApiTest() {
		int statusCode= baseweb.requestDeleteWithtAuthorization(id).getStatusCode();
		assertEquals(statusCode, 200);
	}


	
}
