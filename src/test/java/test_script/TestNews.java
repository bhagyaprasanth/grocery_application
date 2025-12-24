package test_script;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Messages;
import utilities.ExcelUtility;

public class TestNews extends TestNGBase {
	@Test
	public void verifyHomeLinkClick() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement usernameFld = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordFld = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement signinBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		usernameFld.sendKeys(usernameValue);
		passwordFld.sendKeys(passwordValue);
		signinBtn.click();
		WebElement newsLink = driver.findElement(By.xpath(
				"//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']"));
		newsLink.click();
		WebElement homeLink = driver.findElement(By.linkText("Home"));
		homeLink.click();
		String homePageURL = "https://groceryapp.uniqassosiates.com/admin/home";
		String currentPageURL = driver.getCurrentUrl();
		Assert.assertEquals(homePageURL, currentPageURL, Messages.NEWS_ASSERTS_HOME_PAGE_LINK);
	}

	@Test
	public void verifyResetBtnClick() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement usernameFld = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordFld = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement signinBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		usernameFld.sendKeys(usernameValue);
		passwordFld.sendKeys(passwordValue);
		signinBtn.click();
		WebElement newsLink = driver.findElement(By.xpath(
				"//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']"));
		newsLink.click();
		WebElement resetLink = driver.findElement(By.linkText("Reset"));
		resetLink.click();
		String newsListPageURL = "https://groceryapp.uniqassosiates.com/admin/list-news";
		String currentPageURL = driver.getCurrentUrl();
		Assert.assertEquals(newsListPageURL, currentPageURL, Messages.NEWS_ASSERTS_HOME_PAGE_LINK);
	}

	@Test
	public void verifySaveNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement usernameFld = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordFld = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement signinBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		usernameFld.sendKeys(usernameValue);
		passwordFld.sendKeys(passwordValue);
		signinBtn.click();
		WebElement newsLink = driver.findElement(By.xpath(
				"//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']"));
		newsLink.click();
		WebElement newBtn = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newBtn.click();
		WebElement newsTextArea = driver.findElement(By.xpath("//textarea[@id='news']"));
		newsTextArea.sendKeys("News Add Button test");

		WebElement saveBtn = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		saveBtn.click();
		WebElement successDiv = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		Boolean isalertDisplayed = successDiv.isDisplayed();
		Assert.assertTrue(isalertDisplayed, Messages.NEWS_ASSERTS_SAVE_BUTTON);

	}

	@Test
	public void verifySearchNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement usernameFld = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordFld = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement signinBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		usernameFld.sendKeys(usernameValue);
		passwordFld.sendKeys(passwordValue);
		signinBtn.click();
		
		WebElement newsLink = driver.findElement(By.xpath(
				"//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']"));
		newsLink.click();
		
		WebElement searchBtn=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
		searchBtn.click();
		
		WebElement searchInputFld=driver.findElement(By.xpath("//input[@name='un']"));		
		String searchString="news test";
		searchInputFld.sendKeys(searchString);
		
		WebElement searchActionBtn=driver.findElement(By.xpath("//button[@name='Search']"));
		searchActionBtn.click();
		
		WebElement newsTableFirstRow=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]"));
		String result1=newsTableFirstRow.getText();

		Boolean isFirstRowContainsSearchString=result1.contains(searchString);
		Assert.assertTrue(isFirstRowContainsSearchString, Messages.NEWS_ASSERTS_SEARCH_BUTTON);
	}
}
