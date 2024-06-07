package TestNG_March.Maven_Project_5282024;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleOfWait {

	WebDriver driver;

	@BeforeMethod
	public void setUpBrowser() {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.webroot.com/us/en");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@Test
	public void selectValidation() {

		driver.findElement(By.cssSelector("#onetrust-button-group>button:last-of-type")).click();
		System.out.println("Btn was clicked");
	}
	
	@Test
	public void tokyoTreatValidation() {
		driver.navigate().to("https://tokyotreat.com/subscribe");
		String text=driver.findElement(By.xpath("//span[text()='YOUR FIRST ORDER']")).getText();
		System.out.println(text);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
