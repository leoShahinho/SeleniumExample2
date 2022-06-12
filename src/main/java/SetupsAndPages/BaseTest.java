package SetupsAndPages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BaseTest {

	public String MIVF10_URL_PPRD1 = "http://assets-es-pprd.dxlpreprod.local.vodafone.es/";
	public String MIVF10_URL_Sit2 = "https://assets-es-sit2.dxlpreprod.local.vodafone.es/mves/login";
	public WebDriver driver; //Object from the Webdriver to use in the script
	public String resourcesFile = System.getProperty("user.dir")+"\\Treceability and data.xlsx";
	public String usersSheet = "LoginCredentials";
	public String screenshotLocations = "ScreenshotLocations";

	@BeforeMethod
	public void prepareChrome() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Webdrivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get(MIVF10_URL_Sit2);
		driver.manage().window().maximize();

	}


	public WebElement waitForElementToBeVisible(By selector) {
		WebDriverWait wait = new WebDriverWait(driver, 45);
		try {
			return wait.until(
					ExpectedConditions.visibilityOfElementLocated(selector));
		} catch (TimeoutException ex) {
			return null;
		}
	}

	public WebElement waitForElementToBeVisible_WebElement(By WebElement) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		try {
			return wait.until(

					ExpectedConditions.visibilityOfElementLocated(WebElement));

		} catch (TimeoutException ex) {
			return null;
		}
	}

	//@AfterMethod
	public void teardown() throws IOException {
		driver.quit();
	}

	public void takeScreenShot(String path){

		File Source_File = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(Source_File, new File(path));
		} catch (
				IOException e) {
			e.printStackTrace();
		}

	}

	public void SwitchTab()throws InterruptedException{

		String oldTab = driver.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));
		Thread.sleep(20000);
	}

}

