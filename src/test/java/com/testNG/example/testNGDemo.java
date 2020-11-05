//TestNG program to demonstrate 
//1. open url
//2. set user id and password using xpath
//3. verify if user logged in
//4. close  browser session

package com.testNG.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


public class testNGDemo {

	public static WebDriver driver = null;

	//initial browser environment set up 
	public  void initilizeWebEnvironment() {

		// set path
		// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize Window
		driver.manage().window().maximize();

		// open URL
		driver.get("http://www.demo.guru99.com/V4/");

	}

	//login with user id and password using xpath
	public  void doLogin(String strUsername, String strPassword) {

		System.out.println("USer naem and password are : " + strUsername + " : " + strPassword);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(strUsername);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(strPassword);

		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

	}
	

	//check if user logged in
	public  void verifyUserLoggedIn() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String strManager = driver.findElement(By.xpath("//a[text()='Manager']")).getText();
		System.out.println("getText -----> " + strManager);

		//AssertJUnit.assertEquals("Manager", "Manager");
		Assert.assertTrue(strManager.equals("Manager"), "** Error message for Test Failed  ");
		
	}
	
	//close current browser session
	public void tearDownEnvironment(){
		//close the current driver opened by selenium
		driver.close();
	}
	
	@Test
	public void verifyLogin(){
		initilizeWebEnvironment();
		doLogin("mngr290813", "nezebUj");
		verifyUserLoggedIn();
		tearDownEnvironment();
	}

}
