package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {

	}

	public void adminIconClick() {
		WebElement adminIcon = driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
		adminIcon.click();
	}

	public void logoutBtnClick() {
		WebElement logoutBtn = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
		logoutBtn.click();
	}
}
