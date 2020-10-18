package com.automation.training.tests.fails;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.training.pages.DeleteAccountPage;
import com.automation.training.pages.HomePageEspn;
import com.automation.training.pages.LogInPage;
import com.automation.training.tests.BaseTests;
import com.automation.training.utils.text.Messages;


public class DeleteAccountFailTest extends BaseTests {
	private HomePageEspn home;
	private LogInPage logIn;
	private DeleteAccountPage deleteAccount;

	/**
	 * Verify that account not existing is imposible delete
	 * 
	 * @author AnyOne
	 * 
	 */
	@Test(enabled = true, description = "Delete fail account in www.espn.com")
	public void verifyFailDeleteAcountEspnTest() {
		home = getEspnHomePage();
		home.openBrowser(URLBASE);
		home.openProfile();
		logIn = home.openLogIn();
		deleteAccount =logIn.starSessionFail(loadDate().getDeleteEmailOld(), loadDate().getDeletePasswordOld());
		Assert.assertEquals(deleteAccount.getPagetitleDeleteAccountFail(), Messages.ERROR_ACCOUNT_DELETED);
	}
}
