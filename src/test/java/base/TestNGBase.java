package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenshotUtility;

public class TestNGBase {

	public WebDriver driver;
	Properties prop;
	FileInputStream f;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		prop = new Properties();
		f= new FileInputStream(Constants.CONFIGFILE);
		prop.load(f); //built in function to load properties file

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid browsername");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();

	}
}
