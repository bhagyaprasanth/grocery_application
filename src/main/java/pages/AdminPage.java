package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
	public WebDriver driver;

	public AdminPage(WebDriver driver) {

	}

	public void adminPageinkClick() {
		WebElement adminPageink = driver.findElement(By.xpath(
				"//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin' ]"));
		adminPageink.click();
	}

	public void newBtnClick() {
		WebElement newBtn = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newBtn.click();
	}

	public void enterNewUsername(String randomUsernameFaker) {
		WebElement usernameAdminTestFld = driver.findElement(By.id("username"));
		usernameAdminTestFld.sendKeys(randomUsernameFaker);
	}

	public void enternewUserPassword(String randomPasswordFaker) {
		WebElement passwordAdminTestFld = driver.findElement(By.id("password"));
		passwordAdminTestFld.sendKeys(randomPasswordFaker);
	}
	public void selectUsertype(Integer userTypeIndex) {
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='user_type']"));
		Select select = new Select(dropdown);
		select.selectByIndex(userTypeIndex);
	}
	public void saveBtnClick () {
		WebElement saveBtn=driver.findElement(By.xpath("//button[@name='Create']"));
		saveBtn.click();
	}
}
