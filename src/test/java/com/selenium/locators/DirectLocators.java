package com.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//This Java program demonstrates how to use different locators - id, name, class name , xpath and css selector

public class DirectLocators {

	public static WebDriver driver = null;

	public static void locators() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "./src/main/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		// id locator
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		// name locator
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");

		// xpath
		driver.findElement(By.xpath("//*[@id='txtUsername']")).click();

		// css
		driver.findElement(By.cssSelector("#txtPassword")).click();

		// locator classname - classname may not be unique
		driver.findElement(By.className("button")).click();

	}

	public static void main(String[] args) {

		locators();
	}

}
