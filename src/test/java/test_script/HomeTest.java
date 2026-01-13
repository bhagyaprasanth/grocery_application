package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Constants;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {

	public HomePage homePage;

	@Test(description = " Verify logout click ", groups = { "smoke" })
	public void VerifyLogout() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue).enterPassword(passwordValue);
		/*
		 * loginPage.enterUserName(usernameValue);
		 * loginPage.enterPassword(passwordValue);
		 */
		homePage = loginPage.clickSignInBtn();

		/* 
		 * HomePage homePage=new HomePage(driver); 
		 * */
		homePage.adminIconClick();
		loginPage=homePage.logoutBtnClick();

		String loginPageURL = "https://groceryapp.uniqassosiates.com/admin/login";
		String currentPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentPageUrl, loginPageURL, Messages.HOME_ASSERTS_LOGOUT);
	}
}
