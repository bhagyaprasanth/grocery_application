package test_script;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	@Test
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement usernameFld = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordFld = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement signinBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		usernameFld.sendKeys(usernameValue);
		passwordFld.sendKeys(passwordValue);
		signinBtn.click();
		String loginPageUrl=driver.getCurrentUrl();
		String homePageUrl="https://groceryapp.uniqassosiates.com/admin";
		Assert.assertEquals(loginPageUrl,homePageUrl,"Login is not successful");
	}

	@Test
	public void verifyLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPage");
		WebElement usernameFld = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordFld = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement signinBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		usernameFld.sendKeys(usernameValue);
		passwordFld.sendKeys(passwordValue);
		signinBtn.click();
		String loginPageUrl=driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl,loginPageUrl,"Login is successful,  which means failed to meet the expected result ");
	}

	@Test
	public void verifyLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPage");
		WebElement usernameFld = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordFld = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement signinBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		usernameFld.sendKeys(usernameValue);
		passwordFld.sendKeys(passwordValue);
		signinBtn.click();
		String loginPageUrl=driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl,loginPageUrl,"Login is successful,  which means failed to meet the expected result ");
	}

	@Test
	public void verifyLoginWithInvalidUsernameAndInvalidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(4, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(4, 1, "LoginPage");
		WebElement usernameFld = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordFld = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement signinBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		usernameFld.sendKeys(usernameValue);
		passwordFld.sendKeys(passwordValue);
		signinBtn.click();
		String loginPageUrl=driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl,loginPageUrl,"Login is successful,  which means failed to meet the expected result ");
	}
}
