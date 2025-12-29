package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsPage {
	public WebDriver driver;

	public NewsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void newsLinkClick() {
		WebElement newsLink = driver.findElement(By.xpath(
				"//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']"));
		newsLink.click();
	}

	public void homeLinkClick() {
		WebElement homeLink = driver.findElement(By.linkText("Home"));
		homeLink.click();
	}

	public void resetLinkClick() {
		WebElement resetLink = driver.findElement(By.linkText("Reset"));
		resetLink.click();
	}

	public void newBtnClick() {
		WebElement newBtn = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newBtn.click();
	}

	public void enternewsTextAreaValue(String newsText) {
		WebElement newsTextArea = driver.findElement(By.xpath("//textarea[@id='news']"));
		newsTextArea.sendKeys(newsText);
	}

	public void saveBtnClick() {
		WebElement saveBtn = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		saveBtn.click();
	}

	public void searchBtnClick() {
		WebElement searchBtn = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
		searchBtn.click();
	}

	public void enterSearchInput(String searchString) {
		WebElement searchInputFld = driver.findElement(By.xpath("//input[@name='un']"));
		searchInputFld.sendKeys(searchString);
	}

	public void searchActionBtnClick() {
		WebElement searchActionBtn = driver.findElement(By.xpath("//button[@name='Search']"));
		searchActionBtn.click();
	}
}
