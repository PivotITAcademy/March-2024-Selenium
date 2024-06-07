package TestNG_March.Maven_Project_5282024;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionExample {
	WebDriver driver;
	Actions actions;

	@BeforeMethod
	public void setUpBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://demoqa.com/buttons");
		actions = new Actions(driver);
	}

	@Test
	public void validateRightClick() {
		WebElement rightClickBtn = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
		actions.contextClick(rightClickBtn).perform();
		String rightClickSuccessText = driver.findElement(By.id("rightClickMessage")).getText();
		Assert.assertEquals("Right click not performed", rightClickSuccessText, "You have done a right click");
	}

	@Test
	public void validateDoubleClick() {
		WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
		actions.doubleClick(doubleClickBtn).perform();
		String doublClickSuccessText = driver.findElement(By.id("doubleClickMessage")).getText();
		Assert.assertEquals("Double click not performed", doublClickSuccessText, "You have done a double click");
	}
	
	@Test
	public void validateToolTip() throws InterruptedException {
		driver.navigate().to("https://demoqa.com/tool-tips");
		WebElement mouseHover = driver.findElement(By.id("toolTipButton"));
		actions.moveToElement(mouseHover).perform();
		Thread.sleep(2000);
		String attributeVal=mouseHover.getAttribute("aria-describedby");
		Assert.assertEquals("Double click not performed", attributeVal, "buttonToolTip");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
