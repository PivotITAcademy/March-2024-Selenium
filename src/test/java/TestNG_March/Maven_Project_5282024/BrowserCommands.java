package TestNG_March.Maven_Project_5282024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCommands {

	WebDriver driver;

	@BeforeMethod
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

	}

	@Test
	public void selectValidation() {
		// Filling Form
		driver.findElement(By.id("input-email")).sendKeys("ravneetpoora@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Password1");
		driver.findElement(By.cssSelector("input[type='submit']")).submit();

		driver.findElement(By.cssSelector("#column-right div a:nth-of-type(4)")).click();
		driver.findElement(By.cssSelector("div.buttons div.pull-right a")).click();

		// Find the Webelement
		WebElement selectElement = driver.findElement(By.id("input-country"));
		// Intitalise select class ref variable
		Select sc = new Select(selectElement);

		sc.selectByIndex(11);

		try {
			sc.selectByValue("345");
		} catch (Exception e) {
			sc.selectByVisibleText("China");
		}

	}
	
	@Test
	public void inValodselectValidation() {
		driver.navigate().to("https://www.carbonite.com/personal/trial/");
		// Find the Webelement
		WebElement selectElement = driver.findElement(By.cssSelector("button.css-br4uza"));
		// Intitalise select class ref variable
		Select sc = new Select(selectElement);

		sc.selectByIndex(11);

		try {
			sc.selectByValue("345");
		} catch (Exception e) {
			sc.selectByVisibleText("China");
		}

	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
