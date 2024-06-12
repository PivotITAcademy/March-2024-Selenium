package TestNG_March.Maven_Project_5282024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementsCmd {

	WebDriver driver;

	@BeforeMethod
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

	}

	@Test
	public void validateSignUp() {
		// Filling Form
		driver.findElement(By.id("input-firstname")).sendKeys("Munna");
		driver.findElement(By.id("input-lastname")).sendKeys("Thakur");
		driver.findElement(By.id("input-email")).sendKeys("Munna4@it.com");

		driver.findElement(By.id("input-telephone")).sendKeys("4209211");

		// Setting Up Password
		driver.findElement(By.id("input-password")).sendKeys("Password1");
		driver.findElement(By.id("input-confirm")).sendKeys("Password1");

		// Checking the check box
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();

		// Submit the form
		driver.findElement(By.cssSelector("input[type='checkbox']")).submit();

		String accountCreatedText = driver.findElement(By.cssSelector("#content h1")).getText();

		Assert.assertEquals(accountCreatedText, "Your Account Has Been Created!",
				"Account creation text did not match");

		boolean isContactUsLinkDisplayed = driver.findElement(By.cssSelector("#content>p:nth-of-type(4) a"))
				.isDisplayed();

		Assert.assertTrue(isContactUsLinkDisplayed, "Contact us link is not displayed");

	}

	@Test
	public void validatelogin() {
		// Filling Form
		driver.findElement(By.id("input-firstname")).sendKeys("Munna");
		driver.findElement(By.id("input-lastname")).sendKeys("Thakur");
		driver.findElement(By.id("input-email")).sendKeys("Munna5@it.com");

		driver.findElement(By.id("input-telephone")).sendKeys("4209211");

		// Setting Up Password
		driver.findElement(By.id("input-password")).sendKeys("Password1");
		driver.findElement(By.id("input-confirm")).sendKeys("Password1");

		// Checking the check box
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();

		// Submit the form
		driver.findElement(By.cssSelector("input[type='checkbox']")).submit();

		String accountCreatedText = driver.findElement(By.cssSelector("#content h1")).getText();

		Assert.assertEquals(accountCreatedText, "Your Account Has Been Created!",
				"Account creation text did not match");

		boolean isContactUsLinkDisplayed = driver.findElement(By.cssSelector("#content>p:nth-of-type(4) a"))
				.isDisplayed();

		Assert.assertTrue(isContactUsLinkDisplayed, "Contact us link is not displayed");

	}

	@Test
	public void validateForgotPassword() {
		// Filling Form
		driver.findElement(By.id("input-firstname")).sendKeys("Munna");
		driver.findElement(By.id("input-lastname")).sendKeys("Thakur");
		driver.findElement(By.id("input-email")).sendKeys("Munna3@it.com");

		driver.findElement(By.id("input-telephone")).sendKeys("4209211");

		// Setting Up Password
		driver.findElement(By.id("input-password")).sendKeys("Password1");
		driver.findElement(By.id("input-confirm")).sendKeys("Password1");

		// Checking the check box
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();

		// Submit the form
		driver.findElement(By.cssSelector("input[type='checkbox']")).submit();

		String accountCreatedText = driver.findElement(By.cssSelector("#content h1")).getText();

		Assert.assertEquals(accountCreatedText, "Your Account Has Been Created!",
				"Account creation text did not match");

		boolean isContactUsLinkDisplayed = driver.findElement(By.cssSelector("#content>p:nth-of-type(4) a"))
				.isDisplayed();

		Assert.assertTrue(isContactUsLinkDisplayed, "Contact us link is not displayed");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
