package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class NewsPage {
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	PageUtility pageUtility=new PageUtility();

	public NewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(linkText = "Home")
	WebElement homeLink;

	public HomePage homeLinkClick() {
//		WebElement homeLink = driver.findElement(By.linkText("Home"));
//		homeLink.click();
		pageUtility.clickOnElement(homeLink);
		return new HomePage(driver);
	}

	@FindBy(linkText = "Reset")
	WebElement resetLink;

	public NewsPage resetLinkClick() {
//		WebElement resetLink = driver.findElement(By.linkText("Reset"));
//		resetLink.click();
		pageUtility.clickOnElement(resetLink);
		return this;
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;

	public NewsPage newBtnClick() {
//		WebElement newBtn = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
//		newBtn.click();
		pageUtility.clickOnElement(newBtn);
		return this;
	}

	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsTextArea;

	public NewsPage enternewsTextAreaValue(String newsText) {
//		WebElement newsTextArea = driver.findElement(By.xpath("//textarea[@id='news']"));
//		newsTextArea.sendKeys(newsText);
		pageUtility.sendDataToElement(newsTextArea, newsText);
		return this;
	}

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveBtn;

	public NewsPage saveBtnClick() {
//		WebElement saveBtn = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
//		saveBtn.click();
		pageUtility.clickOnElement(saveBtn);
		return this;
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;

	public NewsPage searchBtnClick() {
//		WebElement searchBtn = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
//		searchBtn.click();
		pageUtility.clickOnElement(searchBtn);
		return this;
	}

	@FindBy(xpath = "//input[@name='un']")
	WebElement searchInputFld;

	public NewsPage enterSearchInput(String searchString) {
//		WebElement searchInputFld = driver.findElement(By.xpath("//input[@name='un']"));
//		searchInputFld.sendKeys(searchString);
		pageUtility.sendDataToElement(searchInputFld, searchString);
		return this;
	}

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchActionBtn;

	public NewsPage searchActionBtnClick() {
//		WebElement searchActionBtn = driver.findElement(By.xpath("//button[@name='Search']"));
		waitUtility.waitUntilClickable(driver, searchActionBtn);
//		searchActionBtn.click();
		pageUtility.clickOnElement(searchActionBtn);
		return this;
	}

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successDiv;

	public boolean checkWhetherAlertDisplayed() {
//		WebElement successDiv = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		boolean isalertDisplayed = successDiv.isDisplayed();
		return isalertDisplayed;
	}

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]")
	WebElement newsTableFirstRow;

	public boolean checkWhetherResultMatched(String searchString) {
		String result1 = newsTableFirstRow.getText();
		return result1.contains(searchString);
	}
}
