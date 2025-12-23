package test_script;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
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
		Assert.assertEquals(homePageURL, currentPageURL, "Did not redirect to home page as expected");
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
		Assert.assertEquals(newsListPageURL, currentPageURL, "Did not redirect to home page as expected");
	}
}
