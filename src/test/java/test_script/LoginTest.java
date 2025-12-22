package test_script;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase{
	@Test
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement usernameFld=driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordFld=driver.findElement(By.xpath("//input[@name='password']"));
		WebElement signinBtn=driver.findElement(By.xpath("//button[@type='submit']"));
		usernameFld.sendKeys(usernameValue);
		passwordFld.sendKeys(passwordValue);
		signinBtn.click();
		
	}
}
