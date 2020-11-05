
package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Java program to demonstrate Action class for Drag and drop

public class DragAndDropDemo {

	public static WebDriver driver = null;
	
	public static void setEnvironment() throws InterruptedException{
		
		//set path for driver exe
		//System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//navigate to url
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		//set wait
		Thread.sleep(1000);
	}
	
	public static void dragAndDropElement(){
		
		//create object of action class
		Actions objActions = new Actions(driver);
		
		//locate source element
		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		//locate target element
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		//drag source element to destination
		objActions.dragAndDrop(sourceElement, targetElement).perform();
		System.out.println("element dropped to destination");
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		setEnvironment();
		dragAndDropElement();
	}

}
