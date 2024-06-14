package TestNG_March.Maven_Project_5282024;

import java.time.Duration;

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

public class IframeExample {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUpBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
	}

	@Test
	public void switchToIframe() {
		//driver.switchTo().frame("Wake Up Now");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Wake Up Now!!!!"));	
		String textFromIframe1 = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(textFromIframe1);
		driver.switchTo().defaultContent();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame2"));
		String textFromIframe2 = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(textFromIframe2);
		
		driver.switchTo().defaultContent();
		String mainWindowText=driver.findElement(By.cssSelector("#framesWrapper h1")).getText();
		System.out.println(mainWindowText);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
