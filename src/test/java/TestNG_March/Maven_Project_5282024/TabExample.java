package TestNG_March.Maven_Project_5282024;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TabExample {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUpBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
	}

	@Test
	public void switchToTabs() {
		String parentHandle = driver.getWindowHandle();
		System.out.println(parentHandle);

		driver.findElement(By.id("tabButton")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(parentHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}

		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
		//returing to parent window
		driver.switchTo().window(parentHandle);
		
		System.out.println(driver.findElement(By.cssSelector("#browserWindows h1")).getText());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
