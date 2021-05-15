package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import testUtils.BaseTest;

public class SuitListener implements ITestListener, IAnnotationTransformer {

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {

		try {

			// Convert Webdriver Object to TakeScreenShot
			TakesScreenshot scrShot = (TakesScreenshot) BaseTest.driver;

			// Call getScreenshotAs Method to create image file
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination
			File destFile = new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
					+ "Screenshot-" + System.currentTimeMillis() + ".png");

			// Copy File at Destination
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
