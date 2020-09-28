package com.automation.training.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.training.pages.DeleteAccountPage;

import com.automation.training.pages.HomePageEspn;
import com.automation.training.pages.LogInPage;
import com.automation.training.utils.text.Messages;

public class DeleteAccountTest extends BaseTests {

	private HomePageEspn home;
	private LogInPage logIn;
	private DeleteAccountPage deleteAccount;

	@Test(enabled = true, description = "Delete account in www.espn.com")
	public void testDeleteAcountEspn() {
		home = getEspnHomePage();
		home.openProfile();
		logIn = home.openLogIn();
		home = logIn.starSession(loadDate().getDeleteEmail(), loadDate().getDeletePassword());
		deleteAccount = home.delete();
		deleteAccount.delete();
		Assert.assertEquals(deleteAccount.getPagetitleDeleteAcount(), Messages.DELETE_ACCOUNT);
	}
}
