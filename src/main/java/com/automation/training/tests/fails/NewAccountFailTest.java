package com.automation.training.tests.fails;

import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.training.pages.HomePageEspn;
import com.automation.training.pages.LogInPage;
import com.automation.training.pages.NewAcountPage;
import com.automation.training.tests.BaseTests;
import com.automation.training.utils.ListenersTestNG;
import com.automation.training.utils.text.Messages;
@Listeners(ListenersTestNG.class)
public class NewAccountFailTest extends BaseTests{
	
	private HomePageEspn home;
	private LogInPage logIn;
	private NewAcountPage newAcount;

	
	@Test(description = "Test fail with email old in www.espn.com")
	public void testFailNewAcountEspn() {
		home = getEspnHomePage();
		home.openProfile();
		logIn = home.openLogIn();
		newAcount = logIn.openRegister();
		newAcount.informationNewAcount(loadDate().getNewName(), loadDate().getNewLasName(), loadDate().getOldEmail(),
				loadDate().getOldPassword());

		AssertJUnit.assertTrue(newAcount.getPageTextFail().contains(Messages.ERROR_EMAIL));

	}

}
