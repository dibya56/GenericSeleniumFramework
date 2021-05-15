package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	public boolean retry(ITestResult result) {
		
		int currentCount = 0;
		int retryCount = 1;
		
		while(currentCount < retryCount) {
			currentCount++;
			return true;
		}
		
		return false;
	}

}
