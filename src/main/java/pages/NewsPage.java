package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class NewsPage {
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();

	public NewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement newsLink;

	public void newsLinkClick() {
//		WebElement newsLink = driver.findElement(By.xpath("//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']"));
		newsLink.click();
	}

	@FindBy(linkText = "Home")
	WebElement homeLink;

	public void homeLinkClick() {
//		WebElement homeLink = driver.findElement(By.linkText("Home"));
		homeLink.click();
	}

	@FindBy(linkText = "Reset")
	WebElement resetLink;

	public void resetLinkClick() {
//		WebElement resetLink = driver.findElement(By.linkText("Reset"));
		resetLink.click();
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;

	public void newBtnClick() {
//		WebElement newBtn = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newBtn.click();
	}

	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsTextArea;

	public void enternewsTextAreaValue(String newsText) {
//		WebElement newsTextArea = driver.findElement(By.xpath("//textarea[@id='news']"));
		newsTextArea.sendKeys(newsText);
	}

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveBtn;

	public void saveBtnClick() {
//		WebElement saveBtn = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		saveBtn.click();
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;

	public void searchBtnClick() {
//		WebElement searchBtn = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
		searchBtn.click();
	}

	@FindBy(xpath = "//input[@name='un']")
	WebElement searchInputFld;

	public void enterSearchInput(String searchString) {
//		WebElement searchInputFld = driver.findElement(By.xpath("//input[@name='un']"));
		searchInputFld.sendKeys(searchString);
	}

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchActionBtn;

	public void searchActionBtnClick() {
//		WebElement searchActionBtn = driver.findElement(By.xpath("//button[@name='Search']"));
		waitUtility.waitUntilClickable(driver, searchActionBtn);
		searchActionBtn.click();
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
