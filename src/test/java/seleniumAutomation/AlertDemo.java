package seleniumAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Java program to demonstrate alert 
public class AlertDemo {

	public static WebDriver driver = null;


	public static void initilizeWebEnvironment() throws InterruptedException {

		// set path
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize Window
		driver.manage().window().maximize();

		// open URL
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		//locate elements
		driver.findElement(By.name("cusid")).sendKeys("53920");
		
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(3000);
		
		Alert objAlert = driver.switchTo().alert();
		
		//Display Alert message
		System.out.println("Alert Text is : " + objAlert.getText());
		
		Thread.sleep(5000);

		//Acceptiing alert
		objAlert.accept();
		System.out.println("Alert accepted");
		
		//cancel the alert
//		objAlert.dismiss();
//		System.out.println("Alert dismissed");
	}
	
	public static void testAlert(){
		
		//locate element
		//driver.findElement(By.linkText("Generate Alert Box")).click();
		
		//Alert objAlert = (Alert) driver.switchTo().alert();
				
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		initilizeWebEnvironment();
		//testAlert();

	}

}
