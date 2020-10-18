package com.automation.training.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.training.pages.HomePageEspn;
import com.automation.training.pages.LogInPage;
import com.automation.training.utils.ListenersTestNG;
import com.automation.training.utils.text.Messages;

@Listeners(ListenersTestNG.class)
public class CloseSessionTest extends BaseTests {
	private HomePageEspn home;
	private LogInPage logIn;
	/**
	 * Verify close session
	 * 
	 * @author AnyOne
	 * 
	 */
	@Test(enabled = true, description = "Close session in www.espn.com")
	public void verifyCloseSessionEspnTest() {
		home = getEspnHomePage();
		home.openBrowser(URLBASE);
		home.openProfile();
		logIn = home.openLogIn();
		home = logIn.starSession(loadDate().getCloseEmail(), loadDate().getClosePassword());
		home.closeSession();
		Assert.assertEquals(home.getPageTitleCloseSession(), Messages.CLOSE_SESSION);
	}



}
