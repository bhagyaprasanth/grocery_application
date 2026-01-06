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
	public void adminIconClick() {
//		WebElement adminIcon = driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
//		adminIcon.click();
		pageUtility.clickOnElement(adminIcon);
	}

	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutBtn;
	public void logoutBtnClick() {
//		WebElement logoutBtn = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
		waitUtility.waitUntilClickable(driver, logoutBtn);
//		logoutBtn.click();
		pageUtility.clickOnElement(logoutBtn);
	}
}
