package pageEvents;

import pageObjects.LoginPage;
import testUtils.BaseTest;
import utils.ElementFetch;

public class LoginPageEvents {

	ElementFetch elementFetch = new ElementFetch();
	
	public void login() {
		
		elementFetch.getWebElement("CSS", LoginPage.emailTxtFld).sendKeys("");
		elementFetch.getWebElement("CSS", LoginPage.continueBtn).click();
		elementFetch.getWebElement("CSS", LoginPage.passwordTxtFld).sendKeys("");
		elementFetch.getWebElement("CSS", LoginPage.signInBtn).click();
		BaseTest.logger.info("User Clicked on sign in button after entering credentials");
	}
}