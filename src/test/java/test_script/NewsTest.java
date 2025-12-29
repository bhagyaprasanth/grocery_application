package test_script;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Messages;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestNGBase {
	@Test(description = " Verify home link click ")
	public void verifyHomeLinkClick() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.clickSignInBtn();

		NewsPage NewsPage = new NewsPage(driver);
		NewsPage.newsLinkClick();
		NewsPage.homeLinkClick();

		String homePageURL = "https://groceryapp.uniqassosiates.com/admin/home";
		String currentPageURL = driver.getCurrentUrl();
		Assert.assertEquals(homePageURL, currentPageURL, Messages.NEWS_ASSERTS_HOME_PAGE_LINK);
	}

	@Test(description = " Verify reset link click ")
	public void verifyResetBtnClick() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.clickSignInBtn();

		NewsPage NewsPage = new NewsPage(driver);
		NewsPage.newsLinkClick();
		NewsPage.resetLinkClick();

		String newsListPageURL = "https://groceryapp.uniqassosiates.com/admin/list-news";
		String currentPageURL = driver.getCurrentUrl();
		Assert.assertEquals(newsListPageURL, currentPageURL, Messages.NEWS_ASSERTS_HOME_PAGE_LINK);
	}

	@Test(description = " Verify save news click ")
	public void verifySaveNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.clickSignInBtn();

		NewsPage NewsPage = new NewsPage(driver);
		NewsPage.newsLinkClick();
		NewsPage.newBtnClick();
		NewsPage.enternewsTextAreaValue("News Add Button test");
		NewsPage.saveBtnClick();

		WebElement successDiv = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		Boolean isalertDisplayed = successDiv.isDisplayed();
		Assert.assertTrue(isalertDisplayed, Messages.NEWS_ASSERTS_SAVE_BUTTON);

	}

	@Test(description = " Verify search news click ")
	public void verifySearchNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.clickSignInBtn();

		String searchString = "news test";
		NewsPage NewsPage = new NewsPage(driver);
		NewsPage.newsLinkClick();
		NewsPage.searchBtnClick();
		NewsPage.enterSearchInput(searchString);
		NewsPage.searchActionBtnClick();

		WebElement newsTableFirstRow = driver
				.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]"));
		String result1 = newsTableFirstRow.getText();

		Boolean isFirstRowContainsSearchString = result1.contains(searchString);
		Assert.assertTrue(isFirstRowContainsSearchString, Messages.NEWS_ASSERTS_SEARCH_BUTTON);
		/*
		 * Another method //assertion WebElement
		 * searchResult=driver.findElement(By.xpath("//td[text()='Breaking News Live']")
		 * ); Assert.assertEquals(searchResult.getText(),
		 * "Breaking News Live","Search result not found");
		 */
	}
}
