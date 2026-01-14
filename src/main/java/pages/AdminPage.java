package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	PageUtility pageUtility=new PageUtility();

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;

	public AdminPage newBtnClick() {
//		WebElement newBtn = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		waitUtility.waitUntilClickable(driver, newBtn);
//		newBtn.click();
		pageUtility.clickOnElement(newBtn);
		return this;
	}

	@FindBy(id = "username")
	WebElement usernameAdminTestFld;

	public AdminPage enterNewUsername(String randomUsernameFaker) {
//		WebElement usernameAdminTestFld = driver.findElement(By.id("username"));
//		usernameAdminTestFld.sendKeys(randomUsernameFaker);
		pageUtility.sendDataToElement(usernameAdminTestFld, randomUsernameFaker);
		return this;
	}

	@FindBy(id = "password")
	WebElement passwordAdminTestFld;

	public AdminPage enternewUserPassword(String randomPasswordFaker) {
//		WebElement passwordAdminTestFld = driver.findElement(By.id("password"));
//		passwordAdminTestFld.sendKeys(randomPasswordFaker);
		pageUtility.sendDataToElement(passwordAdminTestFld, randomPasswordFaker);
		return this;
	}

	@FindBy(xpath = "//select[@id='user_type']")
	WebElement dropdown;

	public AdminPage selectUsertype(int userTypeIndex) {
//		WebElement dropdown = driver.findElement(By.xpath("//select[@id='user_type']"));
//		Select select = new Select(dropdown);
//		select.selectByIndex(userTypeIndex);
		pageUtility.selectDataWithIndex(dropdown,userTypeIndex);
		return this;
	}

	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveBtn;

	public AdminPage saveBtnClick() {
//		WebElement saveBtn = driver.findElement(By.xpath("//button[@name='Create']"));
		waitUtility.waitUntilClickable(driver, saveBtn);
		pageUtility.clickOnElement(saveBtn);
//		saveBtn.click();
		return this;
	}

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertDiv;

	public boolean checkWhetheralertDisplayed() {
//		WebElement alertDiv = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		boolean alertDispayedFlag = alertDiv.isDisplayed();
		return alertDispayedFlag;
	}
}
