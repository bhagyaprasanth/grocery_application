package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Constants;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestNGBase {
	public HomePage homePage;
	public NewsPage newsPage;
	@Test(description = " Verify home link click ")
	public void verifyHomeLinkClick() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue).enterPassword(passwordValue);
//		loginPage.enterPassword(passwordValue);
		homePage=loginPage.clickSignInBtn();

//		NewsPage NewsPage = new NewsPage(driver);
		newsPage=homePage.newsLinkClick();
		homePage=newsPage.homeLinkClick();

		String homePageURL = "https://groceryapp.uniqassosiates.com/admin/home";
		String currentPageURL = driver.getCurrentUrl();
		Assert.assertEquals(homePageURL, currentPageURL, Messages.NEWS_ASSERTS_HOME_PAGE_LINK);
	}

	@Test(description = " Verify reset link click ")
	public void verifyResetBtnClick() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue).enterPassword(passwordValue);
//		loginPage.enterPassword(passwordValue);
		homePage=loginPage.clickSignInBtn();

		newsPage = new NewsPage(driver);
		homePage.newsLinkClick();
		newsPage.resetLinkClick();

		String newsListPageURL = "https://groceryapp.uniqassosiates.com/admin/list-news";
		String currentPageURL = driver.getCurrentUrl();
		Assert.assertEquals(newsListPageURL, currentPageURL, Messages.NEWS_ASSERTS_HOME_PAGE_LINK);
	}

	@Test(description = " Verify save news click ",groups = {"smoke"})
	public void verifySaveNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue).enterPassword(passwordValue);
//		loginPage.enterPassword(passwordValue);
		homePage=loginPage.clickSignInBtn();

		newsPage = new NewsPage(driver);
//		NewsPage.newsLinkClick();
		homePage.newsLinkClick();
		newsPage.newBtnClick();
		newsPage.enternewsTextAreaValue("News Add Button test");
		newsPage.saveBtnClick();

		boolean isalertDisplayed = newsPage.checkWhetherAlertDisplayed();
		Assert.assertTrue(isalertDisplayed, Messages.NEWS_ASSERTS_SAVE_BUTTON);

	}

	@Test(description = " Verify search news click ")
	public void verifySearchNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameValue).enterPassword(passwordValue);
//		loginPage.enterPassword(passwordValue);
		homePage=loginPage.clickSignInBtn();

		String searchString = "news test";
		NewsPage newsPage = new NewsPage(driver);
		homePage.newsLinkClick();
		newsPage.searchBtnClick();
		newsPage.enterSearchInput(searchString);
		newsPage.searchActionBtnClick();

		boolean isFirstRowContainsSearchString = newsPage.checkWhetherResultMatched(searchString);
		Assert.assertTrue(isFirstRowContainsSearchString, Messages.NEWS_ASSERTS_SEARCH_BUTTON);
		/*
		 * Another method //assertion WebElement
		 * searchResult=driver.findElement(By.xpath("//td[text()='Breaking News Live']")
		 * ); Assert.assertEquals(searchResult.getText(),
		 * "Breaking News Live","Search result not found");
		 */
	}
}
