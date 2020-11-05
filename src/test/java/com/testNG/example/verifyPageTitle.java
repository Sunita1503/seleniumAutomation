package com.testNG.example;

import java.io.File;
import java.io.IOException;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//TestNG sript to verify title of page

@Listeners(com.listeners.testNGListener.class)
public class verifyPageTitle {

	public static WebDriver driver =null;
	
	@Test(priority =1)
	public  void verifyTitle() {

		//initial browser environment set up 
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

			// Maximize Window
			driver.manage().window().maximize();

			// open URL
			driver.get("http://www.demo.guru99.com/V4/");
			
			String strTitle = driver.getTitle();
			System.out.println(strTitle);
			Assert.assertTrue(strTitle.equals("Guru99 Bank Home Page"), "Title mismatch");
		}

		@Test
		public void captureScreenshot() throws IOException{
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File ("C:\\Workspace\\seleniumAutomation\\src\\main\\resources\\screenshot\\screenshot1.png"));
		}
		
		//close current browser session
		@Test(priority =2)
		public void tearDownEnvironment(){
			//close the current driver opened by selenium
			driver.close();
		}
		
		
	
}
