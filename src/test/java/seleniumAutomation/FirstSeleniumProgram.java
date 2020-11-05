//selenium program to demonstrate  -
//1. open URL  s
//2. set user ID and password using xpath 
//3. Verify if user logged in 


package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstSeleniumProgram {

	public static WebDriver driver = null;


	public static void initilizeWebEnvironment() {

		// set path
		// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize Window
		driver.manage().window().maximize();

		// open URL
		driver.get("http://www.demo.guru99.com/V4/");

	}

	//set user id and password using xpath
	public static void doLogin(String strUsername, String strPassword) {

		System.out.println("USer naem and password are : " + strUsername + " : " + strPassword);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(strUsername);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(strPassword);

		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

	}

	//verify if user logged in
	public static void verifyUserLoggedIn() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String strManager = driver.findElement(By.xpath("//a[text()='Manager']")).getText();
		System.out.println("getText -----> " + strManager);

		if (strManager.equals("Manager"))
			System.out.println("LoggedIn Successfully");
		else
			System.out.println("Login Failed");

	}

	//close browser current seesion
	public static void tearDownEnvironment() {
		// close the current driver opened by selenium
		driver.close();
	}

	public static void main(String[] args) {

		initilizeWebEnvironment();
		doLogin("mngr290813", "nezebUj");
		verifyUserLoggedIn();
		tearDownEnvironment();

	}

}
