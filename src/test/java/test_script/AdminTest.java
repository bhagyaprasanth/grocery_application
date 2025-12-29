package test_script;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Messages;
import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase {
	@Test(description = " Verify add user ")
	public void verifyAddUser() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.clickSignInBtn();

		AdminPage adminPage = new AdminPage(driver);
		adminPage.adminPageinkClick();
		adminPage.newBtnClick();

		FakerUtility faker = new FakerUtility();
		String randomUsernameFaker = faker.createRandomUserName();
		String randomPasswordFaker = faker.createRandomPassword();

		adminPage.enterNewUsername(randomUsernameFaker);
		adminPage.enternewUserPassword(randomPasswordFaker);
		adminPage.selectUsertype(1);
		adminPage.saveBtnClick();

		WebElement alertDiv = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		Boolean alertDispayedFlag = alertDiv.isDisplayed();
		Assert.assertTrue(alertDispayedFlag, Messages.ADMIN_ASSERTS_NEW_BUTTON);
	}

}
