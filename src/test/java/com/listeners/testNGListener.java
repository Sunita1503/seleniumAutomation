package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testNGListener implements ITestListener{

	
	public void onFinish(ITestContext result) {
		
		
	}

	public void onStart(ITestContext result) {
	
		System.out.println("Test cases started :" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Testcases failed and details are : " + result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcases skipped and details are : " + result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcases successful and details are : " + result.getName());
		
	}

}
