package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Constants;
import constants.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase {
	public HomePage homePage;
	public AdminPage adminPage;

	@Test(description = " Verify add user ")
	public void verifyAddUser() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);

		FakerUtility faker = new FakerUtility();
		String randomUsernameFaker = faker.createRandomUserName();
		String randomPasswordFaker = faker.createRandomPassword();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue);
		loginPage.enterPassword(passwordValue);
		homePage = loginPage.clickSignInBtn();

//		AdminPage adminPage = new AdminPage(driver);
		adminPage = homePage.adminPageinkClick();
		adminPage.newBtnClick().enterNewUsername(randomUsernameFaker).enternewUserPassword(randomPasswordFaker)
				.selectUsertype(1).saveBtnClick();

		boolean alertDispayedFlag = adminPage.checkWhetheralertDisplayed();
		Assert.assertTrue(alertDispayedFlag, Messages.ADMIN_ASSERTS_NEW_BUTTON);
	}

}
