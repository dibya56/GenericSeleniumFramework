package tests;

import org.testng.annotations.Test;

import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import testUtils.BaseTest;

public class LoginTest extends BaseTest{

	HomePageEvents home = new HomePageEvents();
	LoginPageEvents login = new LoginPageEvents();
	
	@Test
	public void loginTestMethod() {
		
		/*
		 * home.clickSignInBtn(); login.login(); home.validateLogin();
		 */
		home.validateText();
	}
}