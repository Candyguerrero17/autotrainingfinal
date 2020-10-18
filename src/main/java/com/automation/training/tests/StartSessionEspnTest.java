package com.automation.training.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.automation.training.pages.HomePageEspn;
import com.automation.training.pages.LogInPage;


public class StartSessionEspnTest extends BaseTests{
	private HomePageEspn home;
	private LogInPage logIn;

	/**
	 * Verify start session
	 * 
	 * @author AnyOne
	 * 
	 */
	@Test(enabled = true, description = "Start session in www.espn.com")
	public void verifyStartSessionEspnTest() {
		home = getEspnHomePage();
		home.openBrowser(URLBASE);
		home.openProfile();
		logIn = home.openLogIn();
		home = logIn.starSession(loadDate().getCloseEmail(), loadDate().getClosePassword());
		AssertJUnit.assertTrue(home.getPageTitleProfile().contains(loadDate().getOldName()));
	}
	

}
