package com.automation.training.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.training.pages.ArticlePage;
import com.automation.training.pages.WikiHomePage;

public class WikiTests extends BaseTests {

	@Test(enabled = false)
	public void testWikiSearch() {
		WikiHomePage home = getWikiHomePage();
		ArticlePage articlePage = home.buscar("Java");
		Assert.assertEquals(articlePage.getPageTitle(), "Java");
	}

	@Test
	public void testWikiSearchArticlePage() {
		WikiHomePage home = getWikiHomePage();
		ArticlePage articlePage = home.buscar("Java");
		articlePage.search("Hola mundo");
		Assert.assertEquals(articlePage.getPageTitle(), "Hola mundo");
	}
	

}
