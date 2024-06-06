package TestNG_March.Maven_Project_5282024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {

	WebDriver driver;

	@BeforeMethod
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

	}

	@Test
	public void validateToMethod() {
		driver.navigate().to("https://www.google.ca/");

	}

	@Test
	public void navigationCmd() {
		// Filling Form
		driver.findElement(By.id("input-email")).sendKeys("ravneetpoora@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Password1");
		driver.findElement(By.cssSelector("input[type='submit']")).submit();

		//Refresh the page
		driver.navigate().refresh();
		
		//Back
		driver.navigate().back();
		
		//Forward
		driver.navigate().forward();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
