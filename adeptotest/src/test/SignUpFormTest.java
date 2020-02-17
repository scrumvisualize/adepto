package test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignUpFormPage;
import utilities.CaptureScreenShot;

/** 
 * Author: Vinod Mathew
 * Date:   13 Feb 2020
 * Project: Selenium Test project
 */

public class SignUpFormTest extends BaseTest {
	
	/**Test to verify whether the system validates for 'invalid' email entered in the Account Email field:**/

	@Test(enabled = true)
	public void invalidEmailSignup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		String xpath = "//span[text()='Sign Up']";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		elem.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SignUpFormPage signup = new SignUpFormPage(driver);
		signup.setEmail("test@sample");
		signup.setFirstName("Bird");
		signup.setLastName("Watcher");
		signup.setPassword("AgeIsLessThan180!");
		signup.signupButton();
		WebElement validationElement = driver.findElement(By.xpath("//span[text()='Invalid email']"));
		String validationText = validationElement.getText();
		Assert.assertEquals("Invalid email", validationText);
	}
	
	/**Test to verify whether the system validates for 'blank' email in the Account Email field:**/
	
	@Test(enabled=true)
	public void blankEmailSignUp() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		String xpath = "//span[text()='Sign Up']";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		elem.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SignUpFormPage signup = new SignUpFormPage(driver);
		signup.setEmail("");
		signup.setFirstName("Bird");
		signup.setLastName("Watcher");
		signup.setPassword("AgeIsLessThan180!");
		signup.signupButton();
		WebElement validationElement = driver.findElement(By.xpath("//span[text()='An account email is required']"));
		String validationText = validationElement.getText();
		Assert.assertEquals("An account email is required", validationText);
		
	}
	
	/**Test to verify whether the system 'counts and display' number of characters entered in the FirstName field:**/
	
	@Test(enabled=true)
	public void getCountOfCharacters() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		String xpath = "//span[text()='Sign Up']";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		elem.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SignUpFormPage signup = new SignUpFormPage(driver);
		signup.setEmail("test@sample");
		signup.setFirstName("Soccerman");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement firstName = driver.findElement(By.id("firstName"));
		String countFirstName = firstName.getAttribute("value");
		int textCount = countFirstName.length();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement countDisplayed = driver.findElement(By.xpath("//span[text()='9 / 35']"));
		String countOfLetters = countDisplayed.getText();
		String partOne = countOfLetters.substring(0, 1);
		int finalCount = Integer.parseInt(partOne);
		System.out.println("Count of characters:"+partOne);
		Assert.assertEquals(finalCount, textCount);
		
	}
	
	/**Test to verify whether the system successfully navigates to Login screen during on click on I already have an account link **/
	
	@Test(enabled=true)
	public void navigateToLoginScreen() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String xpath = "//span[text()='Sign Up']";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		elem.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SignUpFormPage signup = new SignUpFormPage(driver);
		signup.alreadyHaveAccount();
		WebElement loginHeaderElement = driver.findElement(By.xpath("//span[text()='Log in']"));
		String headerText = loginHeaderElement.getText();
		Assert.assertEquals("Log in", headerText);
		
	}
	//soccerway@maildrop.cc
	
	/**Test to verify whether the system successfully allows to register the user and display the Welcome screen: **/
	
	@Test(enabled = true)
	public void successfullSignUp() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		String xpath = "//span[text()='Sign Up']";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		elem.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SignUpFormPage signup = new SignUpFormPage(driver);
		signup.setEmail("soccerway@maildrop.cc");
		signup.setFirstName("Bird");
		signup.setLastName("Watcher");
		signup.setPassword("AgeIsLessThan180!");
		signup.signupButton();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement welcomeElement = driver.findElement(By.xpath("//span[text()='Welcome, Bird Watcher']"));
		String welcomeText = welcomeElement.getText();
		System.out.println("Check Welcome page:" +welcomeText);
		CaptureScreenShot capturescreenshot = new CaptureScreenShot();
		try {
			capturescreenshot.robo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("See if it is registered :"+welcomeText);
		Assert.assertEquals("Welcome, Bird Watcher", welcomeText);
	}
	
	

}
