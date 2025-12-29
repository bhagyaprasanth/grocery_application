package test_script;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	@Test(priority = 1, description = "Verify login with valid credentials")
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.clickSignInBtn();

		String loginPageUrl = driver.getCurrentUrl();
		String homePageUrl = "https://groceryapp.uniqassosiates.com/admin";
		Assert.assertEquals(loginPageUrl, homePageUrl, Messages.LOGIN_ASSERTS_VALID);
	}

	@Test(priority = 2, description = "Verify login with valid username and invalid password")
	public void verifyLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.clickSignInBtn();

		String loginPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, loginPageUrl, Messages.LOGIN_ASSERTS_INVALID);
	}

	@Test(priority = 3, description = "Verify login with invalid username and valid password")
	public void verifyLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.clickSignInBtn();

		String loginPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, loginPageUrl, Messages.LOGIN_ASSERTS_INVALID);
	}

	@Test(priority = 4, description = "Verify login with invalid username and invalid password")
	public void verifyLoginWithInvalidUsernameAndInvalidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(4, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(4, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.clickSignInBtn();

		String loginPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, loginPageUrl, Messages.LOGIN_ASSERTS_INVALID);
	}
}
