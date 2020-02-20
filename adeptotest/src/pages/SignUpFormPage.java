package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpFormPage {

	public WebDriver driver;

	public SignUpFormPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setEmail(String email) {
		driver.findElement(By.id("email")).sendKeys(email);
	}

	public void setFirstName(String firstName) {
		driver.findElement(By.id("firstName")).sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		driver.findElement(By.id("lastName")).sendKeys(lastName);
	}

	public void setPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	public void signupButton() {
		WebElement signUpBtn = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root sc-EHOje eOPPVY sc-ifAKCX dAqZeD MuiButton-contained']"));
		signUpBtn.click();
	}

	public void alreadyHaveAccount() {
		WebElement alreadyHaveLink = driver.findElement(By.xpath("//a[text()='I already have an account']"));
		alreadyHaveLink.click();
	}

}
