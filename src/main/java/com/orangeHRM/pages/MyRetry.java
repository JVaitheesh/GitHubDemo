package com.orangeHRM.pages;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// use for rerunning failed Test cases
public class MyRetry implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}
}