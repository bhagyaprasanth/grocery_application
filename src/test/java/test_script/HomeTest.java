package test_script;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Messages;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	@Test
	public void VerifyLogout() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement usernameFld = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordFld = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement signinBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		usernameFld.sendKeys(usernameValue);
		passwordFld.sendKeys(passwordValue);
		signinBtn.click();
		WebElement adminIcon = driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
		adminIcon.click();
		WebElement logoutBtn = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
		logoutBtn.click();
		String loginPageURL="https://groceryapp.uniqassosiates.com/admin/login";
		String currentPageUrl=driver.getCurrentUrl();
		Assert.assertEquals(currentPageUrl, loginPageURL,Messages.HOME_ASSERTS_LOGOUT);
	}
}
