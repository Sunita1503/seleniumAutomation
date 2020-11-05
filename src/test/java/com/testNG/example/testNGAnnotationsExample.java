package com.testNG.example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNGAnnotationsExample {

	@Test(priority=2)
	public void test1() {
		System.out.println("In Test1");
	}

	@Test(description="Test2")
	public void test21() {
		System.out.println("In Test2");
	}
	
	@Test(priority =1)
	public void test23(){
		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("In before method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("In aftermethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("In beforeclass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("In afterclass");
	}

	@BeforeTest
	public void beforeTest() {
	System.out.println("In BeforeTest");
	}
	

	@AfterTest
	public void afterTest() {
		System.out.println("In AfterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("In BeforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("In AfterSuite");
	}

}
