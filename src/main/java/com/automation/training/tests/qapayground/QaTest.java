package com.automation.training.tests.qapayground;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.training.pages.qa.CartPage;
import com.automation.training.pages.qa.QaProductPage;
import com.automation.training.utils.BaseTests;


public class QaTest extends BaseTests{
	private static int id; 
	private QaProductPage qa;
	private CartPage card;
	@BeforeTest
	public void createProductoApiTest() {
		id = baseweb.requestPostWithtAuthorization();

		System.out.print(id);
	}
	
	@Test
	public void verifyNewProduct() {
		
		qa= getQaProductPage();
		assertTrue(qa.isDisableTittleProduct());
		assertTrue(qa.isDisablePriceProduct());
		card = qa.addQuantityToCard();
		assertTrue(card.userNavegation());
		assertTrue(card.isVisibleNameProduct());
		assertTrue(card.isVisibleQualityProduct());
		assertTrue(card.isVisibleTotalPriceProduct());
	}
	@AfterTest
	public void deleteProductoApiTest() {
		int statusCode= baseweb.requestDeleteWithtAuthorization(id).getStatusCode();
		assertEquals(statusCode, 200);
	}


	
}
