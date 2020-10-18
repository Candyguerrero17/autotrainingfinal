package com.automation.training.tests.fails;

import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.training.pages.HomePageEspn;
import com.automation.training.pages.LogInPage;
import com.automation.training.tests.BaseTests;
import com.automation.training.utils.ListenersTestNG;
import com.automation.training.utils.text.Messages;
@Listeners(ListenersTestNG.class)
public class StartSessionFailEspnTest extends BaseTests{
	
	private HomePageEspn home;
	private LogInPage logIn;
	/**
	 * Verify that start session account with email existing is imposible
	 * 
	 * @author AnyOne
	 * 
	 */

	@Test(enabled = true, description = "Start session with new email in www.espn.com")
	public void verifyStartSessionWithNewEmailEspnTest() {
		home = getEspnHomePage();
		home.openBrowser(URLBASE);
		home.openProfile();
		logIn = home.openLogIn();
		logIn.starSessionFail(loadDate().getNewEmail(), loadDate().getNewPassword());
		AssertJUnit.assertTrue(logIn.getPageTitleFailLogIn().contains(Messages.ERROR_START_SESSION));
	}
}
