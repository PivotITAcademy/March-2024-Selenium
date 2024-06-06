package TestNG_March.Maven_Project_5282024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleSelect {

	WebDriver driver;

	@BeforeMethod
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//maximise
		driver.manage().window().maximize();

	}

	@Test
	public void validateGetTitle() {
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Munni Badnaam", "Page URL is not correct");

	}

	@Test
	public void validateGetPageUrl() {
		// Filling Form
		driver.findElement(By.id("input-email")).sendKeys("ravneetpoora@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Password1");
		driver.findElement(By.cssSelector("input[type='submit']")).submit();

		String pageTitle = driver.getCurrentUrl();
		Assert.assertEquals(pageTitle, "Munni Badnaam", "Page Title is not correct");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
