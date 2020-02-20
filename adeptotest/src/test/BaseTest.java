package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseTest {

	public WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser) {
		//Check if parameter passed from TestNG is 'firefox'
		String localDir = System.getProperty("user.dir");
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.setProperty("webdriver.gecko.driver",localDir + "\\resources\\geckodriver.exe");
			System.out.println("FireFox Driver started...");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(true);
			driver = new FirefoxDriver(firefoxOptions);
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",localDir + "\\resources\\chromedriver.exe");
			//create chrome instance
			System.out.println("Chrome Driver started...");
			//driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		}
		//System.setProperty("webdriver.chrome.driver",localDir + "\\resources\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		//driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://smoketesteu.adepto.com/portal/join");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Driver was instantiated. Quitting..");
		} else {
			System.out.println("Driver was null so nothing to do");
		}
	}

}
