package com.herokuapp.theinternet.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("----test starts---");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("----test is succesful---------");
	}
	
	public void onStart(ITestContext context) {
		System.out.println("----START----------");
	}
	
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("----FINISH----------");
	}

}
