package com.automation.training.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.training.pages.HomePageEspn;
import com.automation.training.pages.LogInPage;
import com.automation.training.utils.ListenersTestNG;
import com.automation.training.utils.text.Messages;

@Listeners(ListenersTestNG.class)
public class ClosetSessionTest extends BaseTests {
	private HomePageEspn home;
	private LogInPage logIn;
	
	@Test(enabled = true, description = "Closet session in www.espn.com")
	public void testClosetSessionEspn() {
		home = getEspnHomePage();
		home.openProfile();
		logIn = home.openLogIn();
		home = logIn.starSession(loadDate().getCloseEmail(), loadDate().getClosePassword());
		home.closetSession();
		Assert.assertEquals(home.getPageTitleClosetSession(), Messages.CLOSET_SESSION);
	}



}
