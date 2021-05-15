package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testUtils.BaseTest;

public class ElementFetch {

	public WebElement getWebElement(String locatorIdentifier, String locator) {
		
		WebElement element;
		
		switch(locatorIdentifier) {
			case "CSS":
				element = BaseTest.driver.findElement(By.cssSelector(locator));
				break;
			case "XPATH":
				element = BaseTest.driver.findElement(By.xpath(locator));
				break;
			case "ID":
				element = BaseTest.driver.findElement(By.id(locator));
				break;
			default:
				element = BaseTest.driver.findElement(By.xpath(locator));
				break;
		}
		
		return element;				
	}
	
	
	public List<WebElement> getListOfWebElements(String locatorIdentifier, String locator) {
		
		List<WebElement> elements;
		
		switch(locatorIdentifier) {
			case "CSS":
				elements = BaseTest.driver.findElements(By.cssSelector(locator));
				break;
			case "XPATH":
				elements = BaseTest.driver.findElements(By.xpath(locator));
				break;
			case "ID":
				elements = BaseTest.driver.findElements(By.id(locator));
				break;
			default:
				elements = BaseTest.driver.findElements(By.xpath(locator));
				break;
		}
		
		return elements;				
	}
}