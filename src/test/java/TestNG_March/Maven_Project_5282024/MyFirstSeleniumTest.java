package TestNG_March.Maven_Project_5282024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstSeleniumTest {

	@Test
	public void validateLoginFunctionlality() {

		// Setup the logic of driver
		WebDriverManager.edgedriver().setup();

		// Intialise a driver instance
		WebDriver driver = new EdgeDriver();

		// Load a Page URL
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// Identify Elements on DOM
		WebElement loginInputElement1= driver.findElement(By.id("input-email"));
		driver.navigate().refresh();
		loginInputElement1= driver.findElement(By.id("input-email"));
		loginInputElement1.sendKeys("katepqa@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Tester01");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// close Browser
		driver.close();

	}

}
