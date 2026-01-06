package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	WaitUtility waitUtility=new WaitUtility();
	PageUtility pageUtility=new PageUtility();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameFld;

	public void enterUserName(String usernameValue) {

//		WebElement usernameFld = driver.findElement(By.xpath("//input[@name='username']"));
//		usernameFld.sendKeys(usernameValue);
		pageUtility.sendDataToElement(usernameFld,usernameValue);
	}

	@FindBy(xpath="//input[@name='password']") WebElement passwordFld;
	public void enterPassword(String passwordValue) {
//		WebElement passwordFld = driver.findElement(By.xpath("//input[@name='password']"));
//		passwordFld.sendKeys(passwordValue);
		pageUtility.sendDataToElement(passwordFld, passwordValue);
	}
@FindBy(xpath="//button[@type='submit']") WebElement signinBtn;
	public void clickSignInBtn() {
//		WebElement signinBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		waitUtility.waitUntilClickable(driver, signinBtn);
//		signinBtn.click();
		pageUtility.clickOnElement(signinBtn);
	}
}
