package com.automation.training.utils.others;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("*** Test method " + result.getName() + " started ***");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(("*** Finished test method " + result.getMethod().getMethodName() + "Success..."));

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " Skipped...");

		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " Failed bur within Succes Percentage...");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
		
	}

	@Override
	public void onFinish(ITestContext result) {
		System.out.println(("*** Test Suite " + result.getName() + " ending ***"));
		
	}


	
}
