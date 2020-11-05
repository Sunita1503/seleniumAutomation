package com.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//This java program demonstrates how to use links as locators
public class LocatorLinks {

	public static WebDriver driver = null;

	public static void locatorLinksDemo() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "./src/main/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		// linktest locator
		// driver.findElement(By.partialLinkText("Forgot your
		// password?")).click();

		// partial link locator
		// driver.findElement(By.partialLinkText("Forgot your")).click();

		// tagname
		System.out.println("No of images on pages are : " + driver.findElements(By.tagName("img")).size());

	}

	public static void main(String[] args) {

		locatorLinksDemo();

	}

}
