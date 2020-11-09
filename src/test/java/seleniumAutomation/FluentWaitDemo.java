package seleniumAutomation;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FluentWaitDemo {
	
	public static WebDriver driver =null;
	@Test
	public void fluentWait() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
	driver = new ChromeDriver(); 
	
	String expectedTitle = "Demo Guru99 Page";
	String actualTitle = "" ;
	// launch Chrome and redirect it to the Base URL
	driver.get("http://demo.guru99.com/test/guru99home/" );
	//Maximizes the browser window
	driver.manage().window().maximize() ;
	//get the actual value of the title
	actualTitle = driver.getTitle();
	//compare the actual title with the expected title
	Assert.assertTrue(actualTitle.equals(expectedTitle),"Page title Mismatch");
	System.out.println("Title matched ***");

	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
			.withTimeout(30, TimeUnit.SECONDS) 			
			.pollingEvery(5, TimeUnit.SECONDS) 			
			.ignoring(NoSuchElementException.class);
	WebElement emailSubmission = wait.until(new Function<WebDriver, WebElement>(){
	
		public WebElement apply(WebDriver driver ) {
		;
			
	
	return  driver.findElement(By.xpath("//input[@id='philadelphia-field-email'])"));
					
		}
	});
	//enter  on the email id
emailSubmission.sendKeys("philly@abc.com");
	
	System.out.println("Email entered ***========");
	//close~ browser
	driver.close() ;
	
	}

}
