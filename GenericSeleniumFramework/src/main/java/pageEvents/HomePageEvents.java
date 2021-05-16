package pageEvents;

import org.testng.Assert;

import pageObjects.HomePage;
import testUtils.BaseTest;
import utils.ElementFetch;

public class HomePageEvents {

	ElementFetch elementFetch = new ElementFetch();
	
	public void clickSignInBtn() {
		
		elementFetch.getWebElement("CSS", HomePage.signInBtn).click();
		BaseTest.logger.info("User Naviagated to Login Page");
	}
	
	public void validateLogin() {
		
		Assert.assertTrue(elementFetch.getListOfWebElements("CSS", HomePage.amazonLogo).size()>0, "Login not successfull");
		BaseTest.logger.info("Login Successfull");
	}
	
	public void validateText() {

		Assert.assertEquals(elementFetch.getWebElement("XPATH", HomePage.pageText).getText(), "Jekins");
		BaseTest.logger.info("Success");
	}
}