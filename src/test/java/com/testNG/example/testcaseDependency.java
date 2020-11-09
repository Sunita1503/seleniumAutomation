package com.testNG.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testcaseDependency {
	
	public static WebDriver driver = null;
	
	@Test
	public void initializeEnvironment(){
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize Window
		driver.manage().window().maximize();

		// open URL
		driver.get("http://www.demo.guru99.com/V4/");
		
	/*	Assert.assertEquals(12, 13, "Test Failed");
		System.out.println("Starting the app ");*/
	}

	@Test (dependsOnMethods = "initializeEnvironment")
	public void doLogin(){
		
		System.out.println("Log in to app");
		//locate user name and set value
		driver.findElement(By.name("uid")).sendKeys("mngr290813");
		
		//locate password and set value
		driver.findElement(By.name("password")).sendKeys("nezebUj");
		
		//locate and click login button
		driver.findElement(By.name("btnLogin")).click();
		
		//set wait
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		//Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Log out']")).equals("Log out"), "Log in successful");
	}
	
	@Test (dependsOnMethods ="doLogin" )
	public void doLogout(){

		//locate and click log out button
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
			System.out.println("Logout App");
	}
	
	/*@Test(dependsOnMethods = "doLogout")
	public void teardownEnvironment(){
		driver.close();
	}*/
}
