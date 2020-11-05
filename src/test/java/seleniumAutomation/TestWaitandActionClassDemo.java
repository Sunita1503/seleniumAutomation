package seleniumAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestWaitandActionClassDemo {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\seleniumAutomation\\src\\main\\resources\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		//element which needs to drag
		WebElement From = driver.findElement(By.xpath("//a[text()=' BANK ']"));
		
		//element on which needs to drop
		WebElement To = driver.findElement(By.xpath("//ol[@id='bank']/li"));
		
		//using Actions class for Drag and Drop
		Actions objActions = new Actions(driver);
		
		//Dragged and dropped
		//objActions.dragAndDrop(From, To).build().perform();
		
		objActions.moveToElement(From).clickAndHold().release(To).build().perform();
		
		
		
	}

}
