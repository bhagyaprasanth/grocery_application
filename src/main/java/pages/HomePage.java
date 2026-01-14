package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {

	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	PageUtility pageUtility=new PageUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")
	WebElement adminIcon;
	public HomePage adminIconClick() {
//		WebElement adminIcon = driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
//		adminIcon.click();
		pageUtility.clickOnElement(adminIcon);
		return this;
	}

	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutBtn;
	public LoginPage logoutBtnClick() {
//		WebElement logoutBtn = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
		waitUtility.waitUntilClickable(driver, logoutBtn);
//		logoutBtn.click();
		pageUtility.clickOnElement(logoutBtn);
		return new LoginPage(driver);
	}
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement newsLink;

	public NewsPage newsLinkClick() {
//		WebElement newsLink = driver.findElement(By.xpath("//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']"));
//		newsLink.click();

		pageUtility.clickOnElement(newsLink);
		return new NewsPage(driver);
	}
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminPageink;

	public AdminPage adminPageinkClick() {
//		WebElement adminPageink = driver.findElement(By.xpath("//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin' ]"));
//		adminPageink.click();

		pageUtility.clickOnElement(adminPageink);
		return new AdminPage(driver);
	}
}
