package com.automation.training.tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.training.pages.HomePageEspn;
import com.automation.training.pages.LogInPage;
import com.automation.training.pages.NewAcountPage;
import com.automation.training.utils.ListenersTestNG;

@Listeners(ListenersTestNG.class)
public class NewAccountTest extends BaseTests {
	private HomePageEspn home;
	private LogInPage logIn;
	private NewAcountPage newAcount;

	/**
	 * Verify create account
	 * 
	 * @author AnyOne
	 * 
	 */
	@Test(priority = 0,description = "Create new account in www.espn.com")
	public void verifyNewAcountEspnTest() throws IOException, ParseException {
		home = getEspnHomePage();
		home.openBrowser(URLBASE);
		home.openProfile();
		logIn = home.openLogIn();
		newAcount = logIn.openRegister();
		newAcount.informationNewAcount(loadDate().getNewName(), loadDate().getNewLasName(),
				loadDate().getNewEmail(), loadDate().getNewPassword());
		home = newAcount.sendInformation();
		AssertJUnit.assertTrue(home.getPageTitleProfile().contains(loadDate().getNewName()));
		
	}


}
