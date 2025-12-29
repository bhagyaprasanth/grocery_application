package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName(String usernameValue) {

		WebElement usernameFld = driver.findElement(By.xpath("//input[@name='username']"));
		usernameFld.sendKeys(usernameValue);
	}

	public void enterPassword(String passwordValue) {
		WebElement passwordFld = driver.findElement(By.xpath("//input[@name='password']"));
		passwordFld.sendKeys(passwordValue);
	}

	public void clickSignInBtn() {
		WebElement signinBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		signinBtn.click();
	}
}
